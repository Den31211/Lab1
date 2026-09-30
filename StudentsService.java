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

    public static void sortByFullName() {
        for (int i = 0; i < classList.length - 1; i++) {
            for (int j = 0; j < classList.length - i - 1; j++) {
                if (classList[j].getFullName().compareTo(classList[j + 1].getFullName()) > 0) {
                    Students rab = classList[j];
                    classList[j] = classList[j + 1];
                    classList[j + 1] = rab;
                }
            }
        }
        System.out.println("\nв) Отсортированный список по фамилиям:");
        for (int i = 0; i < classList.length; i++) {
            System.out.println(classList[i]);
        }
    }
}
