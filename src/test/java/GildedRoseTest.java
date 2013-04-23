import static org.junit.Assert.*;

import org.junit.Test;


public class GildedRoseTest {

    Item item1;
    Item item2;
    Item item3;
    Item item4;
    Item item5;
    Item item6;


    @Test
    public void testItem1IsNotExpired(){

        item1 = new Item("+5 Dexterity Vest", 10, 20);
        GildedRose.updateItems(item1);

        assertEquals(19, item1.getQuality());
    }

    @Test
    public void testItem2IsNotExpired(){

        item2 = new Item("Aged Brie", 2, 0);
        GildedRose.updateItems(item2);

        assertEquals(1, item2.getQuality());
    }

    @Test
    public void testItem3IsNotExpired(){

        item3 = new Item("Elixir of the Mongoose", 5, 7);
        GildedRose.updateItems(item3);

        assertEquals(6, item3.getQuality());
    }

    @Test
    public void testItem4IsNotExpired(){

        //* "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
        item4 = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        GildedRose.updateItems(item4);

        assertEquals(80, item4.getQuality());
    }

    @Test
    public void testItem5IsNotExpired(){

        item5 = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        GildedRose.updateItems(item5);

        assertEquals(21, item5.getQuality());
    }

    @Test
    public void testItem6IsNotExpired(){

        item6 = new Item("Conjured Mana Cake", 3, 6);
        GildedRose.updateItems(item6);

        assertEquals(4, item6.getQuality());
    }


    //  * Once the sell by date has passed, Quality degrades twice as fast


    @Test
    public void test1QualityDecrease2TimesFaster(){

        item1 = new Item("+5 Dexterity Vest", 0, 20);
        GildedRose.updateItems(item1);

        assertEquals(18, item1.getQuality());
    }

    @Test
    public void test2QualityDecrease2TimesFaster(){

        // quality increase two times faster (special product)
        item2 = new Item("Aged Brie", 0, 2);
        GildedRose.updateItems(item2);

        assertEquals(4, item2.getQuality());
    }

    @Test
    public void test3QualityDecrease2TimesFaster(){

        item3 = new Item("Elixir of the Mongoose", 0, 7);
        GildedRose.updateItems(item3);

        assertEquals(5, item3.getQuality());
    }

    // the Item 4 is already tested in the previous test


    @Test
    public void test5QualityDecrease2TimesFaster(){

       // * "Backstage passes", like aged brie, increases in Quality as it's SellIn value approaches;
        item5 = new Item("Backstage passes to a TAFKAL80ETC concert", 20, 20);
        GildedRose.updateItems(item5);

        assertEquals(21, item5.getQuality());

    }

    @Test
    public void test6QualityDecrease2TimesFaster(){

        item6 = new Item("Conjured Mana Cake", 0, 6);
        GildedRose.updateItems(item6);

        assertEquals(3, item6.getQuality());

    }


    // The Quality of an item is never negative
    //

    @Test
    public void testItem2Older(){

       // * "Aged Brie" actually increases in Quality the older it gets
        item2 = new Item("Aged Brie", 100, 2);
        GildedRose.updateItems(item2);

        assertEquals(3, item2.getQuality());
    }


}
