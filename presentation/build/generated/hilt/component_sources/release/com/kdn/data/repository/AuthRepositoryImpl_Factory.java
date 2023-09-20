package com.kdn.data.repository;

import com.kdn.data.local.datasource.LocalAuthDataSource;
import com.kdn.data.remote.datasource.RemoteAuthDataSource;
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
public final class AuthRepositoryImpl_Factory implements Factory<AuthRepositoryImpl> {
  private final Provider<RemoteAuthDataSource> remoteDataSourceProvider;

  private final Provider<LocalAuthDataSource> localDataSourceProvider;

  public AuthRepositoryImpl_Factory(Provider<RemoteAuthDataSource> remoteDataSourceProvider,
      Provider<LocalAuthDataSource> localDataSourceProvider) {
    this.remoteDataSourceProvider = remoteDataSourceProvider;
    this.localDataSourceProvider = localDataSourceProvider;
  }

  @Override
  public AuthRepositoryImpl get() {
    return newInstance(remoteDataSourceProvider.get(), localDataSourceProvider.get());
  }

  public static AuthRepositoryImpl_Factory create(
      Provider<RemoteAuthDataSource> remoteDataSourceProvider,
      Provider<LocalAuthDataSource> localDataSourceProvider) {
    return new AuthRepositoryImpl_Factory(remoteDataSourceProvider, localDataSourceProvider);
  }

  public static AuthRepositoryImpl newInstance(RemoteAuthDataSource remoteDataSource,
      LocalAuthDataSource localDataSource) {
    return new AuthRepositoryImpl(remoteDataSource, localDataSource);
  }
}
