import java.time.LocalDate;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Students {
    // поля класса
    private String fullName;
    private LocalDate birthDate;
    private char gender;



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



    // Вывод всего списка


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
