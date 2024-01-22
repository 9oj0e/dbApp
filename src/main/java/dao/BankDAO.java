package dao;

import db.DBConnection;
import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankDAO {
    public int customQuery(String sql) {
        Connection conn = DBConnection.getInstance();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            int num = pstmt.executeUpdate();
            ResultSet rs = pstmt.executeQuery(); // flush후 받은 결과를 rs에 담는다.

            List<Account> accountList = new ArrayList<>();
            while (rs.next()) {
                Account account = new Account(
                        rs.getInt("number"),
                        rs.getString("password"),
                        rs.getInt("balance"),
                        rs.getTimestamp("created_at")
                );
                accountList.add(account);
            }
            return num;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int insert(String password, int balance) {
        Connection conn = DBConnection.getInstance();
        try {

            String sql = "insert into account_tb(password, balance, created_at) values(?, ?, now())";
            // LocalDateTime대신 now()를 쓰는 이유. 현재 시각은 DB에 저장되는 시점 위치에서 결정되어야함.
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, password);
            pstmt.setInt(2, balance);
            int num = pstmt.executeUpdate(); // flush된 결과를 num에 저장
            return num;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int updateByNum(int balance, int number) {
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "update account_tb set balance = ? where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, balance);
            pstmt.setInt(2, number);
            int num = pstmt.executeUpdate(); // flush된 결과를 num에 저장
            return num;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int deleteByNum(int number) {
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "delete from account_tb where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, number);
            int num = pstmt.executeUpdate(); // flush된 결과를 num에 저장
            return num;
        } catch (Exception e) {
            e.printStackTrace(); // 호출자에게 throw하지 않는다.
        }
        return -1;
    }

    public Account selectByNum(int num) {
        Connection conn = DBConnection.getInstance();
        String sql = null;
        try {
            sql = "select * from account_tb where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);

            ResultSet rs = pstmt.executeQuery(); // table형태의 data를 반환

            boolean isRow = rs.next(); // 커서 한 칸 내리기
            if (isRow) {
                Account account = new Account(
                        rs.getInt("number"),
                        rs.getString("password"),
                        rs.getInt("balance"),
                        rs.getTimestamp("created_at")
                );
                return account;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Account> selectAll() {
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "SELECT * FROM account_tb ORDER BY NUMBER desc"; // 최근 결과부터 나와야 한다.
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery(); // flush후 받은 결과를 rs에 담는다.

            List<Account> accountList = new ArrayList<>();
            while (rs.next()) {
                Account account = new Account(
                        rs.getInt("number"),
                        rs.getString("password"),
                        rs.getInt("balance"),
                        rs.getTimestamp("created_at")
                );
                accountList.add(account);
            }
            return accountList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
