package hust.soict.hespi.aims.media;

public class Track implements Playable{
    private String title;
    private int length;

    // Constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Getter for length
    public int getLength() {
        return length;
    }

    // Optional: Override equals() to support checking duplicates
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Track track = (Track) o;
        return this.length == track.length &&
                this.title != null && this.title.equals(track.getTitle());
    }

    @Override
    public int hashCode() {
        return title.hashCode() + length;
    }
    @Override
    public void play() {
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }
}
