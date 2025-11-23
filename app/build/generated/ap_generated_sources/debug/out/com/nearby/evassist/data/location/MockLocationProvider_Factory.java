package com.nearby.evassist.data.location;

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
public final class MockLocationProvider_Factory implements Factory<MockLocationProvider> {
  @Override
  public MockLocationProvider get() {
    return newInstance();
  }

  public static MockLocationProvider_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static MockLocationProvider newInstance() {
    return new MockLocationProvider();
  }

  private static final class InstanceHolder {
    private static final MockLocationProvider_Factory INSTANCE = new MockLocationProvider_Factory();
  }
}
