package com.kdn.di

import android.util.Log
import com.kdn.data.interceptor.AuthorizationInterceptor
import com.kdn.data.remote.api.auth.AuthAPI
import com.kdn.data.remote.api.item.ItemAPI
import com.kdn.data.remote.api.mission.MissionAPI
import com.kdn.data.remote.api.order.OrderAPI
import com.kdn.data.remote.api.solve.SolveAPI
import com.kdn.data.remote.api.student.StudentAPI
import com.kdn.data.remote.api.user.UserAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor { message -> Log.v("HTTP", message) }
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideOkhttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
         authorizationInterceptor: AuthorizationInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(authorizationInterceptor)
            .build()
    }

    @Provides
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit): AuthAPI {
        return retrofit.create(AuthAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideItemService(retrofit: Retrofit): ItemAPI {
        return retrofit.create(ItemAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideOrderService(retrofit: Retrofit): OrderAPI {
        return retrofit.create(OrderAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideMissionService(retrofit: Retrofit): MissionAPI {
        return retrofit.create(MissionAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideSolveService(retrofit: Retrofit): SolveAPI {
        return retrofit.create(SolveAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideStudentService(retrofit: Retrofit): StudentAPI {
        return retrofit.create(StudentAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserAPI {
        return retrofit.create(UserAPI::class.java)
    }
}