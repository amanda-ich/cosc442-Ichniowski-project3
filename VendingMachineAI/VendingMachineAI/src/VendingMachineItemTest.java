/*
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class VendingMachineItemTest {

    @Test
    void constructorStoresNameAndPrice() throws VendingMachineException {
        VendingMachineItem item = new VendingMachineItem("Chips", 1.50);

        assertEquals("Chips", item.getName());
        assertEquals(1.50, item.getPrice(), 0.000001);
    }

    @Test
    void constructorAllowsZeroPrice() throws VendingMachineException {
        VendingMachineItem item = new VendingMachineItem("Free sample", 0.0);

        assertEquals("Free sample", item.getName());
        assertEquals(0.0, item.getPrice(), 0.000001);
    }

    @Test
    void constructorRejectsNegativePrice() {
        VendingMachineException exception = assertThrows(
                VendingMachineException.class,
                () -> new VendingMachineItem("Chips", -0.01));

        assertEquals("Price cannot be less than zero", exception.getMessage());
    }
}
*/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VendingMachineItemTest {
    @Test
    void constructorAndGettersCoverValidAndInvalidPrices() throws VendingMachineException {
        VendingMachineItem free = new VendingMachineItem("Free sample", 0.0);
        VendingMachineItem priced = new VendingMachineItem("Chips", 1.50);
        assertEquals("Free sample", free.getName());
        assertEquals(0.0, free.getPrice(), 0.000001);
        assertEquals("Chips", priced.getName());
        assertEquals(1.50, priced.getPrice(), 0.000001);

        VendingMachineException exception = assertThrows(
            VendingMachineException.class,
            () -> new VendingMachineItem("Invalid", -0.01));
        assertEquals("Price cannot be less than zero", exception.getMessage());
    }
}
