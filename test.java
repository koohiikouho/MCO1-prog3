import java.math.BigDecimal;
import java.util.*;

public class test {
    public static void main(String[] args) {
        Date checkIn = new Date(2024, 6, 15);
        Date checkOut = new Date(2024, 6, 18);
        Date Test = new Date(2024, 6, 17);
        System.out.println(checkIn.before(Test));
        System.out.println(checkOut.after(Test));
        if (checkIn.before(Test) && checkOut.after(Test))
            System.out.println("working");
        else
            System.out.println("not working");

    }
}