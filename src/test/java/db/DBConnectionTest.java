package db;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTest { //test파일의 class는 이름 끝에 Test

    @Test
    public void getInstance_test(){ //test파일의 메서드는 이름 끝에 _test
        // when = 본 코드 실행
        Connection conn = DBConnection.getInstance();
        // then = 눈 검증
        if (conn == null){
            System.out.println("실패");
        } else {
            System.out.println("성공");
        }
    }
}
