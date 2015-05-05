package autocorrectpoo;

public class AutoCorrectPOO {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AutoCorrectMainGUI().setVisible(true);
            }
        });
    }
    
}
