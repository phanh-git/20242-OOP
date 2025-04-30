package hust.soict.hespi.aims.screen.manager;

import hust.soict.hespi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected JTextField titleField;
    protected JTextField costField;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        setTitle("Add Item to Store");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Tạo menu bar giống StoreManagerScreen
        JMenuBar menuBar = new JMenuBar();
        JMenu optionsMenu = new JMenu("Options");

        // View store
        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> {
            new StoreManagerScreen(store).setVisible(true);
            dispose();
        });

        // Update store submenu
        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> {
            new aims.screen.manager.AddBookToStoreScreen(store).setVisible(true);
            dispose();
        });

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> {
            new AddCompactDiscToStoreScreen(store).setVisible(true);
            dispose();
        });

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen(store).setVisible(true);
            dispose();
        });

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);

        optionsMenu.add(viewStore);
        optionsMenu.add(smUpdateStore);
        menuBar.add(optionsMenu);
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        setJMenuBar(menuBar);

        // Panel chính chứa các trường nhập liệu
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel titleLabel = new JLabel("Title:");
        titleField = new JTextField(20);
        JLabel costLabel = new JLabel("Cost:");
        costField = new JTextField(20);

        JButton addButton = new JButton("Add to Store");
        addButton.addActionListener(e -> addItemToStore());

        contentPanel.add(titleLabel);
        contentPanel.add(titleField);
        contentPanel.add(costLabel);
        contentPanel.add(costField);
        contentPanel.add(new JLabel());
        contentPanel.add(addButton);

        add(contentPanel, BorderLayout.CENTER);
    }

    protected abstract void addItemToStore();
}