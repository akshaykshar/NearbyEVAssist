package com.nearby.evassist.domain.usecase;

import com.nearby.evassist.domain.repository.POIRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class CapturePOIUseCase_Factory implements Factory<CapturePOIUseCase> {
  private final Provider<POIRepository> repoProvider;

  public CapturePOIUseCase_Factory(Provider<POIRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public CapturePOIUseCase get() {
    return newInstance(repoProvider.get());
  }

  public static CapturePOIUseCase_Factory create(Provider<POIRepository> repoProvider) {
    return new CapturePOIUseCase_Factory(repoProvider);
  }

  public static CapturePOIUseCase newInstance(POIRepository repo) {
    return new CapturePOIUseCase(repo);
  }
}
