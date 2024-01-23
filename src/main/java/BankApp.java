import controller.BankController;
import dao.BankDAO;

public class BankApp {
    public static void main(String[] args) {
        String url = "selectAll";

        BankDAO dao = new BankDAO();
        BankController con = new BankController(dao);
        Dispatcher dis = new Dispatcher(con); // dependency injection
        dis.route(url);
    }
}
