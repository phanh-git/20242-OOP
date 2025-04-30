package hust.soict.hespi.aims.screen.manager;

import hust.soict.hespi.aims.media.CompactDisc;
import hust.soict.hespi.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField idField;
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField costField;
    private JTextField directorField;
    private JTextField artistField;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store); // gọi constructor lớp cha

        setTitle("Add CD");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // === Menu Bar ===
        setJMenuBar(new StoreManagerScreen(store).createMenuBar());

        // === Form Input ===
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        idField       = new JTextField();
        titleField    = new JTextField();
        categoryField = new JTextField();
        costField     = new JTextField();
        directorField = new JTextField();
        artistField   = new JTextField();

        formPanel.add(new JLabel("ID:"));
        formPanel.add(idField);
        formPanel.add(new JLabel("Title:"));
        formPanel.add(titleField);
        formPanel.add(new JLabel("Category:"));
        formPanel.add(categoryField);
        formPanel.add(new JLabel("Cost:"));
        formPanel.add(costField);
        formPanel.add(new JLabel("Director:"));
        formPanel.add(directorField);
        formPanel.add(new JLabel("Artist:"));
        formPanel.add(artistField);

        add(formPanel, BorderLayout.CENTER);

        // === Add Button ===
        JButton addButton = new JButton("Add to Store");
        addButton.setPreferredSize(new Dimension(150, 30));
        addButton.addActionListener(e -> addItemToStore());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    protected void addItemToStore() {
        try {
            int id       = Integer.parseInt(idField.getText());
            String title = titleField.getText();
            String category = categoryField.getText();
            float cost   = Float.parseFloat(costField.getText());
            String director = directorField.getText();
            String artist   = artistField.getText();

            if (title.isEmpty() || category.isEmpty() ||
                    director.isEmpty() || artist.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please fill in all fields!", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            CompactDisc cd = new CompactDisc(id, title, category, cost, director, artist);
            store.addMedia(cd);

            JOptionPane.showMessageDialog(this,
                    "CD added successfully!");
            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid number format!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void clearFields() {
        idField.setText("");
        titleField.setText("");
        categoryField.setText("");
        costField.setText("");
        directorField.setText("");
        artistField.setText("");

        // cũng clear các field chung từ lớp cha
        titleField.setText("");
        costField.setText("");
    }
}
