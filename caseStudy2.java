
import java.net.Socket;
import java.util.Scanner;

public class caseStudy2 {

    static String customer[][] = new String[5][7];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1.Add order list");
            System.out.println("2.Display all order list");
            System.out.println("3.Exit");
            System.out.print("Choose a menu : ");
            int menu = sc.nextInt();

            switch (menu) {
                case 1: inputList();   
                    int grandTotal = calculateMenu(15000,22000, 12000, 18000);
                    System.out.println("total price : " + grandTotal);                   
                    break;
                case 2: display();
                    break;
                
                default: System.out.println("exiting program ");
                    return;
            }

        }
    }

    static void inputList(){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < customer.length; i++){
            System.out.print("enter customer name : ");
            customer[i][0] = sc.nextLine();
            System.out.print("enter table number : ");
            int table = sc.nextInt();
            customer[i][1] = String.valueOf(table);   
            break;       
        }       

        System.out.println("=== MENU CAFE ===");
        System.out.println("1.Black coffe - Rp 15000");
        System.out.println("2.Latte - Rp 22000");
        System.out.println("3.Teh tarik - 12000");
        System.out.println("4.Noodles - Rp 18000");

        int chooseMenu;
            for (int i = 0; i < customer.length; i++){
            System.out.print("choose a menu (enter number of menu or enter 0 to finish) : ");
            chooseMenu = sc.nextInt();
            switch (chooseMenu) {
                case 0: 
                        System.out.println("your order is succes!");
                    return;
                case 1: System.out.print("enter number of black coffe :");
                        int coffe = sc.nextInt();
                        customer[i][2] = String.valueOf(coffe);
                    break;
                case 2: System.out.print("enter number of latte : ");
                        int latte = sc.nextInt();
                        customer[i][3] = String.valueOf(latte);
                    break;
                case 3: System.out.print("enter number of teh tarik : ");
                        int teh = sc.nextInt();
                        customer[i][4] = String.valueOf(teh);
                    break;
                case 4: System.out.print("enter number of noodles : ");
                        int noodles = sc.nextInt();
                        customer[i][5] = String.valueOf(noodles);
                    break;
                default: System.out.print("menu not avalaible, please enter again");
                    break;
                }
                
                
            }          
            
        }  

        static int calculateMenu(int iCoffee, int iCatte, int iTeh, int iNoodles) {
            int allTotal = 0;
            for (int i = 0; i < customer.length; i++) {
                int customerTotal = 0;
                int coffeTotal = 0; 
                int latteTotal = 0; 
                int tehTotal = 0;   
                int noodleTotal = 0; 
                if (customer[i][2] != null) {
                    int coffeeQuantity = Integer.parseInt(customer[i][2]);
                    coffeTotal = icoffee * coffeeQuantity;
                }
                if (customer[i][3] != null) {
                    int latteQuantity = Integer.parseInt(customer[i][3]);
                    latteTotal = ilatte * latteQuantity;
                }
                if (customer[i][4] != null) {
                    int tehQuantity = Integer.parseInt(customer[i][4]);
                    tehTotal = iteh * tehQuantity;
                }
                if (customer[i][5] != null) {
                    int noodlesQuantity = Integer.parseInt(customer[i][5]);
                    noodleTotal = inoodles * noodlesQuantity;
                } 
                customerTotal = coffeTotal + latteTotal + tehTotal + noodleTotal;
                allTotal += customerTotal;
                customer[i][6] = String.valueOf(customerTotal); 
                display(coffeTotal, latteTotal, tehTotal, noodleTotal);
            }
            return allTotal;
        } 

        static void display(int coffeTotal, int latteTotal, int tehTotal, int noodleTotal) {
            System.out.println("\n===ORDER LIST===");
            for (int i = 0; i < customer.length; i++) {
                System.out.println("Customer Name: " + customer[i][0]);
                System.out.println("Table Number: " + customer[i][1]);
                System.out.println("Order list: ");
                if (customer[i][2] != null && !customer[i][2].equals("0")) {
                System.out.println("Black Coffee x " + customer[i][2] + " = Rp " + coffeTotal );
                }
                if (customer[i][3] != null && !customer[i][3].equals("0")) {
                System.out.println("Latte x " + customer[i][3] + " = Rp ");
                }
                if (customer[i][4] != null && !customer[i][4].equals("0")) {
                System.out.println("Tea x " + customer[i][4] + " = Rp ");
                }
                if (customer[i][5] != null && !customer[i][5].equals("0")) {
                System.out.println("Fried Noodle x " + customer[i][5] + " = Rp ");
                }
                System.out.println("Total Order Price: " + customer[i][6]);
                return;
            } 
        }
    }


          
