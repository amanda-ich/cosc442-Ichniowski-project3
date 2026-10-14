package game;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InventoryTest {
    private Inventory inventory;
    private Item apple;
    private Item sword;
    private Item potion;
    private Item createItem(String name) {
        return new Item('!', Color.RED, name, null);
    }

    @BeforeEach
    void setUp() {
        this.inventory = new Inventory(2);
        this.apple = createItem("apple");
        this.sword = createItem("sword");
        this.potion = createItem("potion");
    }

    @AfterEach
    void tearDown() {
        this.inventory = null;
        this.apple = null;
        this.sword = null;
        this.potion = null;
    }

    @Test
    void testAddGetContainsAndIsFull() {
        // Initially empty
        assertFalse(inventory.isFull());
        assertFalse(inventory.contains(apple));
        assertEquals(2, inventory.getItems().length);
        assertNull(inventory.get(0));

        // Add items and verify their positions
        inventory.add(apple);
        assertSame(apple, inventory.get(0));
        assertTrue(inventory.contains(apple));
        assertFalse(inventory.isFull());

        inventory.add(sword);
        assertSame(sword, inventory.get(1));
        assertTrue(inventory.contains(sword));
        assertTrue(inventory.isFull());

        // Adding to a full inventory should have no effect
        inventory.add(potion);
        assertFalse(inventory.contains(potion));
        assertSame(apple, inventory.get(0));
        assertSame(sword, inventory.get(1));
    }

    @Test
    void testRemoveExistingAndNonExistingItems() {
        Item anotherApple = createItem("apple");

        inventory.add(apple);
        inventory.add(sword);

        // Remove an existing item
        inventory.remove(apple);
        assertNull(inventory.get(0));
        assertFalse(inventory.contains(apple));
        assertTrue(inventory.contains(sword));
        assertFalse(inventory.isFull());

        // A different object with the same name is not the same item
        inventory.add(apple);
        inventory.remove(anotherApple);
        assertTrue(inventory.contains(apple));

        // Removing an item that is not present changes nothing
        inventory.remove(this.potion);
        assertTrue(inventory.contains(apple));
        assertTrue(inventory.contains(sword));
        assertTrue(inventory.isFull());
    }

    @Test
    void testZeroCapacityInventory() {
        Inventory inventory2 = new Inventory(0);

        assertEquals(0, inventory2.getItems().length);
        assertTrue(inventory2.isFull());
        assertFalse(inventory2.contains(apple));

        // Operations on an empty array should not throw exceptions
        inventory2.add(apple);
        inventory2.remove(apple);

        assertFalse(inventory2.contains(apple));
        assertTrue(inventory2.isFull());
    }
}