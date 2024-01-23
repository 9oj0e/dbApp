import controller.BankController;
import controller.RequestMapping;
import lombok.AllArgsConstructor;

import java.lang.reflect.Method;

/*
* responsibility :
* route (보내다/전송하다)
* */

@AllArgsConstructor
public class Dispatcher {
    private BankController con;

    public void route(String path){

        Method[] methods = con.getClass().getDeclaredMethods();
        for (Method method : methods) {
            RequestMapping rm = method.getDeclaredAnnotation(RequestMapping.class);
            if (rm == null) continue;
            if (rm.uri().equals(path)) {
                try {
                    method.invoke(con);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
