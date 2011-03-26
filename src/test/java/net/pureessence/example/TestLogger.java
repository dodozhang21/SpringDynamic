package net.pureessence.example;

import org.apache.commons.logging.Log;

import java.util.ArrayList;
import java.util.List;


public class TestLogger implements Log {
    private List<String> infoMessages = new ArrayList<String>();
    @Override
    public boolean isDebugEnabled() {
        return false;  
    }

    @Override
    public boolean isErrorEnabled() {
        return false;  
    }

    @Override
    public boolean isFatalEnabled() {
        return false;  
    }

    @Override
    public boolean isInfoEnabled() {
        return true;  
    }

    @Override
    public boolean isTraceEnabled() {
        return false;  
    }

    @Override
    public boolean isWarnEnabled() {
        return false;  
    }

    @Override
    public void trace(Object o) {
        
    }

    @Override
    public void trace(Object o, Throwable throwable) {
        
    }

    @Override
    public void debug(Object o) {
        
    }

    @Override
    public void debug(Object o, Throwable throwable) {
        
    }

    @Override
    public void info(Object o) {
        infoMessages.add((String)o);
    }

    @Override
    public void info(Object o, Throwable throwable) {
        infoMessages.add((String)o);
    }

    @Override
    public void warn(Object o) {
        
    }

    @Override
    public void warn(Object o, Throwable throwable) {
        
    }

    @Override
    public void error(Object o) {
        
    }

    @Override
    public void error(Object o, Throwable throwable) {
        
    }

    @Override
    public void fatal(Object o) {
        
    }

    @Override
    public void fatal(Object o, Throwable throwable) {
        
    }

    public List<String> getInfoMessages() {
        return infoMessages;
    }
}
