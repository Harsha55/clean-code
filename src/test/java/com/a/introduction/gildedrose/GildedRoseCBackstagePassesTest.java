package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseCBackstagePassesTest {

	public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	public static final int SELLIN_GREATER_THAN_10 = 15;
	public static final int ITEM_QUALITY = 3;
	public static final int SELLIN_LESS_THAN_10 = 7;
	public static final int SELLIN_LESS_THAN_5 = 4;

	@Test
	public void backstagePassesBeyond10Days_qualityIncreasesBy1() {
		GildedRose app = getGildedRose(BACKSTAGE_PASSES, SELLIN_GREATER_THAN_10, ITEM_QUALITY);
		app.updateQuality();
		Item expected = new Item(BACKSTAGE_PASSES, SELLIN_GREATER_THAN_10 - 1, ITEM_QUALITY + 1);
		verifyValues(app.items[0],expected);
	}

	@Test
	public void backstagePassesLessThan10Days_qualityIncreasesBy2() {
		GildedRose app = getGildedRose(BACKSTAGE_PASSES, SELLIN_LESS_THAN_10, ITEM_QUALITY);

		app.updateQuality();

		Item expected = new Item(BACKSTAGE_PASSES, SELLIN_LESS_THAN_10 - 1, ITEM_QUALITY + 2);
		verifyValues(app.items[0],expected);
	}

	@Test
	public void backstagePassesBLessThan5Days_qualityIncreasesBy3() {
		GildedRose app = getGildedRose(BACKSTAGE_PASSES, SELLIN_LESS_THAN_5, ITEM_QUALITY);

		app.updateQuality();

		Item expected = new Item(BACKSTAGE_PASSES, SELLIN_LESS_THAN_5 - 1, ITEM_QUALITY + 3);

		verifyValues(app.items[0],expected);
	}

	private void verifyValues(Item actual, Item expected) {
		assertEquals(expected.name, actual.name);
		assertEquals(expected.sellIn, actual.sellIn);
		assertEquals(expected.quality, actual.quality);
	}

	private GildedRose getGildedRose(String backstagePassesToATafkal80EtcConcert, int sellinGreaterThan10, int quality) {
		Item item = new Item(backstagePassesToATafkal80EtcConcert, sellinGreaterThan10, quality);
		Item[] items = new Item[]{item};
		return new GildedRose(items);
	}

}