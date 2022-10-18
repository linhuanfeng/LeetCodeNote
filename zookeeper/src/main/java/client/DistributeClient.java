package client;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;

public class DistributeClient {
    private String connectString = "192.168.42.100:2181,192.168.42.101:2181,192.168.42.102:2181";
    private int sessionTimeout = 100000;
    private ZooKeeper zkClient;
    private String path = "/servers";

    void getConnect() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            public void process(WatchedEvent event) {
                try {
                    System.out.println("event：" + event);
                    getServerList();
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("state:" + zkClient.getState());
    }

    private void getServerList() throws KeeperException, InterruptedException {
        // 获取服务器子节点信息，并进行监听
        List<String> children = zkClient.getChildren(path, true);
        for (String child : children) {
            byte[] serverAddr = zkClient.getData(path + "/" + child, false, null);
            System.out.println("serverAddr:"+new String(serverAddr));
        }
    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        DistributeClient distributeServer = new DistributeClient();
        distributeServer.getConnect();
        distributeServer.getServerList();
        System.out.println("开启业务功能");
        System.in.read();
    }
}
