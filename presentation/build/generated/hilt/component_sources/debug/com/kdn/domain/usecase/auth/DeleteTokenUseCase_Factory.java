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
public final class DeleteTokenUseCase_Factory implements Factory<DeleteTokenUseCase> {
  private final Provider<AuthRepository> repositoryProvider;

  public DeleteTokenUseCase_Factory(Provider<AuthRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public DeleteTokenUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static DeleteTokenUseCase_Factory create(Provider<AuthRepository> repositoryProvider) {
    return new DeleteTokenUseCase_Factory(repositoryProvider);
  }

  public static DeleteTokenUseCase newInstance(AuthRepository repository) {
    return new DeleteTokenUseCase(repository);
  }
}
