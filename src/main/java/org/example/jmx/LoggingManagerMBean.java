package org.example.jmx;

import javax.management.MXBean;

@MXBean
public interface LoggingManagerMBean {
    void enableLogging();
    void disableLogging();
    boolean isLoggingEnabled();
}
