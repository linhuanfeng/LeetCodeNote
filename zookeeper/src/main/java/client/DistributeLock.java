package client;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class DistributeLock {
    private String connectString = "192.168.42.100:2181,192.168.42.101:2181,192.168.42.102:2181";
    private int sessionTimeout = 100000;
    private ZooKeeper zkClient;
    private String locks = "/locks";
    private String subLock = "sub-";
    private String curNode="";
    private String waitPath="";
    private CountDownLatch waitLatch=new CountDownLatch(1);

    public DistributeLock() throws IOException, KeeperException, InterruptedException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            public void process(WatchedEvent event) {
                log.info("event：{}" , event);
                if(event.getType()== Event.EventType.NodeDeleted&&event.getPath().equals(waitPath)){
                    log.info("监听到了前一个结点的删除事件:{}",event);
                    waitLatch.countDown(); // 监听到了前一个结点的删除事件
                }
            }
        });
        log.info("state:{}" , zkClient.getState());
        Stat stat = zkClient.exists(locks, false);
        if(stat==null){
            String name = zkClient.create(locks, "分布式".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            log.info("创建了：{}",name);
        }
    }

    public void zkUnlock() {
        try {
            zkClient.delete(this.curNode,-1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    public void zkLock() throws KeeperException, InterruptedException {
        // 在根节点下创建临时结点
        this.curNode=zkClient.create(locks + "/" + subLock, "我是锁".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        log.info("创建了锁：{}",curNode);
        List<String> children = zkClient.getChildren(locks, false);
        if(children.size()==1){
            return; // 只有当前结点，肯定获取到了锁，直接返回
        }else if(children.size()<1){
            throw new RuntimeException("结点列表直到的有一个");
        }
        else {
            // 遍历子节点，判断子集是否是第一个结点
            Collections.sort(children);
            int idx = children.indexOf(curNode.substring(curNode.lastIndexOf("/")+1));
            if(idx==-1)
                throw new RuntimeException("至少的有一个结点(当前结点)");
            else  if(idx==0){
                log.info("获取锁成功");
                return; // 我是第一个，那么获取锁成功，返回
            }
            else {
                // 关注前一个结点的删除事件
                this.waitPath=locks+"/"+children.get(idx-1);
                zkClient.getData(waitPath,true,null); // 关注i去拿一个结点
                log.info("阻塞中，等待锁{}释放..",this.waitPath);
                waitLatch.await(); // 等待获取锁
                return;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
        new Thread(()->{
            DistributeLock lock = null;
            try {
                lock = new DistributeLock();
                log.info("线程{}准备获取锁",Thread.currentThread().getName());
                Thread.sleep(2000);
                lock.zkLock();
                log.info("线程{}成功获取锁",Thread.currentThread().getName());
                System.out.println("输入回车解锁");
                System.in.read();
                lock.zkUnlock();
                log.info("线程{}成功释放锁",Thread.currentThread().getName());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            DistributeLock lock = null;
            try {
                lock = new DistributeLock();
                log.info("线程{}准备获取锁",Thread.currentThread().getName());
                Thread.sleep(2000);
                lock.zkLock();
                log.info("线程{}成功获取锁",Thread.currentThread().getName());
                System.out.println("输入回车解锁");
                System.in.read();
                lock.zkUnlock();
                log.info("线程{}成功释放锁",Thread.currentThread().getName());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
