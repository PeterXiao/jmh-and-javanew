package luozix.start.lambdas.exams.examples.chapter1.examples.chapter4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import luozix.start.lambdas.exams.examples.chapter4.Child;
import luozix.start.lambdas.exams.examples.chapter4.ChildImpl;
import luozix.start.lambdas.exams.examples.chapter4.OverridingChild;
import luozix.start.lambdas.exams.examples.chapter4.OverridingParent;
import luozix.start.lambdas.exams.examples.chapter4.Parent;
import luozix.start.lambdas.exams.examples.chapter4.ParentImpl;

public class TestDefaultSubClassing {

// BEGIN parent_default_used
@Test
public void parentDefaultUsed() {
    Parent parent = new ParentImpl();
    parent.welcome();
    assertEquals("Parent: Hi!", parent.getLastMessage());
}
// END parent_default_used

// BEGIN child_override_default
@Test
public void childOverrideDefault() {
    Child child = new ChildImpl();
    child.welcome();
    assertEquals("Child: Hi!", child.getLastMessage());
}
// END child_override_default

// BEGIN concrete_beats_default
@Test
public void concreteBeatsDefault() {
    Parent parent = new OverridingParent();
    parent.welcome();
    assertEquals("Class Parent: Hi!", parent.getLastMessage());
}
// END concrete_beats_default

// BEGIN concrete_beats_closer_default
@Test
public void concreteBeatsCloserDefault() {
    Child child = new OverridingChild();
    child.welcome();
    assertEquals("Class Parent: Hi!", child.getLastMessage());
}
// END concrete_beats_closer_default

}
