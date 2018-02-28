package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
*@author: pele
*@time: 2018/2/26 14:16
*@project: CrazyJava
*@description:statement.excuteUpdate方法示例
*/
public class ExcuteDML {
    private String driver;
    private String url;
    private String user;
    private String passwd;
    public void initParam(String paramFileName) throws IOException {
        //使用Properties类来加载属性文件
        Properties properties = new Properties();
        properties.load(new FileInputStream(paramFileName));
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        passwd = properties.getProperty("passwd");
    }
    public int insertData(String sql) throws Exception {
        //加载驱动
        Class.forName("driver");
        try(
            //获取数据库连接
            Connection connection = DriverManager.getConnection(url);
            //使用Connection创建一个Statement对象
            Statement stmt = connection.createStatement();
            ){
            //执行DML语句，返回受影响的的记录条数
            return stmt.executeUpdate(sql);
        }
    }
    public static void main(String[] args) throws Exception {
        ExcuteDML excuteDML = new ExcuteDML();
        excuteDML.initParam("mysql.ini");
        int result = excuteDML.insertData("");
    }
}
