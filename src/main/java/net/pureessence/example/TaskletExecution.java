package net.pureessence.example;


import java.util.ArrayList;
import java.util.List;

public class TaskletExecution {
    private String methodName;
    private Object[] parameters;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public Class[] getParameterClasses() {
        List<Class<?>> parameterClasses = new ArrayList<Class<?>>();
        for (Object parameter : parameters) {
            parameterClasses.add(parameter.getClass());
        }
        return parameterClasses.toArray(new Class[] {});
    }
}
