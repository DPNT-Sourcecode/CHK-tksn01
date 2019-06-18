package befaster.solutions.SUM;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SumSolutionTest {
    private SumSolution sum;

    @Before
    public void setUp() {

        sum = new SumSolution();
    }

    @Test
    public void compute_sum() {
        assertThat(sum.compute(1, 1), equalTo(2));
    }

    @Test
    public void compute_sum_with_0_term() {
        assertThat(sum.compute(0, 3), equalTo(3));
    }

    @Test
    public void compute_sum_with_negative_term() {
        assertThat(sum.compute(-5, 4), equalTo(-1));
    }
}

