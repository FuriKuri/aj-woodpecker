package io.github.furikuri.woodpecker.helper;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;

import java.util.ArrayList;
import java.util.List;

public class TestAppender extends AppenderSkeleton {
    private final List<LoggingEvent> log = new ArrayList<>();

    @Override
    protected void append(LoggingEvent loggingEvent) {
        log.add(loggingEvent);
    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }

    public void initLogger() {
        Logger.getRootLogger().addAppender(this);
    }

    public void removeLogger() {
        Logger.getRootLogger().removeAppender(this);
    }

    public boolean containsLogMessage(String msg) {
        for (LoggingEvent loggingEvent : log) {
            if (loggingEvent.getMessage().equals(msg)) {
                return true;
            }
        }
        return false;
    }
}
