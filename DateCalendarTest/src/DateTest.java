import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Hai on 3/6/2017.
 */
public class DateTest {
    public static void main(String[] args) {
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        System.out.println(sqlDate);
    }
}
