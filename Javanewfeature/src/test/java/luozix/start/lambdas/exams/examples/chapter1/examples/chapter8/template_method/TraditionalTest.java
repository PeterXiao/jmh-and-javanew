package luozix.start.lambdas.exams.examples.chapter1.examples.chapter8.template_method;

import org.junit.Test;

import luozix.start.lambdas.exams.examples.chapter8.template_method.ApplicationDenied;
import luozix.start.lambdas.exams.examples.chapter8.template_method.traditional.CompanyLoanApplication;
import luozix.start.lambdas.exams.examples.chapter8.template_method.traditional.EmployeeLoanApplication;
import luozix.start.lambdas.exams.examples.chapter8.template_method.traditional.PersonalLoanApplication;

public class TraditionalTest {

    @Test
    public void fitsTogether() throws ApplicationDenied {
        new CompanyLoanApplication().checkLoanApplication();
        new PersonalLoanApplication().checkLoanApplication();
        new EmployeeLoanApplication().checkLoanApplication();
    }

}