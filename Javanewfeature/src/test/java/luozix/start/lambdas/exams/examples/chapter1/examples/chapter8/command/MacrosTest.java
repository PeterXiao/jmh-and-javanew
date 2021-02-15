package luozix.start.lambdas.exams.examples.chapter1.examples.chapter8.command;

import org.junit.Test;

import luozix.start.lambdas.exams.examples.chapter8.command.Close;
import luozix.start.lambdas.exams.examples.chapter8.command.Macro;
import luozix.start.lambdas.exams.examples.chapter8.command.Open;
import luozix.start.lambdas.exams.examples.chapter8.command.Save;

public class MacrosTest {

    @Test
    public void classBasedCommand() {
        MockEditor editor = new MockEditor();

// BEGIN classBasedCommand
Macro macro = new Macro();
macro.record(new Open(editor));
macro.record(new Save(editor));
macro.record(new Close(editor));
macro.run();
// END classBasedCommand

        editor.check();
    }

    @Test
    public void lambdaBasedCommand() {
        MockEditor editor = new MockEditor();

// BEGIN lambdaBasedCommand
Macro macro = new Macro();
macro.record(() -> editor.open());
macro.record(() -> editor.save());
macro.record(() -> editor.close());
macro.run();
// END lambdaBasedCommand

        editor.check();
    }

    @Test
    public void referenceBasedCommand() {
        MockEditor editor = new MockEditor();

// BEGIN referenceBasedCommand
Macro macro = new Macro();
macro.record(editor::open);
macro.record(editor::save);
macro.record(editor::close);
macro.run();
// END referenceBasedCommand

        editor.check();
    }

}
