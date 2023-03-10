package 代码阅读.距离生日多久;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    /**
     * 计算距离生日 2000-04-04 2000-12-06
     *
     * @param birthStr 2000-04-04
     * @param date 当前时间
     * @return
     */
    private int calBirth(String birthStr, Date date) throws ParseException {
        int day = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birth = simpleDateFormat.parse(birthStr);
            // 存当前时间
            Calendar now = Calendar.getInstance();
            now.setTime(date);
            // 存生日
            Calendar birthCal = Calendar.getInstance();
            birthCal.setTime(birth);
            // 把生日设置为今年
            birthCal.set(Calendar.YEAR, now.get(Calendar.YEAR));

            if (now.get(Calendar.DAY_OF_YEAR) - birthCal.get(Calendar.DAY_OF_YEAR) > 0) {
                // 生日已过
                birthCal.set(Calendar.YEAR, now.get(Calendar.YEAR) + 1);
                day = now.getActualMaximum(Calendar.DAY_OF_YEAR) - now.get(Calendar.DAY_OF_YEAR) + birthCal.get(Calendar.DAY_OF_YEAR);
            } else {
                // 生日未过
                day = birthCal.get(Calendar.DAY_OF_YEAR) - now.get(Calendar.DAY_OF_YEAR);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }
}
