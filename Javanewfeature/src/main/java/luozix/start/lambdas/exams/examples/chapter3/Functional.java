package luozix.start.lambdas.exams.examples.chapter3;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class Functional {

    private JButton button = new JButton();

    // BEGIN field_assignment
    private ActionEvent lastEvent;

    private void registerHandler() {
        button.addActionListener((ActionEvent event) -> {
            this.lastEvent = event;
        });
    }
    // END field_assignment


}
