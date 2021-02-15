package luozix.start.lambdas.exams.examples.chapter8.template_method.lambdas;

import luozix.start.lambdas.exams.examples.chapter8.template_method.ApplicationDenied;

// BEGIN Criteria
public interface Criteria {

    public void check() throws ApplicationDenied;

}
// END Criteria
