import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    public static List<Item> items = null;

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));


        updateQuality();
    }


    public static List<Item> getItems() {
        return items;
    }

    public static void setItems(List<Item> items) {
        GildedRose.items = items;
    }

    public static void updateQuality()
    {
        for (int i = 0; i < items.size(); i++)
        {
            Item currentItem = items.get(i);
            updateItems(currentItem);
        }
    }

    public static void updateItems(Item currentItem) {
        if ((!"Aged Brie".equals(currentItem.getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(currentItem.getName()))
        {
            if (currentItem.getQuality() > 0)
            {
                // conjured mana cake
                if ("Conjured Mana Cake".equals(currentItem.getName()))
                {
                    currentItem.setQuality(currentItem.getQuality() - 1);
                }

                if (!"Sulfuras, Hand of Ragnaros".equals(currentItem.getName()))
                {
                    currentItem.setQuality(currentItem.getQuality() - 1);
                }
            }
        }
        else
        {
            if (currentItem.getQuality() < 50)
            {
                currentItem.setQuality(currentItem.getQuality() + 1);

                if ("Backstage passes to a TAFKAL80ETC concert".equals(currentItem.getName()))
                {
                    if (currentItem.getSellIn() < 11)
                    {
                        if (currentItem.getQuality() < 50)
                        {
                            currentItem.setQuality(currentItem.getQuality() + 1);
                        }
                    }

                    if (currentItem.getSellIn() < 6)
                    {
                        if (currentItem.getQuality() < 50)
                        {
                            currentItem.setQuality(currentItem.getQuality() + 1);
                        }
                    }
                }
            }
        }

        if (!"Sulfuras, Hand of Ragnaros".equals(currentItem.getName()))
        {
            currentItem.setSellIn(currentItem.getSellIn() - 1);
        }

        if (currentItem.getSellIn() < 0)
        {
            if (!"Aged Brie".equals(currentItem.getName()))
            {
                if (!"Backstage passes to a TAFKAL80ETC concert".equals(currentItem.getName()))
                {
                    if (currentItem.getQuality() > 0)
                    {
                        if (!"Sulfuras, Hand of Ragnaros".equals(currentItem.getName()))
                        {
                            currentItem.setQuality(currentItem.getQuality() - 1);
                        }
                    }
                }
                else
                {
                    currentItem.setQuality(currentItem.getQuality() - currentItem.getQuality());
                }
            }
            else
            {
                if (currentItem.getQuality() < 50)
                {
                    currentItem.setQuality(currentItem.getQuality() + 1);
                }
            }
        }
    }

}