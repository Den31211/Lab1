import java.time.LocalDate;
import java.util.Scanner;

public class Students {
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
}
