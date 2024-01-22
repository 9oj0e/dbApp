package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getInstance(){
        String username = "root";
        String password = "1234";
        String url = "jdbc:mariadb://localhost:3306/cosdb"; // 프로토콜은 maria/oracle 에 따라 다르다. 찾아야한다.

        // 프로토콜이 적용된 소켓
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Successfully connected with DB");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
