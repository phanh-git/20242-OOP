package hust.soict.hespi.aims.media;
import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int titleCompare = m1.getTitle().compareTo(m2.getTitle()); // Ascending by title
        if (titleCompare != 0) return titleCompare;
        return Float.compare(m2.getCost(), m1.getCost()); // Descending by cost
    }
}
