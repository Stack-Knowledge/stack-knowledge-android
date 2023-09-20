package com.kdn.stack_knowledge_android.viewmodel;

import com.kdn.domain.usecase.auth.DeleteTokenUseCase;
import com.kdn.domain.usecase.auth.GAuthLoginUseCase;
import com.kdn.domain.usecase.auth.GetAuthorityInfoUseCase;
import com.kdn.domain.usecase.auth.SaveTheLoginDataUseCase;
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
public final class AuthViewModel_Factory implements Factory<AuthViewModel> {
  private final Provider<GAuthLoginUseCase> gAuthLoginUseCaseProvider;

  private final Provider<SaveTheLoginDataUseCase> saveTheLoginDataUseCaseProvider;

  private final Provider<GetAuthorityInfoUseCase> getAuthorityInfoUseCaseProvider;

  private final Provider<DeleteTokenUseCase> deleteTokenUseCaseProvider;

  public AuthViewModel_Factory(Provider<GAuthLoginUseCase> gAuthLoginUseCaseProvider,
      Provider<SaveTheLoginDataUseCase> saveTheLoginDataUseCaseProvider,
      Provider<GetAuthorityInfoUseCase> getAuthorityInfoUseCaseProvider,
      Provider<DeleteTokenUseCase> deleteTokenUseCaseProvider) {
    this.gAuthLoginUseCaseProvider = gAuthLoginUseCaseProvider;
    this.saveTheLoginDataUseCaseProvider = saveTheLoginDataUseCaseProvider;
    this.getAuthorityInfoUseCaseProvider = getAuthorityInfoUseCaseProvider;
    this.deleteTokenUseCaseProvider = deleteTokenUseCaseProvider;
  }

  @Override
  public AuthViewModel get() {
    return newInstance(gAuthLoginUseCaseProvider.get(), saveTheLoginDataUseCaseProvider.get(), getAuthorityInfoUseCaseProvider.get(), deleteTokenUseCaseProvider.get());
  }

  public static AuthViewModel_Factory create(Provider<GAuthLoginUseCase> gAuthLoginUseCaseProvider,
      Provider<SaveTheLoginDataUseCase> saveTheLoginDataUseCaseProvider,
      Provider<GetAuthorityInfoUseCase> getAuthorityInfoUseCaseProvider,
      Provider<DeleteTokenUseCase> deleteTokenUseCaseProvider) {
    return new AuthViewModel_Factory(gAuthLoginUseCaseProvider, saveTheLoginDataUseCaseProvider, getAuthorityInfoUseCaseProvider, deleteTokenUseCaseProvider);
  }

  public static AuthViewModel newInstance(GAuthLoginUseCase gAuthLoginUseCase,
      SaveTheLoginDataUseCase saveTheLoginDataUseCase,
      GetAuthorityInfoUseCase getAuthorityInfoUseCase, DeleteTokenUseCase deleteTokenUseCase) {
    return new AuthViewModel(gAuthLoginUseCase, saveTheLoginDataUseCase, getAuthorityInfoUseCase, deleteTokenUseCase);
  }
}
