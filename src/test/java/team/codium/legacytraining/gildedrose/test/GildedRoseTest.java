package team.codium.legacytraining.gildedrose.test;

import org.junit.Test;
import team.codium.legacytraining.gildedrose.GildedRose;
import team.codium.legacytraining.gildedrose.Item;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    private final Path PATH = Paths.get("golden_master.txt");

    @Test
    public void the_behaviour_should_not_change() throws IOException {
        Item[] items = new Item[] {
                new Item("Book", 20, 10),
                new Item("Book", 20, 40),
                new Item("Aged Brie", 20, 10),
                new Item("Aged Brie", 20, 40),
                new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 45),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 45),
                new Item("Sulfuras, Hand of Ragnaros", 20, 10),
        };
        GildedRose app = new GildedRose(items);
        List<String> result = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            app.updateQuality();
            result.add(Arrays.toString(items));
        }

//        updateGoldenMaster(result);
        assertEqualsToGoldenMaster(result);
    }

    private void assertEqualsToGoldenMaster(List<String> result) throws IOException {
        assertEquals(readGoldenMaster(), result.toString());
    }

    private String readGoldenMaster() throws IOException {
        String goldenMaster = Files.readAllLines(PATH).toString();
        return goldenMaster.substring(1, goldenMaster.length()-1);
    }

    private void updateGoldenMaster(List<String> result) throws IOException {
        Files.write(PATH, result.toString().getBytes());
    }


}
