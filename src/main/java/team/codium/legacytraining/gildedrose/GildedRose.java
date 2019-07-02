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
        if (item.name.equals("Aged Brie")) {
            updateAgedBrie(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            updateBackstage(item);
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {

        } else {
            updateNormalItem(item);
        }
    }

    private void updateNormalItem(Item item) {
        decreaseQuality(item);
        if (item.sellIn <= 0) {
            decreaseQuality(item);
        }
        decreaseSellIn(item);
    }

    private void updateBackstage(Item item) {
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

}
