import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        cycle: while (true) {
            System.out.println("\n--- МЕНЮ ---");
            // ИСПРАВЛЕНО: Пункт 1 убран из вывода меню
            System.out.println("1. Распечатать весь список!");
            System.out.println("2. Выдать список учеников с ДР в текущем месяце");
            System.out.println("3. Определить, кого больше (мальчиков/девочек)");
            System.out.println("4. Упорядочить учеников по фамилиям");
            System.out.println("5. Добавить ученика вручную!");
            System.out.println("6. Выход");
            System.out.print("Выберете пункт меню (1..6) => ");

            int c = (new Scanner(System.in)).nextInt();
            switch (c) {
                // ИСПРАВЛЕНО: Теперь кейсы сдвинуты и отвечают за новые пункты меню
                case 1:
                    StudentsService.printClass();
                    break;
                case 2:
                    StudentsService.printBirthdaysCurrentMonth();
                    break;
                case 3:
                    StudentsService.compareGender();
                    break;
                case 4:
                    StudentsService.sortByFullName();
                    break;
                case 5:
                    StudentsService.addStudents();
                    break;
                case 6:
                    System.out.println("Выход выполнен.");
                    break cycle;
                default:
                    System.out.println("Такого пункта нет!");
                    break;
            }
        }
    }
}
