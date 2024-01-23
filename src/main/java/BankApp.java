import controller.BankController;
import dao.BankDAO;
import model.Account;

public class BankApp {
    public static void main(String[] args) {
        String url = "/insert";

        BankDAO dao = new BankDAO();
        BankController con = new BankController(dao); // dependency injection
        Dispatcher dis = new Dispatcher(con);
        dis.route(url);

    }
}
