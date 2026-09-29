package programminglaboratoryweek2;

import java.util.Scanner;

public class ProgrammingLaboratoryWeek2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("How much is the capacity of the bus? ");
        int capacity = scanner.nextInt();

        System.out.println("How many stops are there? ");
        int stopnumber = scanner.nextInt();
        String[] names = new String[stopnumber];
        int[] boarding = new int[stopnumber];
        int[] getoff = new int[stopnumber];
        int[] occupancy = new int[stopnumber];
        int current = 0;
        int overc = 0;

        scanner.nextLine();

        for (int i = 0; i < stopnumber; i++) {
            int order = i + 1;
            System.out.println("--- " + order + ". Stops Informations ---");
            System.out.print("Stop name: ");
            names[i] = scanner.next();
            System.out.print("Boarding number: ");
            boarding[i] = scanner.nextInt();
            System.out.print("Alighting number: ");
            getoff[i] = scanner.nextInt();

            scanner.nextLine();

            current = current + boarding[i];
            current = current - getoff[i];

            if (current < 0) {
                System.out.println("Data error at " + names[i] + ": cannot have more passengers alighting than are currently on the bus. Occupancy set to 0.");
                current = 0;
            }

            System.out.println("Current Passenger: " + current);
            if (current > capacity) {
                System.out.println("Warnings: Bus is over capacity at " + names[i] + "!");
                overc = overc + 1;
            }
            occupancy[i] = current;
        }

        System.out.printf("%-10s %-10s %-10s %-10s \n", "Stop Name", "Boarding", "Alighting", "Occupancy");
        System.out.println("");
        System.out.println("----------------------------------------");

        for (int j = 0; j < stopnumber; j++) {
            System.out.printf("%-10s %-10d %-10d %-10d \n", names[j], boarding[j], getoff[j], occupancy[j]);
            System.out.println("");
        }

        System.out.println("----------- STATISTICS ------------");
        int maxboarding = boarding[0];
        int stopindex = 0;

        for (int k = 1; k < boarding.length; k++) {
            if (maxboarding < boarding[k]) {
                maxboarding = boarding[k];
                stopindex = k;
            }
        }

        System.out.println("Bussiest stop is: " + names[stopindex] + " with number of " + maxboarding);
        double avrocc = 0;
        int totalao = 0;

        for (int f = 0; f < stopnumber; f++) {
            totalao += occupancy[f];
        }

        avrocc = (double) totalao / stopnumber;
        System.out.println("Average occupancy is: " + avrocc);
        System.out.println("Number of overcapacity stops: " + overc);

        if (current == 0) {
            System.out.println("Everybody off the bus!");
        } else {
            System.out.println("Warning: " + current + " passengers still on the bus after the final stop. Please check your data.");
        }
    }
}
