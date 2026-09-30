import java.time.LocalDate;

public class StudentsService {
    public static void printBirthdaysCurrentMonth() {
        int currentMonth = LocalDate.now().getMonthValue();
        System.out.println("\nа) Ученики с днем рождения в текущем месяце (№ " + currentMonth + "):");
        boolean hasBirthdays = false;
        for (Students s : classList) {
            if (s.getBirthDate().getMonthValue() == currentMonth) {
                System.out.println(s);
                hasBirthdays = true;
            }
        }
        if (!hasBirthdays) {
            System.out.println("В этом месяце др ни у когоо нет");
        }
    }
}
