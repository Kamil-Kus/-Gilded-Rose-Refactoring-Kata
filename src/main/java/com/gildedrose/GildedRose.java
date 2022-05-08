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
            if (aged_brie) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
                item.sellIn = item.sellIn - 1;

                if (item.sellIn < 0) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            } else {
                if (backstage) {
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
                } else if (sulfuras) {

                } else {
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
            }
        }
    }
}