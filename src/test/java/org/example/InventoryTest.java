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
        boolean addProductSuccess = inventory.addProduct(products, "Bread", 50);
        assertTrue(addProductSuccess);
        assertTrue(products.containsKey("Bread"), "HashMap should contain 'Bread' key");
        assertEquals(50, products.get("Bread"), "Quantity for 'Bread' should be 50");
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
        boolean addProductSuccess = inventory.addProduct(products, "Eggs", 50);
        boolean duplicateAddProductSuccess = inventory.addProduct(products, "Eggs", 100);

        assertTrue(addProductSuccess);
        assertFalse(duplicateAddProductSuccess);

        assertTrue(products.containsKey("Eggs"), "HashMap should contain 'Eggs' key");
        assertEquals(50, products.get("Eggs"), "Quantity for 'Eggs' should be 50");
    }

    @Test
    void addProductZeroQuantity() {
        HashMap<String, Integer> products = new HashMap<>();
        inventory = new Inventory(products);
        boolean addProductSuccess = inventory.addProduct(products, "Bread", 0);
        assertTrue(addProductSuccess);
        assertTrue(products.containsKey("Bread"), "HashMap should contain 'Bread' key");
        assertEquals(0, products.get("Bread"), "Quantity for 'Bread' should be 0");

    }


    @Test
    void checkProductValidName() {
        HashMap<String, Integer> products = new HashMap<>();
        inventory = new Inventory(products);
        boolean addProductSuccess = inventory.addProduct(products, "Milk", 100);
        assertTrue(addProductSuccess);

        boolean checkProductSuccess = inventory.checkProduct(products, "Milk");
        assertTrue(checkProductSuccess);
        assertTrue(products.containsKey("Milk"), "HashMap should contain 'Milk' key");
        assertEquals(100, products.get("Milk"), "Quantity for 'Milk' should be 100");
    }


    @Test
    void checkProductInvalidName() {
        HashMap<String, Integer> products = new HashMap<>();
        inventory = new Inventory(products);
        boolean addProductSuccess = inventory.addProduct(products, "Milk", 100);
        assertTrue(addProductSuccess);

        boolean checkProductSuccess = inventory.checkProduct(products, "Milks");
        assertFalse(checkProductSuccess);
        assertFalse(products.containsKey("Milks"), "HashMap should not contain 'Milks' key");
    }


    @Test
    void updateStockValidNameValidQuantity() {
        HashMap<String, Integer> products = new HashMap<>();
        inventory = new Inventory(products);
        boolean addProductSuccess = inventory.addProduct(products, "Milk", 100);
        assertTrue(addProductSuccess);

        boolean updateStockSuccess = inventory.updateProduct(products, "Milk", 50);
        assertTrue(updateStockSuccess);
        assertTrue(products.containsKey("Milk"), "HashMap should contain 'Milk' key");
        assertEquals(50, products.get("Milk"), "Quantity for 'Milk' should be 50");

    }


    @Test
    void updateStockInvalidName() {
        HashMap<String, Integer> products = new HashMap<>();
        inventory = new Inventory(products);
        boolean addProductSuccess = inventory.addProduct(products, "Milk", 100);
        assertTrue(addProductSuccess);

        boolean updateStockSuccess = inventory.updateProduct(products, "Milks", 50);
        assertFalse(updateStockSuccess);
        assertFalse(products.containsKey("Milks"), "HashMap should not contain 'Milks' key");
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
        boolean addProductSuccess = inventory.addProduct(products, "Ham", 80);
        assertTrue(addProductSuccess);

        boolean removeProductSuccess = inventory.removeProduct(products, "Ham");
        assertTrue(removeProductSuccess);

        assertFalse(products.containsKey("Ham"), "HashMap should contain 'Ham' key");

    }


    @Test
    void removeProductInvalidName() {
        HashMap<String, Integer> products = new HashMap<>();
        inventory = new Inventory(products);
        boolean addProductSuccess = inventory.addProduct(products, "Ham", 80);
        assertTrue(addProductSuccess);

        boolean removeProductSuccess = inventory.removeProduct(products, "Hams");
        assertFalse(removeProductSuccess);

        assertTrue(products.containsKey("Ham"), "HashMap should contain 'Ham' key");
        assertEquals(80, products.get("Ham"), "Quantity for 'Ham' should be 80");
    }


}