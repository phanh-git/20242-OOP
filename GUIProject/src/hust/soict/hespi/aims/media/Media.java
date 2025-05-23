package hust.soict.hespi.aims.media;
import hust.soict.hespi.aims.exception.NegativePriceException;

import java.util.Collection;
import java.util.Comparator;

public abstract class Media implements Comparable<Media> {
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCost(float cost) throws NegativePriceException {
        if (cost < 0) {
            throw new NegativePriceException("ERROR: Media price cannot be negative");
        }
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // so sánh địa chỉ
        if (obj == null || !(obj instanceof Media)) return false;

        Media other = (Media) obj;
        return this.title.equals(other.title) && this.cost == other.cost;
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    @Override
    public int compareTo(Media other) {
        if (other == null) throw new NullPointerException("Compared media is null");

        int titleCompare = this.title.compareTo(other.title);
        if (titleCompare != 0) {
            return titleCompare;
        } else {
            return Float.compare(this.cost, other.cost);
        }
    }
}
