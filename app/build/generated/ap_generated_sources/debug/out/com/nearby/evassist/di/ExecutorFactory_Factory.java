package com.nearby.evassist.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class ExecutorFactory_Factory implements Factory<ExecutorFactory> {
  @Override
  public ExecutorFactory get() {
    return newInstance();
  }

  public static ExecutorFactory_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ExecutorFactory newInstance() {
    return new ExecutorFactory();
  }

  private static final class InstanceHolder {
    private static final ExecutorFactory_Factory INSTANCE = new ExecutorFactory_Factory();
  }
}
