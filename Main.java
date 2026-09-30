import java.time.LocalDate;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Students {
    // поля класса
    private String fullName;
    private LocalDate birthDate;
    private char gender;

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

    // Конструктор для создания готовых объектов
    public Students(String fullName, LocalDate birthDate, char gender) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    // Конструктор для ручного ввода объктов
    public Students() {
        Scanner sc = new Scanner(System.in, "UTF-8");
        System.out.print("Фамилия и инициалы: ");
        this.setFullName(sc.nextLine());
        System.out.print("\tГод рождения: ");
        int year = sc.nextInt();
        System.out.print("\tМесяц рождения: ");
        int month = sc.nextInt();
        System.out.print("\tДень рождения: ");
        int day = sc.nextInt();
        this.birthDate = LocalDate.of(year, month, day);

        System.out.print("\tВыберите пол (1 - мальчик, 2 - девочка): ");
        int genderChoice = sc.nextInt();
        if (genderChoice == 2) {
            this.gender = 'Ж';
        } else {
            this.gender = 'М';
        }

        sc.nextLine();
    }

    public static void addStudents() {
        Students[] newList = new Students[classList.length + 1];
        for (int i = 0; i < classList.length; i++) {
            newList[i] = classList[i];
        }
        newList[classList.length] = new Students();
        classList = newList;
    }

    // Геттеры и сеттеры
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName.isEmpty())
            System.out.println("Имя не может быть пустым!");
        else
            this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        gender = Character.toUpperCase(gender);
        if (gender != 'М' && gender != 'Ж')
            System.out.println("Недопустимое значение");
        else
            this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("%s, Пол: %s, Дата рождения: %s", fullName, gender, birthDate);
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

    // Вывод всего списка
    public static void printClass() {
        System.out.println("\nСписок учеников класса: ");
        for (int i = 0; i < classList.length; i++) {
            System.out.println(classList[i]);
        }
    }

    // а) У кого др в этом месяце


    // б) Определяем кого больше


    // в) Сортировка по фамилиям пузырьком

}

public class Main {
    public static void main(String[] args) {
        cycle: while (true) {
            System.out.println("\n--- МЕНЮ ---");
            // ИСПРАВЛЕНО: Пункт 1 убран из вывода меню
            System.out.println("1. Распечатать весь список");
            System.out.println("2. Выдать список учеников с ДР в текущем месяце");
            System.out.println("3. Определить, кого больше (мальчиков/девочек)");
            System.out.println("4. Упорядочить учеников по фамилиям");
            System.out.println("5. Добавить ученика вручную");
            System.out.println("6. Выход");
            System.out.print("Выберете пункт меню (1..6) => ");

            int c = (new Scanner(System.in)).nextInt();
            switch (c) {
                // ИСПРАВЛЕНО: Теперь кейсы сдвинуты и отвечают за новые пункты меню
                case 1:
                    Students.printClass();
                    break;
                case 2:
                    Students.printBirthdaysCurrentMonth();
                    break;
                case 3:
                    Students.compareGender();
                    break;
                case 4:
                    Students.sortByFullName();
                    break;
                case 5:
                    Students.addStudents();
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
