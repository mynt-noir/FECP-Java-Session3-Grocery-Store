package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    }
//
//
//    @Test
//    void addProductInvalidQuantity {
//
//    }
//
//
//    @Test
//    void addProductZeroQuantity {
//
//    }
//    @Test
//    void addProductDuplicateName {
//
//    }
//
//
//    @Test
//    void checkProductValidName {
//
//    }
//
//
//    @Test
//    void checkProductInvalidName {
//
//    }
//
//
//    @Test
//    void updateStockValidName {
//
//    }
//
//
//    @Test
//    void updateStockInvalidName {
//
//    }
//
//    @Test
//    void updateStockValidQuantity {
//
//    }
//
//    @Test
//    void updateStockInvalidQuantity {
//
//    }
//
//    @Test
//    void updateStockZeroQuantity {
//
//    }
//
//    @Test
//    void removeProductValidName {
//
//    }
//
//
//    @Test
//    void removeProductInvalidName {
//
//    }
//

}