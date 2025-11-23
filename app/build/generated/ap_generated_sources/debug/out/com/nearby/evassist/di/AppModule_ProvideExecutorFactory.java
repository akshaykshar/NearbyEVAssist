package com.nearby.evassist.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.processing.Generated;

@ScopeMetadata
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
public final class AppModule_ProvideExecutorFactory implements Factory<ScheduledExecutorService> {
  private final AppModule module;

  public AppModule_ProvideExecutorFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public ScheduledExecutorService get() {
    return provideExecutor(module);
  }

  public static AppModule_ProvideExecutorFactory create(AppModule module) {
    return new AppModule_ProvideExecutorFactory(module);
  }

  public static ScheduledExecutorService provideExecutor(AppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideExecutor());
  }
}
