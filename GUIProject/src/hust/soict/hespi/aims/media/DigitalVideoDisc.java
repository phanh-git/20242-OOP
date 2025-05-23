package hust.soict.hespi.aims.media;

import hust.soict.hespi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    private String director;
    private int length;

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost, length, director); // đẩy phần này vào Disc
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return getTitle() + " - " + getCategory() + " - " + director + " - " + length + " - " + getCost() + "$";
    }
    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            // Ném lỗi nếu độ dài không hợp lệ
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }

}
