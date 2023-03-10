package java8接口.lamda接口回调;

import java.util.ArrayList;
import java.util.List;

public class ZKRegistry {
    public static List<String> discovery(UpdateCallback updateCallback){
        List<String> curList=new ArrayList<>();
        curList.add("old");
        curList.add("old");
        // 异步提交给zk监听器，参数为updateCallback，如果有事件更新，触发回调
        new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("服务结点更新事件触发回调...");
            List<String> latestList=new ArrayList<>();
            latestList.add("new");
            latestList.add("new");
            updateCallback.update(latestList);
        }).start();
        return curList;
    }
}
