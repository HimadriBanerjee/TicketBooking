import java.util.Scanner;
public class Berth {
    private static int[] berths = new int[40];
    public static void main(String args[]) {
        for (int i = 0; i < 40; i++) {         //setting all berths to zero
            berths[i] = 0;
        }
        Scanner s = new Scanner(System.in);
        int choice=1;                         //default choice lower berth
        System.out.println("Please enter 1 for lower berth,2 for upper berth,0 to exit: ");
        choice = s.nextInt();                 //saving choice
        while (choice != 0) {
            int berthnumber = 0;
            if (choice == 1) {
                berthnumber = bookLowerberth();
                //no lower berth availabe,try booking upper berth
                if (berthnumber == -1) {
                    berthnumber = bookUpperberth();
                    if (berthnumber != -1) {
                        System.out.println("Sorry, we were not able to book a lower berth. But do have an upper berth.");
                        printBoardingPass(berthnumber);
                    }
                }
                else {
                    // Booking a lower berth was successful.
                    System.out.println("You are in luck, we have a lower berth available!");
                    printBoardingPass(berthnumber);
                }
            }
           else if (choice == 2) {
               //check for berth availability
                berthnumber = bookUpperberth();
                if (berthnumber == -1) {
                    berthnumber = bookLowerberth();
                    if (berthnumber != -1) {
                        System.out.println("Sorry, we were not able to book an upper berth. But do have a lower berth.");
                        printBoardingPass(berthnumber);
                    }
                } else {
                    System.out.println("You are in luck, we have an upper berth available!");
                    printBoardingPass(berthnumber);
                }
            }
            else {
                //error message if they did not choose 1, 2, or 0 for their choice.
                System.out.println("Invalid choice made. Please try again!");
                choice = 0;
            }
            //no berth available
            if (berthnumber == -1) {
                System.out.println("We are sorry, there are no lower or upper berth available.");
                System.out.println();
            }
            System.out.print("Please enter 1 for lower berth, 2 for upper berth, or 0 to exit: ");
            choice = s.nextInt();
        }
    }
    private static int bookLowerberth() {
        for (int i = 0; i < 20; i++) {
            if (berths[i] == 0) {
                berths[i] = 1;
                return i + 1;
            }
        }
        return -1;
    }
    private static int bookUpperberth() {
        for (int i = 20; i < 40; i++) {
            if (berths[i] == 0){
                berths[i] = 1;
            return i + 1;
        }
    }
    return-1;
}
    private static void printBoardingPass(int berthnumber) {
        System.out.println("Boarding pass for berth number" + berthnumber);
        System.out.println("This ticket is non transferable.");
        System.out.println("Please be courteous.Do not smoke.");
        System.out.println("Enjoy your journey.");
        System.out.println();
    }
}
