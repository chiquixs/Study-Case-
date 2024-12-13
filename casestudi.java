import java.util.Scanner;

public class caseStudy2 {

    static String customer[][] = new String[100][7]; // Customer storage

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Add order list");
            System.out.println("2. Display all order list");
            System.out.println("3. Exit");
            System.out.print("Choose a menu : ");
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    inputList();   
                    int grandTotal = calculateMenu(15000, 22000, 12000, 18000);
                    System.out.println("Total price for all orders: Rp " + grandTotal);                   
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    System.out.println("Exiting Program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid menu. Choose again.");
            }
        }
    }

    static void inputList() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < customer.length; i++) {
            if (customer[i][0] == null) { // Cari slot kosong dalam array customer
                System.out.print("\nEnter customer name: ");
                customer[i][0] = sc.nextLine();
                System.out.print("Enter table number: ");
                int table = sc.nextInt();
                customer[i][1] = String.valueOf(table);

                System.out.println("\n=== MENU CAFE ===");
                System.out.println("1. Black Coffee - Rp 15000");
                System.out.println("2. Latte - Rp 22000");
                System.out.println("3. Teh Tarik - Rp 12000");
                System.out.println("4. Noodles - Rp 18000");

                while (true) {
                    System.out.print("Choose a menu (enter number of menu or 0 to finish): ");
                    int chooseMenu = sc.nextInt();

                    if (chooseMenu == 0) {
                        System.out.println("Your order is successfully added!");
                        break;
                    }

                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();

                    switch (chooseMenu) {
                        case 1: // Black Coffee
                            customer[i][2] = addToMenu(customer[i][2], quantity);
                            break;
                        case 2: // Latte
                            customer[i][3] = addToMenu(customer[i][3], quantity);
                            break;
                        case 3: // Teh Tarik
                            customer[i][4] = addToMenu(customer[i][4], quantity);
                            break;
                        case 4: // Noodles
                            customer[i][5] = addToMenu(customer[i][5], quantity);
                            break;
                        default:
                            System.out.println("Menu not available. Please enter again.");
                    }
                }
                break;
            }
        }
    }

    static String addToMenu(String currentQuantity, int newQuantity) {
        if (currentQuantity == null) {
            return String.valueOf(newQuantity);
        } else {
            return String.valueOf(Integer.parseInt(currentQuantity) + newQuantity);
        }
    }

    static int calculateMenu(int priceCoffee, int priceLatte, int priceTeh, int priceNoodles) {
        int allTotal = 0;
        for (int i = 0; i < customer.length; i++) {
            if (customer[i][0] != null) { // Hanya hitung jika customer[i] tidak kosong
                int customerTotal = 0;

                // Hitung total untuk setiap menu
                if (customer[i][2] != null) {
                    customerTotal += Integer.parseInt(customer[i][2]) * priceCoffee;
                }
                if (customer[i][3] != null) {
                    customerTotal += Integer.parseInt(customer[i][3]) * priceLatte;
                }
                if (customer[i][4] != null) {
                    customerTotal += Integer.parseInt(customer[i][4]) * priceTeh;
                }
                if (customer[i][5] != null) {
                    customerTotal += Integer.parseInt(customer[i][5]) * priceNoodles;
                }

                allTotal += customerTotal;
                customer[i][6] = String.valueOf(customerTotal); // Simpan total untuk customer
            }
        }
        return allTotal;
    }

    static void display() {
        System.out.println("\n=== ORDER LIST ===");
        for (int i = 0; i < customer.length; i++) {
            if (customer[i][0] != null) { // Hanya tampilkan data jika customer[i] tidak kosong
                System.out.println("\nCustomer Name: " + customer[i][0]);
                System.out.println("Table Number: " + customer[i][1]);
                System.out.println("Order List:");

                // Tampilkan detail pesanan
                if (customer[i][2] != null) {
                    System.out.println("  Black Coffee x " + customer[i][2]);
                }
                if (customer[i][3] != null) {
                    System.out.println("  Latte x " + customer[i][3]);
                }
                if (customer[i][4] != null) {
                    System.out.println("  Teh Tarik x " + customer[i][4]);
                }
                if (customer[i][5] != null) {
                    System.out.println("  Noodles x " + customer[i][5]);
                }

                // Tampilkan total harga per pelanggan
                System.out.println("Total Order Price: Rp " + customer[i][6]);
            }
        }
    }
}
