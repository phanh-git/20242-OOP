package hust.soict.hespi.aims.media;

public class Disc extends Media {
    protected int length;
    protected String director;

    // Constructor
    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }

    // Getter methods
    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

}
