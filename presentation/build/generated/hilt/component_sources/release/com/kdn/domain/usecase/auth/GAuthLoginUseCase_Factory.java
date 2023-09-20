package com.kdn.domain.usecase.auth;

import com.kdn.domain.repository.AuthRepository;
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
public final class GAuthLoginUseCase_Factory implements Factory<GAuthLoginUseCase> {
  private final Provider<AuthRepository> authRepositoryProvider;

  public GAuthLoginUseCase_Factory(Provider<AuthRepository> authRepositoryProvider) {
    this.authRepositoryProvider = authRepositoryProvider;
  }

  @Override
  public GAuthLoginUseCase get() {
    return newInstance(authRepositoryProvider.get());
  }

  public static GAuthLoginUseCase_Factory create(Provider<AuthRepository> authRepositoryProvider) {
    return new GAuthLoginUseCase_Factory(authRepositoryProvider);
  }

  public static GAuthLoginUseCase newInstance(AuthRepository authRepository) {
    return new GAuthLoginUseCase(authRepository);
  }
}
