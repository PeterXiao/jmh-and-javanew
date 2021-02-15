package luozix.start.lambdas.exams.examples.chapter1.examples.chapter8.lambdabehave;

public final class Lets {

    // BEGIN describe
public static void describe(String name, Suite behavior) {
    Description description = new Description(name);
    behavior.specifySuite(description);
}
    // END describe

}
