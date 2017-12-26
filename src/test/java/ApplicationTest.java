import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


class ApplicationTest {

    @Before
    void before() {
        System.out.println("Before");
    }

    @Test
    public void shouldDoSomethign() {
        assertThat(true).isTrue();

        assertThat("Truth").isEqualTo("Truth");
    }

    @After
    void after() {
        System.out.println("After");
    }

}