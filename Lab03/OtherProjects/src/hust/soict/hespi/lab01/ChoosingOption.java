import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
        String[] options = {"I do", "I don't"};
        int choice = JOptionPane.showOptionDialog(null,
                "Do you want to change to the first class ticket?",
                "Custom Options",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]); // Mặc định chọn "I do"

        JOptionPane.showMessageDialog(null, "You've chosen: " + options[choice]);
    }
}
