package java8接口.lamda接口回调;

import java.util.List;

@FunctionalInterface
public interface UpdateCallback {
    void update(List<String> latestUrls);
}
