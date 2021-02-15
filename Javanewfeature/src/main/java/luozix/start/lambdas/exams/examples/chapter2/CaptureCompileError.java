package luozix.start.lambdas.exams.examples.chapter2;

import javax.swing.JButton;

public class CaptureCompileError {

    private JButton button;

    public void error() {
        String name = getUserName();
        name = formatUserName(name);
        // Uncommenting this line should cause a compile error:
        // button.addActionListener(event -> System.out.println("hi " + name));
    }

    private String formatUserName(String name) {
        return name.toLowerCase();
    }

    private String getUserName() {
        return "RICHARD";
    }
}
