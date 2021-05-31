import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        // Statistics
        float numberOfPurchasedTickets = 0;
        float percentageCapacity;
        int currentIncome = 0;
        int totalIncome = 0;

        Scanner scanner = new Scanner(System.in);

        // Initial seating dimensions
        System.out.println("Enter the number of rows:");
        float nRows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        float nSeats = scanner.nextInt();

        char[][] seatingArrangement = new char[(int) (nRows + 1)][(int) (nSeats + 1)];

        // Calculate total income if every set were filled
        if (nRows * nSeats <= 60) {
            totalIncome = (int) ((nRows * nSeats) * 10);
        } else {
            for (int i = 0; i < seatingArrangement.length; i++) {
                for (int j = 1; j < seatingArrangement[i].length; j++) {
                    if (i <= (int) (nRows / 2) - 1) {
                        totalIncome += 10;
                    } else if (i <= nRows - 1) {
                        totalIncome += 8;
                    }
                }
            }
        }

        System.out.println();

        // Display menu
        boolean displayMenu = true;
        boolean ticketsPurchased = false;

        while (displayMenu) {

            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            int menuChoice = scanner.nextInt();
            switch (menuChoice) {
                case 1 -> {
                    System.out.println();
                    for (int i = 0; i < seatingArrangement.length; i++) {
                        for (int j = 0; j < seatingArrangement[i].length; j++) {
                            if (i == 0 && j == 0 || seatingArrangement[i][j] == 'B') {
                                continue;
                            }
                            seatingArrangement[i][j] = 'S';
                        }
                    }
                    char count = '1';
                    for (int i = 1; i < seatingArrangement[0].length; i++) {
                        seatingArrangement[0][i] = count;
                        count++;
                    }
                    count = '1';
                    for (int i = 1; i < seatingArrangement.length; i++) {
                        seatingArrangement[i][0] = count;
                        count++;
                    }
                    System.out.println("Cinema:");
                    for (char[] chars : seatingArrangement) {
                        for (int j = 0; j < seatingArrangement[0].length; j++) {
                            System.out.print(chars[j] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
                case 2 -> {
                    System.out.println();
                    boolean ticketPurchased = false;
                    while (!ticketPurchased) {

                        System.out.println("Enter a row number:");
                        int rowNumber = scanner.nextInt();

                        System.out.println("Enter a seat number in that row:");
                        int seatNumber = scanner.nextInt();

                        if (rowNumber < 1 || rowNumber > nRows || seatNumber < 1 || seatNumber > nSeats) {
                            System.out.println();
                            System.out.println("Wrong input!");
                            System.out.println();
                        } else {

                            for (int i = 0; i < seatingArrangement.length; i++) {
                                for (int j = 0; j < seatingArrangement[i].length; j++) {

                                    if (i == rowNumber && j == seatNumber) {
                                        if (seatingArrangement[rowNumber][seatNumber] == 'B') {
                                            System.out.println();
                                            System.out.println("That ticket has already been purchased!");
                                            System.out.println();
                                        } else {
                                            seatingArrangement[i][j] = 'B';

                                            System.out.println();

                                            if (nRows * nSeats <= 60) {
                                                System.out.println("Ticket price: $10");
                                                currentIncome += 10;
                                            } else if (nRows * nSeats > 60 && rowNumber <= nRows / 2) {
                                                System.out.println("Ticket price: $10");
                                                currentIncome += 10;
                                            } else {
                                                System.out.println("Ticket price: $8");
                                                currentIncome += 8;
                                            }

                                            System.out.println();

                                            numberOfPurchasedTickets++;
                                            ticketPurchased = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                case 3 -> {
                    percentageCapacity = (numberOfPurchasedTickets / (nRows * nSeats)) * 100;

                    // Statistics menu
                    System.out.println();
                    System.out.printf("""
                                    Number of purchased tickets: %.0f
                                    Percentage: %.2f%%
                                    Current income: $%d
                                    Total income: $%d
                                    """,
                            numberOfPurchasedTickets,
                            percentageCapacity,
                            currentIncome,
                            totalIncome);
                    System.out.println();
                }
                case 0 ->
                        // Exit display
                        displayMenu = false;
            }
        }
    }
}
