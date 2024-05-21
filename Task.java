import java.util.Scanner;

public class Task {
    // Maximum size of the arrays
    int maxSize = 100;
    int[] price;
    String[] itemName;
    int index;

    public Task() {
        price = new int[maxSize];
        itemName = new String[maxSize];
        index = 0;
    }

    // Insert an element at the end of the arrays
    public void insertElement(int element, String stringElement) {
        if (index < maxSize) 
        {
            price[index] = element;
            itemName[index] = stringElement;
            index++;
            System.out.println("Element inserted successfully.");
        } else {
            System.out.println("Arrays are full. Cannot insert element.");
        }
    }

    // Delete an element from the arrays
    public void deleteElement(int element) {
        int indexToDelete = searchElement(element);
        if (indexToDelete != -1) {
            for (int i = indexToDelete; i < index - 1; i++) {
                price[i] = price[i + 1];
                itemName[i] = itemName[i + 1];
            }
            index--;
            System.out.println("Element deleted successfully.");
        } else {
            System.out.println("Element not found. Cannot delete.");
        }
    }

    // Search for an element in the integer array
    public int searchElement(int element) {
        for (int i = 0; i < index; i++) {
            if (price[i] == element) {
                return i;
            }
        }
        return -1; // Element not found
    }

    public void sum(){
        int sum=0;
        for (int i = 0; i < price.length; i++) {
            sum+=price[i];
        } 
    }

    // Display the elements of the arrays
    public void displayArrays() {
        if (index < 0) {
            System.out.println("Arrays is  empty.");
        } else {
            System.out.println("Array elements:");
            for (int i = 0; i < index; i++) {
                System.out.println("NAME OF ITEM : " + itemName[i] + ", PRICE OF ITEM: " + price[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task task = new Task();

        int choice;
        do {
            System.out.println("\n----- Array Operations Menu -----");
            System.out.println("1. Insert element");
            System.out.println("2. Delete element");
            System.out.println("3. Search element");
            System.out.println("4. Display arrays");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the integer element to insert: ");
                    int insertIntElement = scanner.nextInt();
                    scanner.nextLine(); // consume newline character
                    System.out.print("Enter the string element to insert: ");
                    String insertStringElement = scanner.nextLine();
                    task.insertElement(insertIntElement, insertStringElement);
                    break;
                case 2:
                    System.out.print("Enter the element to delete: ");
                    int deleteElement = scanner.nextInt();
                    task.deleteElement(deleteElement);
                    break;
                case 3:
                    System.out.print("Enter the element to search: ");
                    int searchElement = scanner.nextInt();
                    int index = task.searchElement(searchElement);
                    if (index != -1) {
                        System.out.println("Element found at index " + index);
                    } else {
                        System.out.println("Element not found in the arrays.");
                    }
                    break;
                case 4:
                    task.displayArrays();
                    break;
                case 5:
                task.sum();
                    System.out.println("Exiting program........");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }
}




