package gildedroseinn;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestItem {

	@Test
	public void shouldCreateItems() {
		Item item = new Item("Sulfuras", 10, 5);
		
		assertEquals("Sulfuras", item.getName());
		assertEquals(10, item.getSellIn());
		assertEquals(5, item.getQuality());
	}

}
