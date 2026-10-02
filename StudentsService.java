import java.time.LocalDate;
import java.util.Scanner;

public class StudentsService {
    // массив для хранения списка учеников
    private static Students[] classList;
    static {
        classList = new Students[] {
                new Students("Иванов И.И.", LocalDate.of(2010, 9, 15), 'М'),
                new Students("Иванова М.И.", LocalDate.of(2010, 8, 19), 'Ж'),
                new Students("Петров П.В.", LocalDate.of(2010, 10, 10), 'М'),
                new Students("Сидоров А.И.", LocalDate.of(2011, 5, 12), 'М'),
                new Students("Николаева Н.Н.", LocalDate.of(2010, 12, 14), 'Ж'),
        };
    }
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
    public static void fillClass() {
        System.out.print("Введите количсество учеников: ");
        int n = (new Scanner(System.in)).nextInt();
        classList = new Students[n];
        System.out.println("Введите инфо об учениках: ");
        for (int i = 0; i < classList.length; i++) {
            System.out.println("Ученик" + (i + 1) + "=>");
            classList[i] = new Students();
        }
    }
    public static void printClass() {
        System.out.println("\nСписок учеников класса: ");
        for (int i = 0; i < classList.length; i++) {
            System.out.println(classList[i]);
        }
    }
    public static void addStudents() {
        Students[] newList = new Students[classList.length + 1];
        for (int i = 0; i < classList.length; i++) {
            newList[i] = classList[i];
        }
        newList[classList.length] = new Students();
        classList = newList;
    }
}
