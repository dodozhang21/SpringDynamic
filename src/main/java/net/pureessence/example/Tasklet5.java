package net.pureessence.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Component
public class Tasklet5 extends AbstractTasklet {
    @Autowired
    @Override
    public void setChoice(@Value("${tasklet5.choice}")String choice) {
        this.choice = choice;
    }

    @Resource(name = "tasklet5Executions")
    @Override
    public void setTaskletExecutions(Map<String, TaskletExecution> taskletExecutions) {
        this.taskletExecutions = taskletExecutions;
    }
}
