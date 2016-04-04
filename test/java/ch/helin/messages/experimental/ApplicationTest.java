package ch.helin.messages.experimental;

import org.junit.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @org.junit.Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertThat(a, equalTo(2));
    }
}
