package team.codium.legacytraining.gildedrose;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            update(item);
        }
    }

    private void update(Item item) {
        if (isAgedBrie(item)) {
            updateAgedBrie(item);
        } else if (isBackstage(item)) {
            increaseQuality(item);

            if (item.sellIn <= 10) {
                increaseQuality(item);
            }

            if (item.sellIn <= 5) {
                increaseQuality(item);
            }
            if (item.sellIn <= 0) {
                dropQualityToZero(item);
            }
            decreaseSellIn(item);
        } else if (isSulfuras(item)) {

        } else {
            decreaseQuality(item);
            if (item.sellIn <= 0) {
                decreaseQuality(item);
            }
            decreaseSellIn(item);
        }
    }

    private void updateAgedBrie(Item item) {
        increaseQuality(item);
        if (item.sellIn <= 0) {
            increaseQuality(item);
        }
        decreaseSellIn(item);
    }

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void dropQualityToZero(Item item) {
        item.quality = 0;
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstage(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }
}
