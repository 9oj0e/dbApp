import controller.BankController;
import lombok.AllArgsConstructor;

/*
* responsibility :
* route
* */

@AllArgsConstructor
public class Dispatcher {
    private BankController con;

    public void route(String url){
        // code below will work as a router/dispatcher
        if (url.equals("insert")) {
            con.insert();
        } else if (url.equals("delete")) {
            con.delete();
        } else if (url.equals("update")) {
            con.update();
        } else if (url.equals("selectOne")) {
            con.selectOne();
        } else if (url.equals("selectAll")) {
            con.selectAll();
        }
    }
}
