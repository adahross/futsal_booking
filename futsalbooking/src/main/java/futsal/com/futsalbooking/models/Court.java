package futsal.com.futsalbooking.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Court {
    @Id
    private int courtID;
    private String courtName;
    private String courtType;
    private String courtStat;
    private double price;
    private String image;

     public Court() {
    }

    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Court( int courtID,String courtName, String courtType, String courtStat, double price, String image) {
        this.courtName = courtName;
        this.courtType = courtType;
        this.courtStat = courtStat;
        this.courtID = courtID;
        this.price = price;
        this.setImage(image);
    }

    /**
     * @return the courtID
     */
    public int getCourtID() {
        return courtID;
    }

    /**
     * @param courtID the courtID to set
     */
    public void setCourtID(int courtID) {
        this.courtID = courtID;
    }

    /**
     * @return the courtType
     */
    public String getCourtType() {
        return courtType;
    }

    /**
     * @param Type the courtType to set
     */
    public void setCourtType(String Type) {
        this.courtType = Type;
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
     * @return the courtStat
     */
    public String getCourtStat() {
        return courtStat;
    }

    /**
     * @param courtStat the courtStat to set
     */
    public void setCourtStat(String courtStat) {
        this.courtStat = courtStat;
    }

    /**
     * @return the courtName
     */
    public String getCourtName() {
        return courtName;
    }

    /**
     * @param courtName the courtName to set
     */
    public void setCourtName(String courtName) {
        this.courtName= courtName;
    }
}