| Source File | Initial Statement/Line Coverage | Initial Branch Coverage |
|-------------|---------------------------------|-------------------------|
| VendingMachine.java | 95.3% (41/43) | 90.9% (20/22) |
| VendingMachineItem.java | 75% (6/8) | 50% (1/2) |

Coverage-Guided Test Improvement:
-added testInvalidItemIntialization() to test VendingMachineItem() when price < 0
-added testGetName() to test getName()
-added "B" to parameters of testInvalidAddItem()
-added "D" to parameters of testInvalidMakePurchase()

| Source File | Initial Statement/Line Coverage | Initial Branch Coverage |
|-------------|---------------------------------|-------------------------|
| VendingMachine.java | 100% | 100% |
| VendingMachineItem.java | 100% | 100% |

Condition-Coverage Check:
| test | condition 1: item != null | condition 2: balance >= item's price |
|------|---------------------------|------------------------|
| testValidMakePurchase() - B | true | true |
| testInvalidMakePurchase() - A | false | true |
| testInvalidMakePurchase() - D | true | false |
| testInvalidMakePurchase() - C | false | true |
| testInvalidMakePurchaseWrongAmount() | false | false |

Test-Sensitivity Experiment: inserted fault into makePurchase() where I changed the 2nd condition from balance >= item's price to balance == item's price. this caused testGetBalance() to fail.