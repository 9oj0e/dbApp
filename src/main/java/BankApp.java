import dao.BankDAO;
import model.Account;

import java.util.List;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // url설계는 다음과 같이 한다. RestAPI라고 한다. 자세한건 다음에..
        // http://bank.com/account GET
        // http://bank.com/account/10 GET
        // http://bank.com/account * POST
        // http://bank.com/account/1 DELETE
        // http://bank.com/account/1 * PUT

        System.out.println("protocol 입력");
        String method = sc.nextLine(); // input protocol
        System.out.println("identifier 입력");
        String action = sc.nextLine(); // identifier

        String body = "";

        BankDAO bankDAO = new BankDAO();
        if(method.equals("GET")){
            if (action.equals("/account")){
                List<Account> accountList = bankDAO.selectAll();
                System.out.println(accountList);
            }else if (action.equals("/account/1")){
                Account account = bankDAO.selectByNum(1);
                System.out.println(account);
            }
        }else if(method.equals("POST")){
            System.out.println("Body데이터를 입력하세요");
            body = sc.nextLine();

            // password=1234&balance=1000
            String[] st1 = body.split("&");
            String password = st1[0].split("=")[1];
            int balance = Integer.parseInt(st1[1].split("=")[1]);

            if(action.equals("/account")){
                bankDAO.insert(password,balance);
            }

            //
        }else if(method.equals("PUT")){
            System.out.println("balance를 입력하세요");
            String bal = sc.nextLine();
            int balance = Integer.parseInt(bal);

            if(action.equals("/account/1")){
                bankDAO.updateByNum(balance, 1);
            }
            // password=1234&balance=1000

        }else if(method.equals("DELETE")){
            if(action.equals("/account/1")){
                bankDAO.deleteByNum(1);
            }
        }else {
            System.out.println("STFU");
        }

    }
}
