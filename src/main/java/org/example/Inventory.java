package org.example;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private HashMap<String, Integer> products = new HashMap<>();

    public Inventory(HashMap<String, Integer> products) {
        this.products = products;
    }

    public HashMap<String, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<String, Integer> products) {
        this.products = products;
    }

//    addProduct(Parameters)
    public boolean addProduct(HashMap<String, Integer> products, String productName, int productQuantity) {
//        // check if product already in products
//        if (products.containsKey(productName)) {
//            System.out.println("Product is already in the inventory!");
//            return false;
//        }
        // check if valid quantity
        if (productQuantity < 0) {
            System.out.println("Invalid Quantity.");
            return false;
        }
        products.put(productName, productQuantity);
        return true;
    }

//    checkProduct(Parameters)
    public boolean checkProduct(HashMap<String, Integer> products, String productName) {
        //check if product in products
        if (!products.containsKey(productName)) {
            System.out.println("Product is not in the inventory!");
            return false;
        } else {
            // if product in products, check if in store or not
            if (products.get(productName) == 0) {
                System.out.println("Product is out of stock!");
            } else {
                System.out.println(productName + " is in stock: " + products.get(productName));
            }
            return true;
        }
    }

//    updateProduct(Parameters)
    public boolean updateProduct(HashMap<String, Integer> products, String productName, int newQuantity) {
        // check if in products
        if (!products.containsKey(productName)) {
            System.out.println("Product is not in the inventory!");
            return false;
        }
        // check if valid quantity
        if (newQuantity < 0) {
            System.out.println("Invalid Quantity.");
            return false;
        }
        products.put(productName, newQuantity);
        System.out.println("Stock Updated!");
        return true;
    }

//    removeProduct(Parameters)
    public boolean removeProduct(HashMap<String, Integer> products, String productName) {
        if (!products.containsKey(productName)) {
            System.out.println("Product is not in the inventory!");
            return false;
        }

        products.remove(productName);
        System.out.println("Product Removed!");
        return true;
    }

//    viewInventory(Parameters)
    public void displayProduct(HashMap<String, Integer> products) {
        System.out.println("Current Inventory: ");

        if (products.isEmpty()) {
            System.out.println("No products to display.");
        }
        for (Map.Entry<String, Integer> product : products.entrySet()) {
            System.out.print(product.getKey() + " - " + product.getValue());

            if (product.getValue() <= 1) {
                System.out.print(" pc\n");
            } else {
                System.out.print(" pcs\n");
            }
        }
//        System.out.println("--- End of Inventory List ---");
    }

}
