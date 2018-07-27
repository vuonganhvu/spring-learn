package com.higgsup;

import com.higgsup.config.AppConfig;
import com.higgsup.service.IService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@ActiveProfiles("dev")
public class AppTest 
{

    @Autowired
    private IService iService;

    @Test
    public void shouldAnswerWithTrue()
    {
        iService.print();
    }
}
