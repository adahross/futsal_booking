package futsal.com.futsalbooking.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {
    
    private String ItemName;
    private String ItemType;
    private String ItemStat;
    @Id
    private String ItemID;
    private double price;

    //overloading constructor
    public Item() {
    }

    public Item( String ItemID,String ItemName, String ItemType, String ItemStat, double price) {
        this.ItemName = ItemName;
        this.ItemType = ItemType;
        this.ItemStat = ItemStat;
        this.ItemID = ItemID;
        this.price = price;
    }

    /**
     * @return the ItemID
     */
    public String getItemID() {
        return ItemID;
    }

    /**
     * @param ItemID the ItemID to set
     */
    public void setItemID(String ItemID) {
        this.ItemID = ItemID;
    }

    /**
     * @return the ItemType
     */
    public String getItemType() {
        return ItemType;
    }

    /**
     * @param ItemType the ItemType to set
     */
    public void setItemType(String ItemType) {
        this.ItemType = ItemType;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the ItemStat
     */
    public String getItemStat() {
        return ItemStat;
    }

    /**
     * @param ItemStat the ItemStat to set
     */
    public void setItemStat(String ItemStat) {
        this.ItemStat = ItemStat;
    }

    /**
     * @return the ItemName
     */
    public String getItemName() {
        return ItemName;
    }

    /**
     * @param ItemName the ItemName to set
     */
    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

}