package com.kdn.data.local.datasource;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
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
public final class LocalAuthDataSourceImpl_Factory implements Factory<LocalAuthDataSourceImpl> {
  private final Provider<DataStore<Preferences>> dataStoreProvider;

  public LocalAuthDataSourceImpl_Factory(Provider<DataStore<Preferences>> dataStoreProvider) {
    this.dataStoreProvider = dataStoreProvider;
  }

  @Override
  public LocalAuthDataSourceImpl get() {
    return newInstance(dataStoreProvider.get());
  }

  public static LocalAuthDataSourceImpl_Factory create(
      Provider<DataStore<Preferences>> dataStoreProvider) {
    return new LocalAuthDataSourceImpl_Factory(dataStoreProvider);
  }

  public static LocalAuthDataSourceImpl newInstance(DataStore<Preferences> dataStore) {
    return new LocalAuthDataSourceImpl(dataStore);
  }
}
