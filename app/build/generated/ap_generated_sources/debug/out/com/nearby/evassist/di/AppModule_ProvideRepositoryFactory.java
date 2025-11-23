package com.nearby.evassist.di;

import android.content.Context;
import com.nearby.evassist.domain.repository.POIRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class AppModule_ProvideRepositoryFactory implements Factory<POIRepository> {
  private final AppModule module;

  private final Provider<Context> ctxProvider;

  public AppModule_ProvideRepositoryFactory(AppModule module, Provider<Context> ctxProvider) {
    this.module = module;
    this.ctxProvider = ctxProvider;
  }

  @Override
  public POIRepository get() {
    return provideRepository(module, ctxProvider.get());
  }

  public static AppModule_ProvideRepositoryFactory create(AppModule module,
      Provider<Context> ctxProvider) {
    return new AppModule_ProvideRepositoryFactory(module, ctxProvider);
  }

  public static POIRepository provideRepository(AppModule instance, Context ctx) {
    return Preconditions.checkNotNullFromProvides(instance.provideRepository(ctx));
  }
}
