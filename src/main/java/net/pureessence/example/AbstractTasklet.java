package net.pureessence.example;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public abstract class AbstractTasklet {
    public static final String CHOICE_1 = "choice1";
    public static final String CHOICE_2 = "choice2";

    @Autowired
    protected Repository repository;

    @Autowired
    private Log log;

    protected String choice;
    protected Map<String, TaskletExecution> taskletExecutions;

    private TaskletExecution taskletExecution() {
        return taskletExecutions.get(choice);
    }

    private String getTaskletName() {
        String className = getClass().getName();
        String taskletName = StringUtils.substringAfterLast(className, ".");
        taskletName = StringUtils.uncapitalize(taskletName);
        return taskletName;
    }

    public void execute() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        log.info(String.format("in '%s' execute with choice '%s'", getTaskletName(), choice));
        Method method = Repository.class.getMethod(taskletExecution().getMethodName(), taskletExecution().getParameterClasses());
        Integer repositoryResult =(Integer)method.invoke(repository, taskletExecution().getParameters());
        log.info(String.format("repository result = '%s'", repositoryResult));
    }

    public abstract void setChoice(String choice);

    public abstract void setTaskletExecutions(Map<String, TaskletExecution> taskletExecutions);
}
