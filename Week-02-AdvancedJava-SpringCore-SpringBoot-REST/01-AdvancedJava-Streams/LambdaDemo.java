package week2.streams;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

// Custom Functional Interface with single abstract method
@FunctionalInterface
interface TaxCalculator {
    double calculateTax(double salary);
}

public class LambdaDemo {
    public static void main(String[] args) {
        System.out.println("--- Advanced Java: Lambda Expressions Demo ---");

        // 1. Using Custom Functional Interface with Lambda
        TaxCalculator newRegimeTax = (salary) -> {
            if (salary <= 700000) return 0.0;
            return (salary - 700000) * 0.10;
        };
        double mySalary = 850000.0;
        System.out.printf("Tax for Salary ₹%,.2f: ₹%,.2f\n", mySalary, newRegimeTax.calculateTax(mySalary));

        // 2. java.util.function.Predicate (Tests a condition and returns boolean)
        Predicate<Integer> isEligibleForBonus = (performanceScore) -> performanceScore >= 85;
        System.out.println("Is score 88 eligible for bonus? " + isEligibleForBonus.test(88));

        // 3. java.util.function.Function (Transforms input T to output R)
        Function<String, String> emailFormatter = (name) -> name.toLowerCase().replace(" ", ".") + "@cognizant.com";
        System.out.println("Formatted Email: " + emailFormatter.apply("Ashish Kumar"));

        // 4. java.util.function.Consumer (Consumes input T and returns void)
        Consumer<String> welcomeNotifier = (user) -> System.out.println("[NOTIFY] Welcome to DNS 5.0 Week 2, " + user + "!");
        welcomeNotifier.accept("Ashish");
    }
}
