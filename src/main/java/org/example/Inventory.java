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
    public String addProduct(HashMap<String, Integer> products, String productName, Integer productQuantity) {
        return "Product Added!";
    }

//    checkProduct(Parameters)
//    updateProduct(Parameters)
    public String updateProduct(HashMap<String, Integer> products, String productName, Integer productQuantity, Integer newQuantity) {
        return "Product Updated!";
    }

//    removeProduct(Parameters)
    public String productRemoved(HashMap<String, Integer> products, String productName) {
        return "Product Removed!";
    }
//    viewInventory(Parameters)
    public void displayProduct(HashMap<String, Integer> products) {
        for (Map.Entry<String, Integer> product : products.entrySet()) {
            System.out.print(product.getKey() + " - " + product.getValue());

            if (product.getValue() <= 0) {
                System.out.print(" pc\n");
            } else {
                System.out.print(" pcs\n");
            }
        }
        System.out.println("--- End of Inventory List ---");
    }

}
