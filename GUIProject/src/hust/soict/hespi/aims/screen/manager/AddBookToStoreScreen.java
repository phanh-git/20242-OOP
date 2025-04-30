package aims.screen.manager;

import hust.soict.hespi.aims.media.Book;
import hust.soict.hespi.aims.screen.manager.StoreManagerScreen;
import hust.soict.hespi.aims.store.Store;
import hust.soict.hespi.aims.screen.manager.AddItemToStoreScreen;

import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField idField;
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField costField;
    private JTextField authorField;

    public AddBookToStoreScreen(Store store) {
        super(store); // Gọi constructor của AddItemToStoreScreen

        setTitle("Add Book");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // === Menu Bar ===
        setJMenuBar(new StoreManagerScreen(store).createMenuBar());

        // === Form Input ===
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        idField = new JTextField();
        titleField = new JTextField();
        categoryField = new JTextField();
        costField = new JTextField();
        authorField = new JTextField();

        formPanel.add(new JLabel("ID:"));
        formPanel.add(idField);
        formPanel.add(new JLabel("Title:"));
        formPanel.add(titleField);
        formPanel.add(new JLabel("Category:"));
        formPanel.add(categoryField);
        formPanel.add(new JLabel("Cost:"));
        formPanel.add(costField);
        formPanel.add(new JLabel("Author:"));
        formPanel.add(authorField);

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
            int id = Integer.parseInt(idField.getText());
            String title = titleField.getText();
            String category = categoryField.getText();
            float cost = Float.parseFloat(costField.getText());
            String author = authorField.getText();

            if (title.isEmpty() || category.isEmpty() || author.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Book book = new Book(id, title, category, cost);
            book.addAuthor(author);
            store.addMedia(book);

            JOptionPane.showMessageDialog(this, "Book added successfully!");
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid number format!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        idField.setText("");
        titleField.setText("");
        categoryField.setText("");
        costField.setText("");
        authorField.setText("");
    }
}
