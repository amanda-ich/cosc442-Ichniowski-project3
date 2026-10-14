/*
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VendingMachineTest {
    private VendingMachine machine;

    @BeforeEach
    void setUp() {
        machine = new VendingMachine();
    }

    @Test
    void constructorStartsWithZeroBalanceAndEmptySlots() throws VendingMachineException {
        assertEquals(0.0, machine.getBalance(), 0.000001);
        assertNull(machine.getItem(VendingMachine.A_CODE));
        assertNull(machine.getItem(VendingMachine.B_CODE));
        assertNull(machine.getItem(VendingMachine.C_CODE));
        assertNull(machine.getItem(VendingMachine.D_CODE));
    }

    @Test
    void addItemStoresItemInEachValidSlot() throws VendingMachineException {
        VendingMachineItem a = new VendingMachineItem("Apple", 1.0);
        VendingMachineItem b = new VendingMachineItem("Bread", 2.0);
        VendingMachineItem c = new VendingMachineItem("Chips", 1.5);
        VendingMachineItem d = new VendingMachineItem("Drink", 2.5);

        machine.addItem(a, VendingMachine.A_CODE);
        machine.addItem(b, VendingMachine.B_CODE);
        machine.addItem(c, VendingMachine.C_CODE);
        machine.addItem(d, VendingMachine.D_CODE);

        assertSame(a, machine.getItem(VendingMachine.A_CODE));
        assertSame(b, machine.getItem(VendingMachine.B_CODE));
        assertSame(c, machine.getItem(VendingMachine.C_CODE));
        assertSame(d, machine.getItem(VendingMachine.D_CODE));
    }

    @Test
    void addItemRejectsOccupiedSlot() throws VendingMachineException {
        machine.addItem(new VendingMachineItem("Apple", 1.0), "A");

        VendingMachineException exception = assertThrows(
                VendingMachineException.class,
                () -> machine.addItem(new VendingMachineItem("Pear", 1.0), "A"));

        assertEquals("Slot A already occupied", exception.getMessage());
        assertEquals("Apple", machine.getItem("A").getName());
    }

    @Test
    void addItemRejectsInvalidCode() throws VendingMachineException {
        VendingMachineException exception = assertThrows(
                VendingMachineException.class,
                () -> machine.addItem(new VendingMachineItem("Apple", 1.0), "E"));

        assertEquals("Invalid code for vending machine item", exception.getMessage());
    }

    @Test
    void getItemRejectsInvalidCode() {
        assertThrows(VendingMachineException.class, () -> machine.getItem("Z"));
    }

    @Test
    void removeItemReturnsItemAndEmptiesSlot() throws VendingMachineException {
        VendingMachineItem item = new VendingMachineItem("Apple", 1.0);
        machine.addItem(item, "B");

        assertSame(item, machine.removeItem("B"));
        assertNull(machine.getItem("B"));
    }

    @Test
    void removeItemFromEmptySlotThrowsException() {
        VendingMachineException exception = assertThrows(
                VendingMachineException.class,
                () -> machine.removeItem("C"));

        assertEquals("Slot C is empty -- cannot remove item", exception.getMessage());
    }

    @Test
    void removeItemRejectsInvalidCode() {
        assertThrows(VendingMachineException.class, () -> machine.removeItem("X"));
    }

    @Test
    void insertMoneyAddsToBalance() throws VendingMachineException {
        machine.insertMoney(1.0);
        machine.insertMoney(2.5);

        assertEquals(3.5, machine.getBalance(), 0.000001);
    }

    @Test
    void insertMoneyRejectsAmountBelowOneAndDoesNotChangeBalance() {
        assertThrows(VendingMachineException.class, () -> machine.insertMoney(0.0));
        assertThrows(VendingMachineException.class, () -> machine.insertMoney(0.99));
        assertEquals(0.0, machine.getBalance(), 0.000001);
    }

    @Test
    void insertMoneyRejectsNegativeAmount() {
        assertThrows(VendingMachineException.class, () -> machine.insertMoney(-1.0));
        assertEquals(0.0, machine.getBalance(), 0.000001);
    }

    @Test
    void makePurchaseSucceedsWithExactBalanceAndRemovesItem() throws VendingMachineException {
        VendingMachineItem item = new VendingMachineItem("Chips", 1.5);
        machine.addItem(item, "A");
        machine.insertMoney(1.5);

        assertTrue(machine.makePurchase("A"));
        assertNull(machine.getItem("A"));
        assertEquals(0.0, machine.getBalance(), 0.000001);
    }

    @Test
    void makePurchaseSucceedsWithExcessBalanceAndKeepsRemainder() throws VendingMachineException {
        machine.addItem(new VendingMachineItem("Drink", 1.25), "D");
        machine.insertMoney(3.0);

        assertTrue(machine.makePurchase("D"));
        assertEquals(1.75, machine.getBalance(), 0.000001);
        assertNull(machine.getItem("D"));
    }

    @Test
    void makePurchaseReturnsFalseWhenBalanceIsInsufficient() throws VendingMachineException {
        VendingMachineItem item = new VendingMachineItem("Sandwich", 4.0);
        machine.addItem(item, "B");
        machine.insertMoney(1.0);

        assertFalse(machine.makePurchase("B"));
        assertSame(item, machine.getItem("B"));
        assertEquals(1.0, machine.getBalance(), 0.000001);
    }

    @Test
    void makePurchaseReturnsFalseForEmptySlot() throws VendingMachineException {
        machine.insertMoney(1.0);

        assertFalse(machine.makePurchase("C"));
        assertEquals(1.0, machine.getBalance(), 0.000001);
    }

    @Test
    void makePurchaseRejectsInvalidCode() {
        assertThrows(VendingMachineException.class, () -> machine.makePurchase("Q"));
    }

    @Test
    void returnChangeReturnsBalanceAndResetsItToZero() throws VendingMachineException {
        machine.insertMoney(2.0);
        machine.insertMoney(3.0);

        assertEquals(5.0, machine.returnChange(), 0.000001);
        assertEquals(0.0, machine.getBalance(), 0.000001);
    }

    @Test
    void returnChangeOnZeroBalanceReturnsZero() {
        assertEquals(0.0, machine.returnChange(), 0.000001);
        assertEquals(0.0, machine.getBalance(), 0.000001);
    }
}
*/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VendingMachineTest {
    private VendingMachine machine;

    @BeforeEach
    void setUp() {
        machine = new VendingMachine();
    }

    @Test
    void slotOperationsCoverAllCodesAndErrors() throws VendingMachineException {
        VendingMachineItem a = new VendingMachineItem("Apple", 1.0);
        VendingMachineItem b = new VendingMachineItem("Bread", 2.0);
        VendingMachineItem c = new VendingMachineItem("Chips", 1.5);
        VendingMachineItem d = new VendingMachineItem("Drink", 2.5);

        assertEquals(0.0, machine.getBalance(), 0.000001);
        assertNull(machine.getItem("A"));
        assertNull(machine.getItem("B"));
        assertNull(machine.getItem("C"));
        assertNull(machine.getItem("D"));

        machine.addItem(a, "A"); machine.addItem(b, "B");
        machine.addItem(c, "C"); machine.addItem(d, "D");
        assertSame(a, machine.getItem("A")); assertSame(b, machine.getItem("B"));
        assertSame(c, machine.getItem("C")); assertSame(d, machine.getItem("D"));

        VendingMachineException occupied = assertThrows(VendingMachineException.class,
            () -> machine.addItem(new VendingMachineItem("Pear", 1.0), "A"));
        assertEquals("Slot A already occupied", occupied.getMessage());
        assertSame(a, machine.getItem("A"));

        VendingMachineException invalidAdd = assertThrows(VendingMachineException.class,
            () -> machine.addItem(a, "X"));
        assertEquals("Invalid code for vending machine item", invalidAdd.getMessage());
        assertThrows(VendingMachineException.class, () -> machine.getItem("X"));

        assertSame(a, machine.removeItem("A"));
        assertNull(machine.getItem("A"));
        VendingMachineException empty = assertThrows(VendingMachineException.class,
            () -> machine.removeItem("A"));
        assertEquals("Slot A is empty -- cannot remove item", empty.getMessage());
        assertThrows(VendingMachineException.class, () -> machine.removeItem("X"));
    }

    @Test
    void moneyPurchaseAndChangeCoverSuccessAndFailureBranches() throws VendingMachineException {
        machine.insertMoney(1.0);
        machine.insertMoney(2.5);
        assertEquals(3.5, machine.getBalance(), 0.000001);

        machine.addItem(new VendingMachineItem("Apple", 1.5), "A");
        assertTrue(machine.makePurchase("A"));
        assertNull(machine.getItem("A"));
        assertEquals(2.0, machine.getBalance(), 0.000001);

        machine.addItem(new VendingMachineItem("Expensive", 4.0), "B");
        assertFalse(machine.makePurchase("B"));
        assertNotNull(machine.getItem("B"));
        assertEquals(2.0, machine.getBalance(), 0.000001);
        assertFalse(machine.makePurchase("C"));
        assertThrows(VendingMachineException.class, () -> machine.makePurchase("X"));

        VendingMachineException zero = assertThrows(VendingMachineException.class,
            () -> machine.insertMoney(0.0));
        assertEquals("Invalid amount.  Amount must be >= 0", zero.getMessage());
        assertThrows(VendingMachineException.class, () -> machine.insertMoney(0.99));
        assertThrows(VendingMachineException.class, () -> machine.insertMoney(-1.0));
        assertEquals(2.0, machine.getBalance(), 0.000001);

        assertEquals(2.0, machine.returnChange(), 0.000001);
        assertEquals(0.0, machine.getBalance(), 0.000001);
        assertEquals(0.0, machine.returnChange(), 0.000001);
    }

    @Test
    void zeroCostItemCanBePurchasedWithoutInsertingMoney() throws VendingMachineException {
        machine.addItem(new VendingMachineItem("Free sample", 0.0), "D");
        assertTrue(machine.makePurchase("D"));
        assertNull(machine.getItem("D"));
        assertEquals(0.0, machine.getBalance(), 0.000001);
    }
}
