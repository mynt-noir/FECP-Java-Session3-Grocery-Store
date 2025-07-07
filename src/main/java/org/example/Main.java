package org.example;

import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main (String[] args){
        HashMap<String, Integer> products = new HashMap<>();
        Inventory inventory = new Inventory(products);
        Scanner scanner = new Scanner(System.in);
        int choice;
        String productName;
        int productQuantity;
        int newQuantity;

        do {

            System.out.println("--- Grocery Inventory Menu ---");
            System.out.println("1. View Inventory");
            System.out.println("2. Add Product");
            System.out.println("3. Check Product");
            System.out.println("4. Update Stock");
            System.out.println("5. Remove Product");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    // view inventory
                    inventory.displayProduct(products);
                    System.out.println();
                }

                case 2 -> {
                    // add product
                    System.out.print("Enter product name: ");
                    productName = scanner.next();
                    System.out.print("Enter quantity: ");
                    productQuantity = scanner.nextInt();
                    inventory.addProduct(products, productName, productQuantity);
                    System.out.println();
                }

                case 3 -> {
                    // check product
                    System.out.print("Enter product name to check: ");
                    productName = scanner.next();
                    inventory.checkProduct(products, productName);
                    System.out.println();
                }

                case 4 -> {
                    // update stock
                    System.out.print("Enter product name to update: ");
                    productName = scanner.next();
                    System.out.print("Enter new stock quantity: ");
                    newQuantity = scanner.nextInt();
                    inventory.updateProduct(products, productName, newQuantity);
                    System.out.println();
                }

                case 5 -> {
                    // remove product
                    System.out.print("Enter product name to remove: ");
                    productName = scanner.next();
                    inventory.removeProduct(products, productName);
                    System.out.println();
                }

                default -> {
                    // exit
                    System.out.println("Exiting system...");
                    return;
                }
            }
        } while (choice != 6);

    }
}