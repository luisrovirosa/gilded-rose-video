package team.codium.legacytraining.gildedrose;

public class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
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
        switch (item.name) {
            case AGED_BRIE:
                updateAgedBrie(item);
                break;
            case BACKSTAGE_PASSES:
                updateBackstage(item);
                break;
            case SULFURAS:

                break;
            default:
                updateNormalItem(item);
                break;
        }
    }

    private void updateAgedBrie(Item item) {
        increaseQuality(item);
        if (item.sellIn <= 0) {
            increaseQuality(item);
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

    private void updateNormalItem(Item item) {
        decreaseQuality(item);
        if (item.sellIn <= 0) {
            decreaseQuality(item);
        }
        decreaseSellIn(item);
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void dropQualityToZero(Item item) {
        item.quality = 0;
    }

}
