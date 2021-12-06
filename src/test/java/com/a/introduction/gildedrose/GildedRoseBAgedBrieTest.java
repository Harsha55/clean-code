package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseBAgedBrieTest {

	public static final String AGED_BRIE = "Aged Brie";

	public static final int DEFAULT_QUALITY = 3;

	@Test
	public void qualityIncreasesBy1WhenQualityLessThan50() {
		int sellIn = 4;
		GildedRose app = createOneGildedRose(AGED_BRIE,sellIn, DEFAULT_QUALITY);

		app.updateQuality();

		Item expected = new Item(AGED_BRIE,sellIn-1, DEFAULT_QUALITY+1);
		assertItemValues(expected, app.items[0]);
	}

	@Test
	public void qualityIncreasesBy2WhenSellInIsLessThan0() {
		int sellIn = -1;
		GildedRose app = createOneGildedRose("Aged Brie", sellIn,  DEFAULT_QUALITY);

		app.updateQuality();


		Item expected = new Item(AGED_BRIE,sellIn-1, DEFAULT_QUALITY+2);
		assertItemValues(expected, app.items[0]);
	}

	@Test
	public void qualityStaysSameIfQualityIsGreaterThan49() {
		int sellIn = 4;
		int defaultQuality = 50;
		GildedRose app = createOneGildedRose(AGED_BRIE, sellIn, defaultQuality);

		app.updateQuality();

		Item expected = new Item(AGED_BRIE,sellIn-1, defaultQuality);
		assertItemValues(expected, app.items[0]);
	}

	private GildedRose createOneGildedRose(String agedBrie, int sellIn, int defaultQuality) {
		Item item = new Item(agedBrie, sellIn, defaultQuality);
		Item[] items = new Item[]{item};
		return new GildedRose(items);
	}

	private void assertItemValues(Item expectedValues, Item actualValues) {
		assertEquals(expectedValues.name, actualValues.name);
		assertEquals(expectedValues.sellIn, actualValues.sellIn);
		assertEquals(expectedValues.quality, actualValues.quality);
	}
}
