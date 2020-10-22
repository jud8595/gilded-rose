package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void should_not_inventory_item_name_change_when_updating_quality() {
        // given
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);

        // when
        app.update();

        // then
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void should_quality_decrease_by_1() {
        // given
        Item[] items = new Item[] { new Item("foo", 3, 1) };
        GildedRose app = new GildedRose(items);

        // when
        app.update();

        // then
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void should_quality_decrease_by_2_when_selling_date_is_today() {
        // given
        Item[] items = new Item[] { new Item("foo", 0, 4) };
        GildedRose app = new GildedRose(items);

        // when
        app.update();

        // then
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void should_quality_decrease_by_2_when_selling_date_is_negative() {
        // given
        Item[] items = new Item[] { new Item("foo", -1, 4) };
        GildedRose app = new GildedRose(items);

        // when
        app.update();

        // then
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void should_quality_decrease_by_1_when_selling_date_is_negative_but_quality_is_1() {
        // given
        Item[] items = new Item[] { new Item("foo", -1, 1) };
        GildedRose app = new GildedRose(items);

        // when
        app.update();

        // then
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void should_not_quality_decrease_when_quality_is_0() {
        // given
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);

        // when
        app.update();

        // then
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void should_aged_brie_increase_by_1() {
        // given
        Item[] items = new Item[] { new Item("Aged Brie", 2, 5) };
        GildedRose app = new GildedRose(items);

        // when
        app.update();

        // then
        assertEquals(6, app.items[0].quality);
    }

    @Test
    void should_aged_brie_increase_by_2_when_selling_date_is_today() {
        // given
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items);

        // when
        app.update();

        // then
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void should_aged_brie_increase_by_2_when_selling_date_negative() {
        // given
        Item[] items = new Item[] { new Item("Aged Brie", -2, 5) };
        GildedRose app = new GildedRose(items);

        // when
        app.update();

        // then
        assertEquals(7, app.items[0].quality);
    }

    @Test
    void should_aged_brie_increase_by_1_when_selling_date_negative_but_quality_49() {
        // given
        Item[] items = new Item[] { new Item("Aged Brie", -2, 49) };
        GildedRose app = new GildedRose(items);

        // when
        app.update();

        // then
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void should_not_quality_increase_when_quality_was_50() {
        // given
        Item[] items = new Item[] { new Item("Aged Brie", 2, 50) };
        GildedRose app = new GildedRose(items);

        // when
        app.update();

        // then
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void should_Sulfuras_quality_be_80_and_never_change() {
        // given
        Item[] items = new Item[] { new Item("Sulfuras", 0, 80) };
        GildedRose app = new GildedRose(items);

        // when
        app.update();

        // then
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void should_Sulfuras_quality_be_80_and_never_change_when_selling_date_has_passed() {
        // given
        Item[] items = new Item[] { new Item("Sulfuras", -5, 80) };
        GildedRose app = new GildedRose(items);

        // when
        app.update();

        // then
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void should_Backstage_passes_increase_by_2_when_sellin_date_is_10_days_or_less() {
        // given
        Item[] items = new Item[] { new Item("Backstage passes", 10, 40) };
        GildedRose app = new GildedRose(items);

        // when
        app.update();

        // then
        assertEquals(42, app.items[0].quality);
    }

    @Test
    void should_Backstage_passes_increase_by_1_when_sellin_date_is_10_days_or_less_but_quality_is_49() {
        // given
        Item[] items = new Item[] { new Item("Backstage passes", 10, 49) };
        GildedRose app = new GildedRose(items);

        // when
        app.update();

        // then
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void should_Backstage_passes_increase_by_3_when_sellin_date_is_5_days_or_less() {
        // given
        Item[] items = new Item[] { new Item("Backstage passes", 5, 40) };
        GildedRose app = new GildedRose(items);

        // when
        app.update();

        // then
        assertEquals(43, app.items[0].quality);
    }

    @Test
    void should_Backstage_passes_increase_by_1_when_sellin_date_is_5_days_or_less_but_quality_is_49() {
        // given
        Item[] items = new Item[] { new Item("Backstage passes", 5, 49) };
        GildedRose app = new GildedRose(items);

        // when
        app.update();

        // then
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void should_Backstage_passes_quality_drop_to_0_when_concert_is_today() {
        // given
        Item[] items = new Item[] { new Item("Backstage passes", 0, 40) };
        GildedRose app = new GildedRose(items);

        // when
        app.update();

        // then
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void should_Backstage_passes_quality_drop_to_0_when_concert_is_sellin_date_negative() {
        // given
        Item[] items = new Item[] { new Item("Backstage passes", -1, 11) };
        GildedRose app = new GildedRose(items);

        // when
        app.update();

        // then
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void should_Conjured_quality_decrease_by_2() {
        // given
        Item[] items = new Item[] { new Item("Conjured", 3, 8) };
        GildedRose app = new GildedRose(items);

        // when
        app.update();

        // then
        assertEquals(6, app.items[0].quality);
    }

    @Test
    void should_Conjured_quality_decrease_by_4_when_selling_date_negative() {
        // given
        Item[] items = new Item[] { new Item("Conjured", -3, 20) };
        GildedRose app = new GildedRose(items);

        // when
        app.update();

        // then
        assertEquals(16, app.items[0].quality);
    }

    @Test
    void should_Conjured_quality_decrease_by_3_when_selling_date_is_today_but_quality_is_1() {
        // given
        Item[] items = new Item[] { new Item("Conjured", 0, 3) };
        GildedRose app = new GildedRose(items);

        // when
        app.update();

        // then
        assertEquals(0, app.items[0].quality);
    }
}
