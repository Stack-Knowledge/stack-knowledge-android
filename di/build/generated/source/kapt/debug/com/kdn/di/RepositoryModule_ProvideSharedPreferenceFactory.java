package com.kdn.di;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RepositoryModule_ProvideSharedPreferenceFactory implements Factory<SharedPreferences> {
  private final RepositoryModule module;

  private final Provider<Context> contextProvider;

  public RepositoryModule_ProvideSharedPreferenceFactory(RepositoryModule module,
      Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public SharedPreferences get() {
    return provideSharedPreference(module, contextProvider.get());
  }

  public static RepositoryModule_ProvideSharedPreferenceFactory create(RepositoryModule module,
      Provider<Context> contextProvider) {
    return new RepositoryModule_ProvideSharedPreferenceFactory(module, contextProvider);
  }

  public static SharedPreferences provideSharedPreference(RepositoryModule instance,
      Context context) {
    return Preconditions.checkNotNullFromProvides(instance.provideSharedPreference(context));
  }
}
