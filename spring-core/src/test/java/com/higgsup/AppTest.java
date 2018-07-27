package com.higgsup;

import static org.junit.Assert.assertTrue;

import com.higgsup.test.ComponentTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ComponentTest.class)
public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
}
