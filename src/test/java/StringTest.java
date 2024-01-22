import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    public void String () {
        String st = "id=ssar&password=1234";
        String[] stArr = st.split("&"); // Split the original string at the '&' character
        for (String temp : stArr)
            System.out.print(temp + " ");
        System.out.println();

        // Extract the 'id' value from the first substring in stArr
        String id = stArr[0].split("=")[1]; // Split stArr at the '=' character and store it at id
        System.out.println("id: " + id);
        // Extract the 'password' value from the first substring in stArr
        String pw = stArr[1].split("=")[1]; // Split stArr at the '=' character and store it at pw
        System.out.println("pw: " + pw);
    }
}
