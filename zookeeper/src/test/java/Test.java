import org.apache.zookeeper.*;
import org.junit.Before;

import java.io.IOException;


public class Test {

    private String connectString="192.168.42.100:2181,192.168.42.101:2181,192.168.42.102:2181";
    private static int sessionTimeout=100000;
    private static ZooKeeper zkClient;
    @Before
    public void init() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            public void process(WatchedEvent event) {
                System.out.println("时间：" + event);
            }
        });
        System.out.println("state:"+zkClient.getState());
    }

    @org.junit.Test
    public void createNode() throws KeeperException, InterruptedException {
        String path="/sanguo/hanxin";
        String nodeCreated = zkClient.create(path, "123123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("nodeCreated:"+nodeCreated);
    }

    @org.junit.Test
    public void testExists() throws KeeperException, InterruptedException {
        String path="/sanguo/hanxin";
        System.out.println(path+"isExist:"+zkClient.exists(path, false));
    }
}
