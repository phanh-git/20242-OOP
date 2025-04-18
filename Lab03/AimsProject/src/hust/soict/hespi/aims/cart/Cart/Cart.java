package hust.soict.hespi.aims.cart.Cart;

import hust.soict.hespi.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[20];
    private int qtyOrdered = 0;
    private ArrayList<DigitalVideoDisc> items = new ArrayList();

    public Cart() {
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for(DigitalVideoDisc dvd : dvdList) {
            this.addDigitalVideoDisc(dvd);
        }

    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        this.addDigitalVideoDisc(dvd1);
        this.addDigitalVideoDisc(dvd2);
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (this.qtyOrdered < 20) {
            this.itemsOrdered[this.qtyOrdered] = disc;
            ++this.qtyOrdered;
            System.out.println("The disc has been added.");
        } else {
            System.out.println("The cart is almost full.");
        }

    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;

        for(int i = 0; i < this.qtyOrdered; ++i) {
            if (this.itemsOrdered[i] == disc) {
                found = true;

                for(int j = i; j < this.qtyOrdered - 1; ++j) {
                    this.itemsOrdered[j] = this.itemsOrdered[j + 1];
                }

                this.itemsOrdered[this.qtyOrdered - 1] = null;
                --this.qtyOrdered;
                System.out.println("The disc has been removed.");
                break;
            }
        }

        if (!found) {
            System.out.println("Disc not found in the cart.");
        }

    }

    public float totalCost() {
        float total = 0.0F;

        for(int i = 0; i < this.qtyOrdered; ++i) {
            total += this.itemsOrdered[i].getCost();
        }

        return total;
    }

    public void printCart() {
        System.out.println("Cart Items:");

        for(int i = 0; i < this.qtyOrdered; ++i) {
            DigitalVideoDisc disc = this.itemsOrdered[i];
            System.out.printf("%d\t%s\t%.2f\n", i + 1, disc.getTitle(), disc.getCost());
        }

        System.out.printf("\nTotal Cost\t%.2f\n", this.totalCost());
    }
}