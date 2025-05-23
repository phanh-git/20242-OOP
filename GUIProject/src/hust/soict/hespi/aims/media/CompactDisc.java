package hust.soict.hespi.aims.media;
import hust.soict.hespi.aims.exception.PlayerException;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    // Constructor
    public CompactDisc(int id, String title, String category, float cost, String director, String artist) {
        super(id, title, category, cost, 0, director);
        // Length tính từ tracks
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }


    // Getter for artist
    public String getArtist() {
        return artist;
    }

    // Method to add a track
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track already exists: " + track.getTitle());
        }
    }

    // Method to remove a track
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Track not found: " + track.getTitle());
        }
    }

    // Method to get the total length of all tracks
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            java.util.Iterator iter = tracks.iterator();
            Track nextTrack;
            while (iter.hasNext()) {
                nextTrack = (Track) iter.next();
                try {
                    nextTrack.play();
                } catch (PlayerException e) {
                    throw e;  // Dừng lại ngay nếu có lỗi
                }
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }

}
