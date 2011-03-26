package net.pureessence.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

@Component
public class Tasklet1 extends AbstractTasklet {
    @Autowired
    @Override
    public void setChoice(@Value("${tasklet1.choice}")String choice) {
        this.choice = choice;
    }

    @Resource(name = "tasklet1Executions")
    @Override
    public void setTaskletExecutions(Map<String, TaskletExecution> taskletExecutions) {
        this.taskletExecutions = taskletExecutions;
    }
}
