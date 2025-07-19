import java.util.Scanner;

class FencingWorkCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Stone Pricing
        int price6ftStone = 300;
        int praice7ftStone = 400;
        int price8ftStone = 500;

        // Chain link pricing
        int pricePerSqft5ft = 20;
        int pricePerSqft6ft = 25;

        System.out.println("==== FENCING WORK CALCULATOR ====");

        // Stone Selection
        System.out.println("Select Stone Height:");
        System.out.println("1. 6 Feet (₹300)");
        System.out.println("2. 7 Feet (₹400)");
        System.out.println("3. 8 Feet (₹500)");
        System.out.print("Enter choice (1-3): ");
        int stoneChoice = sc.nextInt();

        int stonePrice = 0;
        String stoneType = "";
        switch (stoneChoice) {
            case 1:
                stonePrice = price6ftStone;
                stoneType = "6ft";
                break;
            case 2:
                stonePrice = price7ftStone;
                stoneType = "7ft";
                break;
            case 3:
                stonePrice = price8ftStone;
                stoneType = "8ft";
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
                return;
        }

        System.out.print("Enter number of stones: ");
        int numberOfStones = sc.nextInt();

        int totalStoneCost = stonePrice * numberOfStones;

        // Chain Link
        System.out.println("\nEnter Chain Link Height (5 or 6 feet): ");
        int chainHeight = sc.nextInt();
        System.out.println("Enter Chain Link Length in feet: ");
        int chainLength = sc.nextInt();

        int chainRate = 0;
        if (chainHeight == 5) {
            chainRate = pricePerSqft5ft;
        } else if (chainHeight == 6) {
            chainRate = pricePerSqft6ft;
        } else {
            System.out.println("Invalid chain height. Exiting...");
            return;
        }

        int chainArea = chainHeight * chainLength;
        int chainCost = chainArea * chainRate;

        // Total Cost
        int totalCost = totalStoneCost + chainCost;

        // Output Summary
        System.out.println("\n====== ESTIMATION SUMMARY ======");
        System.out.println("Stone Type      : " + stoneType);
        System.out.println("Number of Stones: " + numberOfStones);
        System.out.println("Stone Cost      : ₹" + totalStoneCost);
        System.out.println("Chain Link Size : " + chainHeight + "ft x " + chainLength + "ft");
        System.out.println("Chain Link Cost : ₹" + chainCost);
        System.out.println("--------------------------------");
        System.out.println("TOTAL COST      : ₹" + totalCost);
    }
}
