package befaster.solutions.HLO;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class HelloSolutionTest {

    private HelloSolution helloSolution;

    @Before
    public void setUp() {
        helloSolution = new HelloSolution();
    }

    @Test
    public void should_print_a_message_given_correct_input() {
        assertThat(helloSolution.hello("Test_User"), equalTo("Hello, Test_User!"));
    }

    @Test
    public void should_handle_null_input() {
        assertThat(helloSolution.hello(null), equalTo("Hello, !"));
    }
}