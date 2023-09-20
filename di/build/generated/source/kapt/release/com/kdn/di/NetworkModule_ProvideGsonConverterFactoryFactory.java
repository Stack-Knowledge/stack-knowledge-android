package com.kdn.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import retrofit2.converter.gson.GsonConverterFactory;

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
    "KotlinInternalInJava"
})
public final class NetworkModule_ProvideGsonConverterFactoryFactory implements Factory<GsonConverterFactory> {
  @Override
  public GsonConverterFactory get() {
    return provideGsonConverterFactory();
  }

  public static NetworkModule_ProvideGsonConverterFactoryFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static GsonConverterFactory provideGsonConverterFactory() {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideGsonConverterFactory());
  }

  private static final class InstanceHolder {
    private static final NetworkModule_ProvideGsonConverterFactoryFactory INSTANCE = new NetworkModule_ProvideGsonConverterFactoryFactory();
  }
}
