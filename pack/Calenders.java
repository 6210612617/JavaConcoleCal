package pack;

public class Calenders {
    int year;
    int day;
    int month;

    Calenders(int year, int day, int month) {
        year = this.year;
        day = this.day;
        month = this.month;

    }

    public int[] cal_yaer(int year) {

        int Cyear = year - 543;
        int Leapyear = 0;
        if (Cyear % 4 == 0 && Cyear % 100 == 0 && Cyear % 400 == 0) {
            Leapyear = 366;
        } else {
            Leapyear = 365;
        }

        return new int[] { Leapyear, Cyear };

    }

    public String[] calculete(int day, int month, int Leapyear, String Cyear) {
        // cal for days
        int days = 0;
        if (month >= 2) {
            for (int i = 1; i < month; i++) {
                if (i % 2 == 0) {
                    days += 30;
                } else {
                    days += 31;
                }

            }
        }
        if (month > 2) {
            if (Leapyear == 365) {
                days = days - 2;
            } else {
                days = days - 1;
            }
        }

        days = day + days;

        // cal for week
        double new_days = days;
        double week = new_days / 7.0;
        week = Math.ceil(week);
        int weeks = (int) week;

        // for day

        String before_y;
        String after_y;
        // Cyear Zeller's rule
        before_y = Cyear.substring(0, 1);
        after_y = Cyear.substring(2, 3);
        int before_ys = Integer.parseInt(before_y);
        int after_ys = Integer.parseInt(after_y);
        // 01/02
        if (month == 1 || month == 2) {
            after_ys = after_ys - 1;
        }
        double cal1 = (((13 * month) - 1) / 5);
        double cal2 = ((after_ys / 4) + (before_ys / 4));
        double results = (day + cal1 + after_ys + cal2 - (2 * before_ys));
        results = results % 7;
        int result = (int) results;

        String[] DayOfWeek = { "S", "M", "T", "W", "TH", "F", "S" };
        String Date = DayOfWeek[result];

        String final_day = String.valueOf(days);
        String final_week = String.valueOf(weeks);

        return new String[] { final_day, final_week, Date };

    }
}
