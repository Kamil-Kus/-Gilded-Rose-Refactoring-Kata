package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.approvaltests.combinations.CombinationApprovals;

class GildedRoseTest {

    @Test
    void testUpdateOfQuality() {
        CombinationApprovals.verifyAllCombinations(this::computeItem, new String[]{"foo", "Aged Brie", "Elixir of the Mongoose", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros", "+5 Dexterity Vest"},
                new Integer[]{0, 2, 3, 4, 20, 99, 200},
                new Integer[]{0, 50, 1, 2, 3, 34, 12});
    }

    private String computeItem(String name, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app.items[0].toString();
    }

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

}
