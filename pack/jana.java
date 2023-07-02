import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import pack.Calenders;

public class jana {

    public static void main(String[] args) {
        String day = "";
        String month = "";
        String year = "";
        Scanner word = new Scanner(System.in);
        System.out.println("Enter day/month/year: ");

        String theDay = word.nextLine();
        word.close();

        String[] arrOfStr = theDay.split("/", 3);
        day = arrOfStr[0];
        month = arrOfStr[1];
        year = arrOfStr[2];
        int years = Integer.parseInt(year);
        int months = Integer.parseInt(month);
        int days = Integer.parseInt(day);
        Calenders calender = new Calenders(years, days, months);

        int re[] = calender.cal_yaer(years);
        String Cyear = String.valueOf(re[1]);
        String result[] = calender.calculete(days, months, re[0], Cyear);

        System.out.println("this day is :" + result[2]);
        System.out.println("this count of days is :" + result[0]);
        System.out.println("this week of year is :" + result[1]);
        System.out.println("this year is :" + Cyear);
        System.out.println("this Leapyaer is :" + re[0]);

    }
}
