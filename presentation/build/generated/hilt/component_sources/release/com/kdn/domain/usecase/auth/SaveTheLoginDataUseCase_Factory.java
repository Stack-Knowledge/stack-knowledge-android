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
public final class SaveTheLoginDataUseCase_Factory implements Factory<SaveTheLoginDataUseCase> {
  private final Provider<AuthRepository> authRepositoryProvider;

  public SaveTheLoginDataUseCase_Factory(Provider<AuthRepository> authRepositoryProvider) {
    this.authRepositoryProvider = authRepositoryProvider;
  }

  @Override
  public SaveTheLoginDataUseCase get() {
    return newInstance(authRepositoryProvider.get());
  }

  public static SaveTheLoginDataUseCase_Factory create(
      Provider<AuthRepository> authRepositoryProvider) {
    return new SaveTheLoginDataUseCase_Factory(authRepositoryProvider);
  }

  public static SaveTheLoginDataUseCase newInstance(AuthRepository authRepository) {
    return new SaveTheLoginDataUseCase(authRepository);
  }
}
