package hust.soict.hespi.aims.screen.manager;

import hust.soict.hespi.aims.media.DigitalVideoDisc;
import hust.soict.hespi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends JFrame {
    private Store store;

    private JTextField idField;
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField costField;
    private JTextField directorField;
    private JTextField lengthField;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        this.store = store;
        setTitle("Add DVD");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Menu bar (reuse from StoreManagerScreen)
        setJMenuBar(new StoreManagerScreen(store).createMenuBar());

        // === Form panel ===
        JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        idField = new JTextField();
        titleField = new JTextField();
        categoryField = new JTextField();
        costField = new JTextField();
        directorField = new JTextField();
        lengthField = new JTextField();

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
        formPanel.add(new JLabel("Length (minutes):"));
        formPanel.add(lengthField);

        JButton addButton = new JButton("Add to Store");
        addButton.addActionListener(e -> addItemToStore());
        formPanel.add(new JLabel()); // Empty label for layout
        formPanel.add(addButton);

        add(formPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void addItemToStore() {
        try {
            int id = Integer.parseInt(idField.getText());
            String title = titleField.getText();
            String category = categoryField.getText();
            float cost = Float.parseFloat(costField.getText());
            String director = directorField.getText();
            int length = Integer.parseInt(lengthField.getText());

            if (title.isEmpty() || category.isEmpty() || director.isEmpty() || length <= 0) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields correctly!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, director, length, cost);
            store.addMedia(dvd);

            JOptionPane.showMessageDialog(this, "DVD added successfully!");
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid ID, cost, or length format!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        idField.setText("");
        titleField.setText("");
        categoryField.setText("");
        costField.setText("");
        directorField.setText("");
        lengthField.setText("");
    }
}
