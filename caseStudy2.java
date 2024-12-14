import java.util.Scanner;
public class caseStudy2 {
    //penyimpanan nama 
    static String[] listCustomerName = new String[10];

    //no table,list order (coffe, latte, tea, noodle)
    static int[][] listOrder = new int[10][5];

    //penyimpanan kalkulasi
    //calculate per order(kopi,latte,teh,mi), calculate per person
    static int[][] calculationList = new int[10][5];

    //varible global, buat track kita ada di index berapa
    static int customerIndex = 0;

    static String customer[][] = new String[100][7];
    

    //kolok 0 nama
    //kolom 1 nomor meja
    //kolom 2 jumlah kopi
    //kolom 3 latte
    //kolom 4 teh
    //kolom 5 noodle
    //kolom 6 harga akhir total
    
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
                case 1: inputOrder();               
                    break;
                case 2: displayList();
                    break;
                
                default: System.out.println("exiting program ");
                    return;
            }

        }
    }
    
    static void inputOrder(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\nInput name of customer : ");
        listCustomerName[customerIndex] = sc.nextLine();
        System.out.print("Input number of table : ");
        listOrder[customerIndex][0] = sc.nextInt(); 
        
        for (int i = 0; i < customer.length; i++){
            System.out.print("\nenter customer name : ");
            customer[i][0] = sc.nextLine();
            System.out.print("enter table number : ");
            int table = sc.nextInt();
            customer[i][1] = String.valueOf(table);   
            break;     
              
        }       

        System.out.println("\n=== MENU CAFE ===");
        System.out.println("1. Black coffe - Rp 15000");
        System.out.println("2. Latte - Rp 22000");
        System.out.println("3. Teh tarik - 12000");
        System.out.println("4. Noodles - Rp 18000");
        
        while(true){
            System.out.print("\nChoose a menu (enter number of menu, or enter 0 to finish) : ");
            int chooseMenu = sc.nextInt();
            switch (chooseMenu) {
                case 1: 
                    System.out.print("Enter number of Black Coffe : ");
                    listOrder[customerIndex][1] += sc.nextInt();
                    break;
                case 2: 
                    System.out.print("Enter number of Latte : ");
                    listOrder[customerIndex][2] += sc.nextInt();
                    break;
                case 3: 
                    System.out.print("Enter number of Tarik Tea : ");
                    listOrder[customerIndex][3] += sc.nextInt();
                    break;
                case 4: 
                    System.out.print("Enter number of Fried Noodles : ");
                    listOrder[customerIndex][4] += sc.nextInt();
                    break;
                default: 
                    if (chooseMenu != 0 ) {
                        System.out.print("Menu not avalaible, please enter again");
                    }             
            }
            if (chooseMenu == 0) {
                System.out.println("\nThe order was successfully added");
                System.out.println("The Total payment is: Rp " + calculationOrder());
                break;
            }
        } 
        customerIndex++;
    }                   
    
    static int calculationOrder(){
        int coffePrice = 15000;
        int lattePrice = 22000;
        int tarikTeaPrice = 12000;
        int noodlePrice = 18000; 

        //masukin total harga per produknya ke array kalkulasi
        int totalCoffePrice = listOrder[customerIndex][1] * coffePrice;
        calculationList[customerIndex][0] = totalCoffePrice;

        int totalLattePrice = listOrder[customerIndex][2] * lattePrice;
        calculationList[customerIndex][1] = totalLattePrice;

        int totalTarikTeaPrice = listOrder[customerIndex][3] * tarikTeaPrice;
        calculationList[customerIndex][2] = totalTarikTeaPrice;

        int totalNoodlePrice = listOrder[customerIndex][4] * noodlePrice;
        calculationList[customerIndex][3] = totalNoodlePrice;

        int totalPrice = totalCoffePrice + totalLattePrice + totalTarikTeaPrice + totalNoodlePrice;
        calculationList[customerIndex][4] = totalPrice;
        return totalPrice;
    }
        
    static void displayList(){
        System.out.println("\n==== ORDER LIST ====");
        for (int i = 0; i < listCustomerName.length; i++){
                if (listCustomerName[i] == null) {
                    System.out.println("");
                    
                } else {
                    System.out.println("Customer Name : " + listCustomerName[i]);
                }
                
                if (listOrder[i][0] == 0) {
                    break;
                } else {
                    System.out.println("Table Number : " + listOrder[i][0]);
                }
                
                System.out.println("Order list : ");

                if (listOrder[i][1] != 0) {
                    System.out.println("Black Coffee X " + listOrder[i][1] + " = Rp " + calculationList[i][0]);
                    if (listOrder[i][1] == 0) {
                        break;
                    }
                }
                if (listOrder[i][2] != 0) {
                    System.out.println("Latte X " + listOrder[i][2] + " = Rp " + calculationList[i][1]);
                    if (listOrder[i][2] == 0) {
                        break;
                    }
                }
                if (listOrder[i][3] != 0) {
                    System.out.println("Tarik Tea X " + listOrder[i][3] + " = Rp " + calculationList[i][2]);
                    if (listOrder[i][3] == 0) {
                        break;
                    }
                }
                if (listOrder[i][4] != 0) {
                    System.out.println("Fried Noodle X " + listOrder[i][4] + " = Rp " + calculationList[i][3]);
                    if (listOrder[i][4] == 0) {
                        break;
                    }
                }

                System.out.println("Total Order Price Rp:" + calculationList[i][4]+"\n");
                System.out.println("---------------------------------");
        }
    }
}
                System.out.println("Total Order Price: " + customer[i][6]);
            }
            return;
        }   
    }