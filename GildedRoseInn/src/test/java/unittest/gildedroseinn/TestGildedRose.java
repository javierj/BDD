package gildedroseinn;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGildedRose {

	@Test
	public void shouldUseTheEXACTName() {
		Item rigthAgedBrie = new Item("Aged Brie", 10, 20);
		updateQuality(rigthAgedBrie);
	    assertEquals(21, rigthAgedBrie.getQuality());
	    
	    Item wrongAgedBrie = new Item("Aged brie", 10, 20);
	    updateQuality(wrongAgedBrie);
	    assertEquals(19, wrongAgedBrie.getQuality());
	}

	private void updateQuality(Item item) {
		GildedRose inn;
		inn = new GildedRose(new Item[]{item} );
	    inn.updateQuality();
	}

}
