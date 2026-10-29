
import java.util.Scanner;
import java.util.Arrays;

public class SortingMenu {

    // Selection Sort
    static void selectionSort(int[] marks) {
        int n = marks.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (marks[j] < marks[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = marks[i];
            marks[i] = marks[minIndex];
            marks[minIndex] = temp;
        }
    }

    // Insertion Sort
    static void insertionSort(int[] marks) {
        for (int i = 1; i < marks.length; i++) {
            int key = marks[i];
            int j = i - 1;

            while (j >= 0 && marks[j] > key) {
                marks[j + 1] = marks[j];
                j--;
            }

            marks[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Marks Sorting Menu ---");
            System.out.println("1. Selection Sort");
            System.out.println("2. Insertion Sort");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                case 2:
                    System.out.print("Enter number of students: ");
                    int n = sc.nextInt();

                    if (n <= 0) {
                        System.out.println(
                            "Number of students must be positive.");
                        break;
                    }

                    int[] marks = new int[n];

                    System.out.println("Enter marks of students:");
                    for (int i = 0; i < n; i++) {
                        marks[i] = sc.nextInt();

                        if (marks[i] < 0 || marks[i] > 100) {
                            System.out.println(
                                "Marks must be between 0 and 100.");
                            sc.close();
                            return;
                        }
                    }

                    System.out.println("Original marks: "
                            + Arrays.toString(marks));

                    if (choice == 1) {
                        selectionSort(marks);
                        System.out.println("Sorted using Selection Sort:");
                    } else {
                        insertionSort(marks);
                        System.out.println("Sorted using Insertion Sort:");
                    }

                    System.out.println(Arrays.toString(marks));
                    break;

                case 3:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 3);

        sc.close();
    }
}
