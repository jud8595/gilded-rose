package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        for (Item item : items) {
            if (item.name.equals("Sulfuras")) {
                if (item.quality != 80) {
                    throw new IllegalArgumentException("Quality of Sulfuras item has to be 80");
                }
            }
        }
        this.items = items;
    }

    public void update() {
        for (Item item : items) {
            if (!item.name.equals("Sulfuras")) {
                item.quality = updateQuality(item.quality, item.sellIn, item.name);
                item.sellIn = item.sellIn - 1;
            }
        }
    }

    private int updateQuality(int quality, int sellIn, String name) {
        int incr = 0;
        
        if (sellIn > 0) {
            if (name.equals("Aged Brie")) {
                incr = 1;
            } else if (name.equals("Backstage passes")) {
                if (sellIn <= 5) {
                    incr = 3;
                } else if (sellIn <= 10) {
                    incr = 2;
                } else {
                    incr = 1;
                }
            } else {
                incr = -1;
            }
        }

        else {
            if (name.equals("Aged Brie")) {
                incr = 2;
            } else if (name.equals("Backstage passes")) {
                incr = -quality;
            } else {
                incr = -2;
            }
        }

        if (name.equals("Conjured")) {
            incr = incr*2;
        }

        return min0(max50(quality + incr));
    }

    private int updateQualityByItem(int quality, int sellIn, String name) {
        int incr = 0;

        if (name.equals("Aged Brie")) {
            if (sellIn > 0) {
                incr = 1;
            } else {
                incr = 2;
            }
        } else if (name.equals("Backstage passes")) {
            if (sellIn <= 5) {
                incr = 3;
            } else if (sellIn <= 10) {
                incr = 2;
            } else if (sellIn > 10) {
                incr = 1;
            } else {
                incr = -quality;
            }
        } else {
            if (sellIn > 0) {
                incr = -1;
            } else {
                incr = -2;
            }
        }

        if (name.equals("Conjured")) {
            incr = incr*2;
        }

        return min0(max50(quality + incr));
    }

    private int min0(int quality) {
        return Math.max(0, quality);
    }

    private int max50(int quality) {
        return Math.min(quality, 50);
    }

}