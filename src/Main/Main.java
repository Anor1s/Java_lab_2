package Main;
import Abiturient.Abiturient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Abiturient> abiturients = new ArrayList<>();

        // Створення об'єктів абітурієнтів
        abiturients = createAbiturients(scanner);

        // Виведення всіх студентів
        printAllAbiturients(abiturients);

        // а) Список студентів із вказаним ім'ям
        searchByName(scanner, abiturients);

        // b) Список студентів із середнім балом вище заданого значення
        searchByAverageMark(scanner, abiturients);

        // c) Список топ-n студентів за середнім балом
        displayTopNStudents(scanner, abiturients);

        // d) Порахувати середній бал групи
        calculateAverageGroupMark(abiturients);
    }

    // Створення масиву об'єктів абітурієнтів
    public static List<Abiturient> createAbiturients(Scanner scanner) {
        List<Abiturient> abiturients = new ArrayList<>();

        System.out.println("Enter the number of students to add:");
        int numStudents = scanner.nextInt();
        if (numStudents > 0) {
            scanner.nextLine();
        } else {
            System.out.println("Number of students must be greater than 0.");
            return abiturients;
        }

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter information for student " + (i + 1) + ":");

            System.out.println("Enter the ID of the student:");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter the name of the student:");
            String name = scanner.nextLine();

            System.out.println("Enter the surname of the student:");
            String surname = scanner.nextLine();

            System.out.println("Enter the second name of the student:");
            String secondName = scanner.nextLine();

            System.out.println("Enter the address of the student:");
            String address = scanner.nextLine();

            System.out.println("Enter the phone number of the student:");
            String phone = scanner.nextLine();

            System.out.println("Enter the average mark of the student:");
            float averageMark = scanner.nextFloat();
            if (averageMark > 0) {
                scanner.nextLine();
            } else {
                System.out.println("Average mark of the student must be greater than 0.");
                return abiturients;
            }

            Abiturient student = new Abiturient(id, name, surname, secondName, address, phone, averageMark);
            abiturients.add(student);
        }

        return abiturients;
    }

    // Виведення всіх студентів
    public static void printAllAbiturients(List<Abiturient> abiturients) {
        System.out.println("\nAll students:");
        for (Abiturient student : abiturients) {
            System.out.println(student);
        }
    }

    // Пошук за ім'ям
    public static void searchByName(Scanner scanner, List<Abiturient> abiturients) {
        System.out.println("\nEnter the name to search for:");
        String searchName = scanner.nextLine();
        boolean found = false;

        for (Abiturient student : abiturients) {
            if (student.getName().equalsIgnoreCase(searchName)) {
                found = true;
                System.out.println("Students with name '" + searchName + "': " + student);
            }
        }

        if (!found) {
            System.out.println("There are no students with name " + searchName + ".");
        }
    }

    // Пошук за середнім балом
    public static void searchByAverageMark(Scanner scanner, List<Abiturient> abiturients) {
        System.out.println("\nEnter the minimum average mark:");
        float minAverageMark = scanner.nextFloat();
        boolean found = false;

        for (Abiturient student : abiturients) {
            if (student.getAverageMark() > minAverageMark) {
                found = true;
                System.out.println("\nStudents with average mark higher than " + minAverageMark + ": " + student);
            }
        }

        if (!found) {
            System.out.println("There are no students with average mark higher than " + minAverageMark + ".");
        }
    }

    // Виведення топ-n студентів
    public static void displayTopNStudents(Scanner scanner, List<Abiturient> abiturients) {
        System.out.println("\nEnter the number of top students to display:");
        int n = scanner.nextInt();
        scanner.nextLine();

        // Сортування за середнім балом у порядку спадання
        Collections.sort(abiturients, Comparator.comparingDouble(Abiturient::getAverageMark).reversed());

        System.out.println("Top " + n + " students by average mark:");
        for (int i = 0; i < Math.min(n, abiturients.size()); i++) {
            System.out.println(abiturients.get(i));
        }
    }

    // Розрахунок середнього балу групи
    public static void calculateAverageGroupMark(List<Abiturient> abiturients) {
        double sum = 0;
        for (Abiturient student : abiturients) {
            sum += student.getAverageMark();
        }
        double average = sum / abiturients.size();
        System.out.println("\nAverage mark of group: " + average);
    }
}
