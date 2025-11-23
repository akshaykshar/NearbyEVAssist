package com.nearby.evassist.presentation.history;

import com.nearby.evassist.domain.repository.POIRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class HistoryActivity_MembersInjector implements MembersInjector<HistoryActivity> {
  private final Provider<POIRepository> repoProvider;

  public HistoryActivity_MembersInjector(Provider<POIRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  public static MembersInjector<HistoryActivity> create(Provider<POIRepository> repoProvider) {
    return new HistoryActivity_MembersInjector(repoProvider);
  }

  @Override
  public void injectMembers(HistoryActivity instance) {
    injectRepo(instance, repoProvider.get());
  }

  @InjectedFieldSignature("com.nearby.evassist.presentation.history.HistoryActivity.repo")
  public static void injectRepo(HistoryActivity instance, POIRepository repo) {
    instance.repo = repo;
  }
}
