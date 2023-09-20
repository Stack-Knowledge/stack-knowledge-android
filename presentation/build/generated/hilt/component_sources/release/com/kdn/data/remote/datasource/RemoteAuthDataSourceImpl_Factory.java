package com.kdn.data.remote.datasource;

import com.kdn.data.remote.api.AuthAPI;
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
    "KotlinInternalInJava"
})
public final class RemoteAuthDataSourceImpl_Factory implements Factory<RemoteAuthDataSourceImpl> {
  private final Provider<AuthAPI> serviceProvider;

  public RemoteAuthDataSourceImpl_Factory(Provider<AuthAPI> serviceProvider) {
    this.serviceProvider = serviceProvider;
  }

  @Override
  public RemoteAuthDataSourceImpl get() {
    return newInstance(serviceProvider.get());
  }

  public static RemoteAuthDataSourceImpl_Factory create(Provider<AuthAPI> serviceProvider) {
    return new RemoteAuthDataSourceImpl_Factory(serviceProvider);
  }

  public static RemoteAuthDataSourceImpl newInstance(AuthAPI service) {
    return new RemoteAuthDataSourceImpl(service);
  }
}
