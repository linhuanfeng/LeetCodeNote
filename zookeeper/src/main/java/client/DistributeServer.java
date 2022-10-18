package client;

import org.apache.zookeeper.*;

import java.io.IOException;

public class DistributeServer {
    private String connectString="192.168.42.100:2181,192.168.42.101:2181,192.168.42.102:2181";
    private int sessionTimeout=100000;
    private ZooKeeper zkClient;

    void getConnect() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            public void process(WatchedEvent event) {
                System.out.println("时间：" + event);
            }
        });
        System.out.println("state:"+zkClient.getState());
    }

    private void registerServer(String path) throws KeeperException, InterruptedException {
        String nodeCreated = zkClient.create(path, "s1:127.0.0.1:80".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("nodeCreated:"+nodeCreated);
    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        DistributeServer distributeServer = new DistributeServer();
        distributeServer.getConnect();
        distributeServer.registerServer("/servers/s1");
        System.out.println("开启业务功能");
        System.in.read(); //阻塞住，防止断开连接
    }
}
