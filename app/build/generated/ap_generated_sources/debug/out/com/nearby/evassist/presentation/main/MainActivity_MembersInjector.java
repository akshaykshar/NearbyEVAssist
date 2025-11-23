package com.nearby.evassist.presentation.main;

import com.nearby.evassist.data.location.MockLocationProvider;
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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<MockLocationProvider> mockLocationProvider;

  public MainActivity_MembersInjector(Provider<MockLocationProvider> mockLocationProvider) {
    this.mockLocationProvider = mockLocationProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<MockLocationProvider> mockLocationProvider) {
    return new MainActivity_MembersInjector(mockLocationProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectMockLocationProvider(instance, mockLocationProvider.get());
  }

  @InjectedFieldSignature("com.nearby.evassist.presentation.main.MainActivity.mockLocationProvider")
  public static void injectMockLocationProvider(MainActivity instance,
      MockLocationProvider mockLocationProvider) {
    instance.mockLocationProvider = mockLocationProvider;
  }
}
