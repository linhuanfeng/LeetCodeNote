package client;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.ZooKeeper;

public class CuratorLockTest {
    private String connectString = "192.168.42.100:2181,192.168.42.101:2181,192.168.42.102:2181";
    private int sessionTimeout = 100000;
    private String locks = "/locks";
    public static void main(String[] args) {
        new CuratorLockTest().test();
    }
    private void test(){
        InterProcessMutex mutex1 = new InterProcessMutex(getCuratorFramework(), locks);
        InterProcessMutex mutex2 = new InterProcessMutex(getCuratorFramework(), locks);
        new Thread(()->{
            try {
                mutex1.acquire();
                System.out.println("线程一获取到锁");
                mutex1.acquire();
                System.out.println("线程再次获取到锁");
                Thread.sleep(3000);
                mutex1.release();
                System.out.println("线程一释放锁");
                mutex1.release();
                System.out.println("线程一再次释放锁");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                mutex2.acquire();
                System.out.println("线程二获取到锁");
                mutex2.acquire();
                System.out.println("线程再次获取到锁");
                Thread.sleep(3000);
                mutex2.release();
                System.out.println("线程二释放锁");
                mutex2.release();
                System.out.println("线程二再次释放锁");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
    private CuratorFramework getCuratorFramework(){
        ExponentialBackoffRetry policy = new ExponentialBackoffRetry(3000, 3);
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(connectString)
                .connectionTimeoutMs(sessionTimeout)
                .retryPolicy(policy).build();

        // 开启连接
        client.start();
        System.out.println("zookeeper初始化完成");
        return client;
    }
}
