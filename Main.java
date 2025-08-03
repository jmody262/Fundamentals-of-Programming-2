import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#") || line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String name = parts[0].trim();
                    String id = parts[1].trim();
                    int a1 = Integer.parseInt(parts[2].trim());
                    int a2 = Integer.parseInt(parts[3].trim());
                    int a3 = Integer.parseInt(parts[4].trim());

                    students.add(new Student(name, id, a1, a2, a3));
                }
            }
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }

        while (true) {
            System.out.println("\n1. Filter by Threshold");
            System.out.println("2. Top & Bottom 5 Students");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter threshold: ");
                int threshold = scanner.nextInt();

                for (Student s : students) {
                    if (s.getTotalMarks() < threshold) {
                        System.out.println(s);
                    }
                }
            } else if (choice == 2) {
                students.sort(Comparator.comparing(Student::getTotalMarks).reversed());

                System.out.println("Top 5 Students:");
                for (int i = 0; i < Math.min(5, students.size()); i++) {
                    System.out.println(students.get(i));
                }

                System.out.println("Bottom 5 Students:");
                for (int i = students.size() - 1; i >= Math.max(students.size() - 5, 0); i--) {
                    System.out.println(students.get(i));
                }
            } else {
                break;
            }
        }

        scanner.close();
    }
}
