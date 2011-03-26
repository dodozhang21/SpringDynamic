package net.pureessence.example;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationTargetException;

import static junit.framework.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/taskletsConfiguration.xml", "/testLogger.xml"})
public class TaskletsTest {
    @Autowired
    private Tasklet1 tasklet1;

    @Autowired
    private Tasklet2 tasklet2;

    @Autowired
    private Tasklet3 tasklet3;

    @Autowired
    private Tasklet4 tasklet4;

    @Autowired
    private Tasklet5 tasklet5;

    @Autowired
    private TestLogger log;

    @Test
    public void executions() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        tasklet1.execute();
        tasklet2.execute();
        tasklet3.execute();
        tasklet4.execute();

        assertEquals("in 'tasklet1' execute with choice 'choice1'", log.getInfoMessages().get(0));
        assertEquals("methodOne with (String, String, Type) is invoked with (tasklet1 arg1, tasklet1 arg2, TYPE_1)", log.getInfoMessages().get(1));
        assertEquals("repository result = '1'", log.getInfoMessages().get(2));

        assertEquals("in 'tasklet2' execute with choice 'choice2'", log.getInfoMessages().get(3));
        assertEquals("methodTwo with (String, Type, Integer) is invoked with (tasklet2 arg1, TYPE_2, 2)", log.getInfoMessages().get(4));
        assertEquals("repository result = '2'", log.getInfoMessages().get(5));

        assertEquals("in 'tasklet3' execute with choice 'choice1'", log.getInfoMessages().get(6));
        assertEquals("methodThree with (Integer, Integer, String, Type) is invoked with (31, 32, tasklet3 arg3, TYPE_3)", log.getInfoMessages().get(7));
        assertEquals("repository result = '3'", log.getInfoMessages().get(8));

        assertEquals("in 'tasklet4' execute with choice 'choice2'", log.getInfoMessages().get(9));
        assertEquals("methodOne with (String, Integer, Type) is invoked with (tasklet4 arg1, 12399, TYPE_3)", log.getInfoMessages().get(10));
        assertEquals("repository result = '1'", log.getInfoMessages().get(11));

//        for(String logMessage : log.getInfoMessages()) {
//            System.out.println(logMessage);
//        }
    }

    @Test(expected = NoSuchMethodException.class)
    public void executeFail() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        // tasklet5 choice1 is incorrectly configured
        tasklet5.execute();
    }
}
