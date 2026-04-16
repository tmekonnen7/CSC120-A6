import static org.junit.Assert.*;
import org.junit.Test;

public class ShopTest {

    /**
     * Bug 1: Computer constructor hardcodes memory to 16 instead of using the parameter.
     * Tests that memory is correctly assigned from the constructor argument.
     */
    @Test
    public void testConstructorMemory() {
        Computer c = new Computer("Test", "Intel", 256, 32, "Windows", 2020, 500);
        assertEquals(32, c.memory);
    }

    /**
     * Bug 2: Computer constructor hardcodes price to 0 instead of using the parameter.
     * Tests that price is correctly assigned from the constructor argument.
     */
    @Test
    public void testConstructorPrice() {
        Computer c = new Computer("Test", "Intel", 256, 16, "Windows", 2020, 800);
        assertEquals(800, c.price);
    }

    /**
     * Bug 3: setOS() always sets operatingSystem to "None" instead of the given value.
     * Tests that setOS correctly updates the operating system.
     */
    @Test
    public void testSetOS() {
        Computer c = new Computer("Test", "Intel", 256, 16, "Windows", 2020, 500);
        c.setOS("macOS");
        assertEquals("macOS", c.operatingSystem);
    }

    /**
     * Bug 4: ResaleShop constructor pre-populates inventory with a computer.
     * A new shop should start with an empty inventory.
     */
    @Test
    public void testNewShopIsEmpty() {
        ResaleShop shop = new ResaleShop();
        assertEquals(0, shop.inventory.size());
    }

    /**
     * Bug 5: buy() ignores the given computer and always adds a hardcoded one.
     * Tests that the actual computer passed in is what gets added to inventory.
     */
    @Test
    public void testBuyAddsCorrectComputer() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("2015 Dell", "AMD", 512, 8, "Windows 10", 2015, 300);
        shop.buy(c);
        assertTrue(shop.inventory.contains(c));
    }

    /**
     * Bug 6: printInventory() uses i <= size() causing an ArrayIndexOutOfBoundsException.
     * Tests that printing inventory does not crash.
     */
    @Test
    public void testPrintInventoryNoCrash() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("2020 HP", "Intel", 256, 16, "Windows 11", 2020, 600);
        shop.buy(c);
        // Should not throw any exception
        shop.printInventory();
    }

    /**
     * Bug 7: refurbish() sets price to 2500 for computers made between 2000–2012 (should be 250).
     * Tests that the correct price tier is applied.
     */
    @Test
    public void testRefurbishPriceOldComputer() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("2005 Dell", "Pentium", 80, 2, "XP", 2005, 0);
        shop.buy(c);
        shop.refurbish(c, "None");
        assertEquals(250, c.price);
    }

    /**
     * Bug 8: refurbish() uses != instead of .equals() to compare strings,
     * so the OS is never updated even when a valid new OS is provided.
     * Tests that setOS is actually called when newOS is not "None".
     */
    @Test
    public void testRefurbishUpdatesOS() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2019, 0);
        shop.buy(c);
        shop.refurbish(c, "Ventura");
        assertEquals("Ventura", c.operatingSystem);
    }

    /**
     * Bug 9: buy() does not throw a RuntimeException when the computer is already in inventory.
     * Tests that buying a duplicate computer throws the expected exception.
     */
    @Test(expected = RuntimeException.class)
    public void testBuyDuplicateThrows() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("2021 Lenovo", "AMD", 512, 16, "Windows 11", 2021, 700);
        shop.buy(c);
        shop.buy(c); // should throw RuntimeException
    }

    /**
     * Bug 10: sell() does not throw a RuntimeException when the computer is not in inventory.
     * Tests that selling a computer not in inventory throws the expected exception.
     */
    @Test(expected = RuntimeException.class)
    public void testSellNotInInventoryThrows() {
        ResaleShop shop = new ResaleShop();
        Computer c = new Computer("2018 Acer", "Intel", 256, 8, "Windows 10", 2018, 400);
        shop.sell(c); // c was never added — should throw RuntimeException
    }

}