package 试题A星期计算;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime time = now.plusDays((long) (Math.pow(20, 22)%7));
        System.out.println(time.getDayOfWeek()); // SUNDAY
    }
}
