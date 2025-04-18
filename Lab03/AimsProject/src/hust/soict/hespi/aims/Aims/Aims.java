package hust.soict.hespi.aims.Aims;

public class Aims {
    public Aims() {
    }
    public static void main(String[] args) {
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95F);
        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95F);
        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99F);
        anOrder.addDigitalVideoDisc(dvd3);
        anOrder.printCart();
        anOrder.removeDigitalVideoDisc(dvd2);
        System.out.println("\nCart after removing:");
        anOrder.printCart();
    }
}

