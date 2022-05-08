package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        updateItem();
    }

    private void updateItem() {
        for (Item item : items) {
            final boolean aged_brie = item.name.equals("Aged Brie");
            final boolean backstage = item.name.equals("Backstage passes to a TAFKAL80ETC concert");
            final boolean sulfuras = item.name.equals("Sulfuras, Hand of Ragnaros");
            final boolean conjured = item.name.contains("Conjured");
            if (aged_brie) {
                handleAgedBire(item);
            } else if (backstage) {
                handleBackstage(item);
            } else if (sulfuras) {
                handleSulfurs(item);
            } else if (conjured) {
                handleConjured(item);
            } else {
                handleCausal(item);
            }
        }
    }

    private void handleConjured(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 2;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 2;
            }
        }
    }

    private void handleCausal(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }

    private void handleSulfurs(Item item) {
    }

    private void handleBackstage(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void handleAgedBire(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }
}