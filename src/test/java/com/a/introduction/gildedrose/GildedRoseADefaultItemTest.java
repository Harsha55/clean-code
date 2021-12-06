package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseADefaultItemTest {

	static final int NOT_EXPIRED_ITEM_SELLIN = 15;
	static final int ITEM_QUALITY = 3;
	static final String DEFAULT_ITEM = "DEFAULT_ITEM";
	static final int EXPIRED_ITEM_SELLIN = -1;

	@Test
	public void defaultNotExpiredItemQualityDecreasesBy1() {
		GildedRose app = createGildedRose(DEFAULT_ITEM, NOT_EXPIRED_ITEM_SELLIN, ITEM_QUALITY);

		app.updateQuality();

		Item expected = new Item(DEFAULT_ITEM, NOT_EXPIRED_ITEM_SELLIN -1, ITEM_QUALITY-1);
		verifyValues(app.items[0],expected);
	}

	@Test
	public void expiredItemQualityDecreasesBy2() {
		GildedRose app = createGildedRose(DEFAULT_ITEM, EXPIRED_ITEM_SELLIN, ITEM_QUALITY);

		app.updateQuality();

		Item expected = new Item(DEFAULT_ITEM, EXPIRED_ITEM_SELLIN -1, ITEM_QUALITY-2);
		verifyValues(app.items[0],expected);
	}

	private GildedRose createGildedRose(String defaultItem, int itemSellin, int itemQuality) {
		Item item = new Item(defaultItem, itemSellin, itemQuality);
		Item[] items = new Item[]{item};
		return new GildedRose(items);
	}

	private void verifyValues(Item actualItemValues,Item expectedValue) {
		assertEquals(expectedValue.name, actualItemValues.name);
		assertEquals(expectedValue.sellIn, actualItemValues.sellIn);
		assertEquals(expectedValue.quality, actualItemValues.quality);
	}


}