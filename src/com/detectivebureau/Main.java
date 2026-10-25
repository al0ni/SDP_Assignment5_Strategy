package com.detectivebureau;
import com.detectivebureau.core.DetectiveBureau;
import com.detectivebureau.model.Detective;
import com.detectivebureau.model.Evidence;
import com.detectivebureau.strategy.AllocationStrategy;
import com.detectivebureau.strategy.LeastLoadedStrategy;
import com.detectivebureau.strategy.RoundRobinStrategy;
import com.detectivebureau.strategy.SpecializationStrategy;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Detective> detectives = Arrays.asList(
                new Detective("Mira", "digital", 2),
                new Detective("Adam", "fingerprint", 0),
                new Detective("Nora", "document", 1)
        );

        Evidence[] evidence = {
            new Evidence("Phone messages", "digital"),
            new Evidence("Glass fingerprint", "fingerprint"),
            new Evidence("Handwritten letter", "document"),
            new Evidence("Unknown powder", "chemical")
        };

        AllocationStrategy[] strategies = {
            new RoundRobinStrategy(),
            new LeastLoadedStrategy(),
            new SpecializationStrategy()
        };

        DetectiveBureau bureau = new DetectiveBureau(detectives, strategies[0]);
        Scanner scanner = new Scanner(System.in);
        int evidenceIndex = 0;

        System.out.println("Detective Bureau - evidence desk");
        printWorkloads(detectives);

        while (evidenceIndex < evidence.length) {
            Evidence currentEvidence = evidence[evidenceIndex];

            System.out.println("\n--- Next evidence item ---");
            System.out.println(currentEvidence.getTitle() + " [" + currentEvidence.getType() + "]");
            System.out.println("1. Give the next detective a turn");
            System.out.println("2. Find someone with less work");
            System.out.println("3. Look for a matching specialist");
            System.out.println("0. Close the evidence desk");
            System.out.print("How should we assign this one? ");

            if (!scanner.hasNext()) {
                break;
            }
            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Use a menu number: 0, 1, 2 or 3.");
                continue;
            }

            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }
            if (choice < 1 || choice > strategies.length) {
                System.out.println("That option is not on the menu.");
                continue;
            }

            bureau.setStrategy(strategies[choice - 1]);
            Detective target = bureau.assignEvidence(currentEvidence);
            System.out.println(currentEvidence.getTitle() + " -> " + target.getName());

            evidenceIndex++;
            printWorkloads(detectives);
        }

        System.out.println("\nEvidence desk closed.");
        scanner.close();
    }

    private static void printWorkloads(List<Detective> detectives) {
        System.out.println("\n--- Work already assigned ---");
        for (Detective detective : detectives) {
            System.out.println(detective.getName() + ": " + detective.getWorkload());
        }
    }
}
