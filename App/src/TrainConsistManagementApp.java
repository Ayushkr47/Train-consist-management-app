import java.util.*;

public class TrainConsistManagementApp {

    // 🔹 Bubble Sort Method
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            // Each pass
            for (int j = 0; j < n - i - 1; j++) {

                // Compare adjacent elements
                if (arr[j] > arr[j + 1]) {

                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of passenger bogies: ");
        int n = sc.nextInt();

        int[] capacities = new int[n];

        // 🔹 Input
        for (int i = 0; i < n; i++) {
            System.out.print("Enter capacity for bogie " + (i + 1) + ": ");
            capacities[i] = sc.nextInt();
        }

        // 🔹 Sorting using Bubble Sort
        bubbleSort(capacities);

        // 🔹 Output
        System.out.println("\nSorted Passenger Bogie Capacities:");
        for (int cap : capacities) {
            System.out.print(cap + " ");
        }

        sc.close();
    }
}