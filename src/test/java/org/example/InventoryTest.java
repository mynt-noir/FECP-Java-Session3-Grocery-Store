package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    private Inventory inventory;
    private HashMap<String, Integer> products;


    @BeforeEach
    public void setUp() {
        HashMap<String, Integer> products = new HashMap<>();
        inventory = new Inventory(products);
        inventory.addProduct(products, "Milk", 100);
    }

    @Test
    void addProductValidQuantity() {
        HashMap<String, Integer> products = new HashMap<>();
        inventory = new Inventory(products);
        boolean addProductSuccess = inventory.addProduct(products, "Banana", 30);
        assertTrue(addProductSuccess);
        assertTrue(products.containsKey("Banana"), "HashMap should contain 'Banana' key");
        assertEquals(30, products.get("Banana"), "Quantity for 'Banana' should be 30");
    }


    @Test
    void addProductInvalidQuantity() {
        HashMap<String, Integer> products = new HashMap<>();
        inventory = new Inventory(products);
        boolean addProductSuccess = inventory.addProduct(products, "Bread", -50);
        assertFalse(addProductSuccess);
        assertFalse(products.containsKey("Bread"), "HashMap should not contain 'Bread' key");
    }


    @Test
    void addProductDuplicateName() {
        HashMap<String, Integer> products = new HashMap<>();
        inventory = new Inventory(products);
        boolean addProductSuccess = inventory.addProduct(products, "Milk", 20);
        boolean duplicateAddProductSuccess = inventory.addProduct(products, "Milk", 50);

        assertTrue(addProductSuccess);
        assertTrue(duplicateAddProductSuccess);

        assertTrue(products.containsKey("Milk"), "HashMap should contain 'Milk' key");
        assertEquals(50, products.get("Milk"), "Quantity for 'Milk' should be 50");
    }

    @Test
    void addProductZeroQuantity() {
        HashMap<String, Integer> products = new HashMap<>();
        inventory = new Inventory(products);
        boolean addProductSuccess = inventory.addProduct(products, "Mango", 0);
        assertTrue(addProductSuccess);
        assertTrue(products.containsKey("Mango"), "HashMap should contain 'Mango' key");
        assertEquals(0, products.get("Mango"), "Quantity for 'Mango' should be 0");

    }


    @Test
    void checkProductValidName() {
        HashMap<String, Integer> products = new HashMap<>();
        inventory = new Inventory(products);
        boolean addProductSuccess = inventory.addProduct(products, "Milk", 20);
        assertTrue(addProductSuccess);

        boolean checkProductSuccess = inventory.checkProduct(products, "Milk");
        assertTrue(checkProductSuccess);
        assertTrue(products.containsKey("Milk"), "HashMap should contain 'Milk' key");
        assertEquals(20, products.get("Milk"), "Quantity for 'Milk' should be 20");
    }


    @Test
    void checkProductInvalidName() {
        HashMap<String, Integer> products = new HashMap<>();
        inventory = new Inventory(products);
        boolean addProductSuccess = inventory.addProduct(products, "Milk", 20);
        assertTrue(addProductSuccess);

        boolean checkProductSuccess = inventory.checkProduct(products, "Ice Cream");
        assertFalse(checkProductSuccess);
        assertFalse(products.containsKey("Ice Cream"), "HashMap should not contain 'Ice Cream' key");
    }


    @Test
    void updateStockValidNameValidQuantity() {
        HashMap<String, Integer> products = new HashMap<>();
        inventory = new Inventory(products);
        boolean addProductSuccess = inventory.addProduct(products, "Bread", 100);
        assertTrue(addProductSuccess);

        boolean updateStockSuccess = inventory.updateProduct(products, "Bread", 25);
        assertTrue(updateStockSuccess);
        assertTrue(products.containsKey("Bread"), "HashMap should contain 'Bread' key");
        assertEquals(25, products.get("Bread"), "Quantity for 'Bread' should be 25");

    }


    @Test
    void updateStockInvalidName() {
        HashMap<String, Integer> products = new HashMap<>();
        inventory = new Inventory(products);
        boolean addProductSuccess = inventory.addProduct(products, "Milk", 100);
        assertTrue(addProductSuccess);

        boolean updateStockSuccess = inventory.updateProduct(products, "Tofu", 50);
        assertFalse(updateStockSuccess);
        assertFalse(products.containsKey("Tofu"), "HashMap should not contain 'Tofu' key");
    }


    @Test
    void updateStockInvalidQuantity() {
        HashMap<String, Integer> products = new HashMap<>();
        inventory = new Inventory(products);
        boolean addProductSuccess = inventory.addProduct(products, "Milk", 100);
        assertTrue(addProductSuccess);

        boolean updateStockSuccess = inventory.updateProduct(products, "Milk", -50);
        assertFalse(updateStockSuccess);
        assertTrue(products.containsKey("Milk"), "HashMap should contain 'Milk' key");
        assertEquals(100, products.get("Milk"), "Quantity for 'Milk' should be 100");
    }

    @Test
    void updateStockZeroQuantity() {
        HashMap<String, Integer> products = new HashMap<>();
        inventory = new Inventory(products);
        boolean addProductSuccess = inventory.addProduct(products, "Milk", 100);
        assertTrue(addProductSuccess);

        boolean updateStockSuccess = inventory.updateProduct(products, "Milk", 0);
        assertTrue(updateStockSuccess);
        assertTrue(products.containsKey("Milk"), "HashMap should contain 'Milk' key");
        assertEquals(0, products.get("Milk"), "Quantity for 'Milk' should be 0");
    }

    @Test
    void removeProductValidName() {
        HashMap<String, Integer> products = new HashMap<>();
        inventory = new Inventory(products);
        boolean addProductSuccess = inventory.addProduct(products, "Eggs", 80);
        assertTrue(addProductSuccess);

        boolean removeProductSuccess = inventory.removeProduct(products, "Eggs");
        assertTrue(removeProductSuccess);

        assertFalse(products.containsKey("Eggs"), "HashMap should contain 'Eggs' key");

    }


    @Test
    void removeProductInvalidName() {
        HashMap<String, Integer> products = new HashMap<>();
        inventory = new Inventory(products);
        boolean addProductSuccess = inventory.addProduct(products, "Ham", 80);
        assertTrue(addProductSuccess);

        boolean removeProductSuccess = inventory.removeProduct(products, "Pizza");
        assertFalse(removeProductSuccess);

        assertTrue(products.containsKey("Ham"), "HashMap should contain 'Ham' key");
        assertEquals(80, products.get("Ham"), "Quantity for 'Ham' should be 80");
    }


}