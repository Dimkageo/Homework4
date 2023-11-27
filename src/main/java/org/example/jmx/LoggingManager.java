package org.example.jmx;

import org.example.jmx.LoggingManagerMBean;

public class LoggingManager implements LoggingManagerMBean {
    private boolean loggingEnabled = true;

    @Override
    public void enableLogging() {
        loggingEnabled = true;
        System.out.println("Логування увімкнено.");
    }

    @Override
    public void disableLogging() {
        loggingEnabled = false;
        System.out.println("Логування вимкнено.");
    }

    @Override
    public boolean isLoggingEnabled() {
        return loggingEnabled;
    }
}
