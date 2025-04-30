package hust.soict.hespi.aims.screen.manager;

import hust.soict.hespi.aims.media.CompactDisc;
import hust.soict.hespi.aims.media.DigitalVideoDisc;
import hust.soict.hespi.aims.store.Store;
import hust.soict.hespi.aims.media.Media;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class StoreManagerScreen extends JFrame {
    private Store store;

    public JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    public JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        // View store
        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener((ActionEvent e) -> {
            new StoreManagerScreen(store);
            dispose(); // đóng cửa sổ hiện tại (không bắt buộc)
        });
        menu.add(viewStore);

        // Update store submenu
        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener((ActionEvent e) -> {
            new aims.screen.manager.AddBookToStoreScreen(store);
        });

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener((ActionEvent e) -> {
            new AddCompactDiscToStoreScreen(store);
        });

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener((ActionEvent e) -> {
            new AddDigitalVideoDiscToStoreScreen(store);
        });

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    public JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    public JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        List<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < Math.min(9, mediaInStore.size()); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }
        return center;
    }

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Store store = new Store();

        store.addMedia(new DigitalVideoDisc(1, "Harry Potter and the Philosopher's Stone", "Fantasy", "Chris Columbus", 152, 3.0f));
        store.addMedia(new DigitalVideoDisc(2, "Harry Potter and the Chamber of Secrets", "Fantasy", "Chris Columbus", 161, 3.5f));
        store.addMedia(new DigitalVideoDisc(3, "Harry Potter and the Prisoner of Azkaban", "Fantasy", "Alfonso Cuarón", 142, 5.0f));
        store.addMedia(new DigitalVideoDisc(4, "Harry Potter and the Goblet of Fire", "Fantasy", "Mike Newell", 157, 4.5f));
        store.addMedia(new CompactDisc(5, "Fetch the Bolt Cutters", "Music", 10.39f, "Fiona Apple", "Fiona Apple"));
        store.addMedia(new CompactDisc(6, "Future Nostalgia", "Music", 9.6f, "Dua Lipa", "Dua Lipa"));
        store.addMedia(new DigitalVideoDisc(7, "The Hunger Games", "Action", "Gary Ross", 142, 5.5f));
        store.addMedia(new DigitalVideoDisc(8, "Catching Fire", "Action", "Francis Lawrence", 146, 4.9f));
        store.addMedia(new DigitalVideoDisc(9, "Mockingjay", "Action", "Francis Lawrence", 137, 5.1f));

        new StoreManagerScreen(store);
    }
}
