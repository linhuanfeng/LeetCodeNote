package java8接口.lamda接口回调;

import java.util.List;

// 传递回调函数给registry,回调更新服务列表
public class Test {
    public static void main(String[] args) {
        List<String> curList = ZKRegistry.discovery(latestList->{
            System.out.println("最新服务列表");
            for (String latest : latestList) {
                System.out.print(latest+" ");
            }
        });
        System.out.println("当前服务列表");
        for (String cur : curList) {
            System.out.print(cur+" ");
        }
    }
}
