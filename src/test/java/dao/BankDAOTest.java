package dao;

import model.Account;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BankDAOTest {
    @Test
    public void selectAll_test(){
        BankDAO dao = new BankDAO();
        List<Account> accountList = dao.selectAll();

        System.out.println(accountList.size());
        System.out.println(accountList);

    }
    @Test
    public void selectByNum_test(){
        // given
        int num = 8;
        // when
        BankDAO dao = new BankDAO();
        Account account = dao.selectByNum(num);

        // then
        if (account == null){
            System.out.println(num+"으로 조회된 값이 없습니다");
        } else {
            System.out.println(account);
//            System.out.println(account.getNumber());
//            System.out.println(account.getPassword());
//            System.out.println(account.getBalance());
//            System.out.println(account.getCreatedAt());
        }
    }
    @Test
    public void deleteByNum_test(){
        // given
        int num = 100;

        // when
        BankDAO dao = new BankDAO();
        int result = dao.deleteByNum(num);

        // then
        if (result == 1) {
            System.out.println("삭제 성공");
        } else if (result == 0){
            System.out.println(num+"행을 찾을 수 없습니다.");
        } else {
            System.out.println("삭제 실패");
        }
    }
    @Test
    public void insert_test(){
        // given
        String password = "abcd";
        int balance = 1111;

        // when
        BankDAO dao = new BankDAO();
        int result = dao.insert(password, balance);

        // then
        if (result == 1) {
            System.out.println("추가 성공");
        } else {
            System.out.println("추가 실패");
        }
    }

    @Test
    public void updateByNum_test(){
        // given
        int balance = 1000;
        int num = 8;

        // when
        BankDAO dao = new BankDAO();
        int result = dao.updateByNum(balance, num);

        // then
        if (result == 1) {
            System.out.println("설정 성공");
        } else if (result == 0){
            System.out.println(num+"행을 찾을 수 없습니다.");
        } else {
            System.out.println("설정 실패");
        }
    }
}
