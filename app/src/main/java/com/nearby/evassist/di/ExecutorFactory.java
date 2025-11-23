package com.nearby.evassist.di;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;
@Singleton
public class ExecutorFactory {
    @Inject public ExecutorFactory() {}
    public ScheduledExecutorService create() { return Executors.newSingleThreadScheduledExecutor(); }
}
