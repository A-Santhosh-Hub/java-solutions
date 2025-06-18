import java.io.*;
import java.util.*;

class Item {
    String id;
    String name;
    int quantity;
    double price;

    Item(String id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return String.format("ID: %s | Name: %s | Quantity: %d | Price: %.2f", id, name, quantity, price);
    }
}

class InventoryManagement {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Item> inventory = new ArrayList<>();
    static String fileName = "inventory.txt";

    public static void main(String[] args) {
        loadFromFile();

        while (true) {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. Add Item");
            System.out.println("2. View All Items");
            System.out.println("3. Edit Item");
            System.out.println("4. Delete Item");
            System.out.println("5. Search Item");
            System.out.println("6. Save & Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1: addItem(); break;
                case 2: viewItems(); break;
                case 3: editItem(); break;
                case 4: deleteItem(); break;
                case 5: searchItem(); break;
                case 6: saveToFile(); System.out.println("Saved! Exiting..."); return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    static void addItem() {
        System.out.print("Enter Item ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Item Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble(); sc.nextLine();

        inventory.add(new Item(id, name, qty, price));
        System.out.println("Item added.");
    }

    static void viewItems() {
        if (inventory.isEmpty()) {
            System.out.println("No items in inventory.");
            return;
        }
        System.out.println("\nInventory Items:");
        for (Item item : inventory) {
            System.out.println(item);
        }
    }

    static void editItem() {
        System.out.print("Enter Item ID to edit: ");
        String id = sc.nextLine();
        for (Item item : inventory) {
            if (item.id.equals(id)) {
                System.out.print("Enter New Name: ");
                item.name = sc.nextLine();
                System.out.print("Enter New Quantity: ");
                item.quantity = sc.nextInt();
                System.out.print("Enter New Price: ");
                item.price = sc.nextDouble(); sc.nextLine();
                System.out.println("Item updated.");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    static void deleteItem() {
        System.out.print("Enter Item ID to delete: ");
        String id = sc.nextLine();
        Iterator<Item> itr = inventory.iterator();
        while (itr.hasNext()) {
            if (itr.next().id.equals(id)) {
                itr.remove();
                System.out.println("Item deleted.");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    static void searchItem() {
        System.out.print("Enter keyword to search (ID or Name): ");
        String keyword = sc.nextLine().toLowerCase();
        boolean found = false;
        for (Item item : inventory) {
            if (item.id.toLowerCase().contains(keyword) || item.name.toLowerCase().contains(keyword)) {
                System.out.println(item);
                found = true;
            }
        }
        if (!found) System.out.println("No matching items.");
    }

    static void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            for (Item item : inventory) {
                pw.println(item.id + "," + item.name + "," + item.quantity + "," + item.price);
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    static void loadFromFile() {
        File file = new File(fileName);
        if (!file.exists()) return;

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(",");
                if (parts.length == 4) {
                    String id = parts[0];
                    String name = parts[1];
                    int qty = Integer.parseInt(parts[2]);
                    double price = Double.parseDouble(parts[3]);
                    inventory.add(new Item(id, name, qty, price));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading file.");
        }
    }
}
