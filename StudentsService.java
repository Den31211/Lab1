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

    public static void compareGender() {
        int boys = 0;
        int girls = 0;
        for (Students s : classList) {
            if (s.getGender() == 'М')
                boys++;
            else if (s.getGender() == 'Ж')
                girls++;
        }
        System.out.println("\nб) Сравнение количества мальчиков и девочек:");
        System.out.printf("Мальчиков: %d, Девочек: %d\n", boys, girls);
        if (boys > girls)
            System.out.println("Мальчиков больше!");
        else if (boys < girls)
            System.out.println("Девочек больше!");
        else
            System.out.println("Всех поровну!");
    }
}
