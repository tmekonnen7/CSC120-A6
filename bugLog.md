## Bug 1
Brief description:   The Computer constructor hardcodes this.memory = 16 instead of assigning the memory parameter, so every computer always gets 16GB of memory despite what is passed in.
Failed unit test: testConstructorMemory()

## Bug 2
The this.price = 0 instead of assigning the price parameter, so every computer is created with a price of $0 regardless of the argument.
Failed unit test: testConstructorPrice()

## Bug 3
The setOS() method always sets operatingSystem to the literal string "None" instead of using the newOS parameter, so the OS can never actually be updated.
Failed unit test: testSetOS()

## Bug 4
Brief description: The ResaleShop constructor immediately adds a hardcoded computer to the inventory. It should be empty.
Failed unit test: testNewShopIsEmpty()

## Bug 5
Brief description: The buy() method ignores the computer passed as an argumentit just creates and adds a hardcoded 2019 MacBook Pro. Any computer passed to buy is replaced by this one.
Failed unit test: testBuyAddsCorrectComputer()

## Bug 6
Brief description: The printInventory() method uses i <= this.inventory.size() as the loop condition instead of i < this.inventory.size(). This would be out of bounds.
Failed unit test: testPrintInventoryNoCrash()

## Bug 7
Brief description: The refurbish() method sets the price to 2500 for computers made between 2000 and 2012, but the correct price should be 250. This is a typo that results in a drastically incorrect price.
Failed unit test: testRefurbishPriceOldComputer()

## Bug 8
Brief description: The refurbish() method uses != to compare the newOS string to "None" instead of using .equals(). Because != compares object references rather than content, the OS is never updated even when a valid new OS string is provided.
Failed unit test: testRefurbishUpdatesOS()

## Bug 9
Brief description: The buy() method's Javadoc says it should throw a RuntimeException if the computer is already in inventory, but that doesn't show up. Buying a duplicate  just adds it again.
Failed unit test: testBuyDuplicateThrows()

## Bug 10
Brief description: The sell() method's Javadoc says it should throw a RuntimeException if the computer is not in inventory, but it doesn't show up. Selling a computer that was never added just happens instead of raising an error.
Failed unit test: testSellNotInInventoryThrows() 