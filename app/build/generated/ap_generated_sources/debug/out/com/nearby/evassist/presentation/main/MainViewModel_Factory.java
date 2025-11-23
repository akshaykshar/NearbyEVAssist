package com.nearby.evassist.presentation.main;

import com.nearby.evassist.di.ExecutorFactory;
import com.nearby.evassist.domain.repository.POIRepository;
import com.nearby.evassist.domain.usecase.CapturePOIUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class MainViewModel_Factory implements Factory<MainViewModel> {
  private final Provider<POIRepository> repoProvider;

  private final Provider<CapturePOIUseCase> captureUseCaseProvider;

  private final Provider<ExecutorFactory> executorFactoryProvider;

  public MainViewModel_Factory(Provider<POIRepository> repoProvider,
      Provider<CapturePOIUseCase> captureUseCaseProvider,
      Provider<ExecutorFactory> executorFactoryProvider) {
    this.repoProvider = repoProvider;
    this.captureUseCaseProvider = captureUseCaseProvider;
    this.executorFactoryProvider = executorFactoryProvider;
  }

  @Override
  public MainViewModel get() {
    return newInstance(repoProvider.get(), captureUseCaseProvider.get(), executorFactoryProvider.get());
  }

  public static MainViewModel_Factory create(Provider<POIRepository> repoProvider,
      Provider<CapturePOIUseCase> captureUseCaseProvider,
      Provider<ExecutorFactory> executorFactoryProvider) {
    return new MainViewModel_Factory(repoProvider, captureUseCaseProvider, executorFactoryProvider);
  }

  public static MainViewModel newInstance(POIRepository repo, CapturePOIUseCase captureUseCase,
      ExecutorFactory executorFactory) {
    return new MainViewModel(repo, captureUseCase, executorFactory);
  }
}
