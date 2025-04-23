package hust.soict.hespi.test.disc.TestPassingParameter;
import hust.soict.hespi.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public TestPassingParameter() {
    }

    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc(1, "Jungle", "Adventure", "Jon Favreau", 95, 15.5f);
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc(2, "Cinderella", "Fairy Tale", "Kenneth Branagh", 105, 17.5f);
        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Object o1, Object o2) {
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
    }
}

