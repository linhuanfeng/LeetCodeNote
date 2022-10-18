package 结构型模式.桥接模式.jdbc的驱动例子;

/**
 *
 *
 * JDBC把面向厂商的接口（Driver）和面向使用者的API(DriverManager进行拆分隔离)
 * // 开发者只需要关注JDBC API（即connection）, 无需关注不同数据库Driver接口实现
 * Class.forName("com.mysql.jdbc.Driver"); // 各个厂商driver的static方法会往DriverManager注册Driver驱动
 * Connection conn = DriverManager.getConnection(url, username, password);
 *
 *
 * public class DriverManager {
 *
 *
 *     // List of registered JDBC drivers
 *     private final static CopyOnWriteArrayList<DriverInfo> registeredDrivers = new CopyOnWriteArrayList<>();
 *
 *    public static synchronized void registerDriver(java.sql.Driver driver,DriverAction da)throws SQLException {
 *
 *     if(driver != null) {
 *         registeredDrivers.addIfAbsent(new DriverInfo(driver, da));
 *     } else {
 *         // This is for compatibility with the original DriverManager
 *         throw new NullPointerException();
 *     }
 *
 *     println("registerDriver: " + driver);
 *
 * }
 *
 * // 各种数据库厂商就往里面DriverManager注册驱动
 * public class Driver extends NonRegisteringDriver implements java.sql.Driver {
 *     //
 *     // Register ourselves with the DriverManager
 *     //
 *     static {
 *         try {
 *             java.sql.DriverManager.registerDriver(new Driver());
 *         } catch (SQLException E) {
 *             throw new RuntimeException("Can't register driver!");
 *         }
 *     }
 *
 *
 */
public class Test {
}
