package luozix.start.lambdas.exams.examples.chapter1.examples.chapter8.command;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import luozix.start.lambdas.exams.examples.chapter8.command.Editor;

public class MockEditor implements Editor {

    private final List<String> actions = new ArrayList<>();

    @Override
    public void save() {
        actions.add("save");
    }

    @Override
    public void open() {
        actions.add("open");
    }

    @Override
    public void close() {
        actions.add("close");
    }

    public void check() {
        assertEquals("open", actions.get(0));
        assertEquals("save", actions.get(1));
        assertEquals("close", actions.get(2));
    }

}
