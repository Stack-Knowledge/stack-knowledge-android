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
public final class GetAuthorityInfoUseCase_Factory implements Factory<GetAuthorityInfoUseCase> {
  private final Provider<AuthRepository> repositoryProvider;

  public GetAuthorityInfoUseCase_Factory(Provider<AuthRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetAuthorityInfoUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetAuthorityInfoUseCase_Factory create(
      Provider<AuthRepository> repositoryProvider) {
    return new GetAuthorityInfoUseCase_Factory(repositoryProvider);
  }

  public static GetAuthorityInfoUseCase newInstance(AuthRepository repository) {
    return new GetAuthorityInfoUseCase(repository);
  }
}
