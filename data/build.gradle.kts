plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "com.kdn.data"
    compileSdk = Version.COMPILE_SDK_VERSION

    defaultConfig {
                minSdk = Version.MIN_SDK_VERSION
                targetSdk = Version.TARGET_SDK_VERSION

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = '1.8'
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(Dependency.JavaX.INJECT)

    implementation(Dependency.Room.ROOM)
    kapt(Dependency.Room.ROOM_COMPILER)

    implementation(Dependency.Retrofit.RETROFIT)
    implementation(Dependency.Retrofit.RETROFIT_CONVERTER_GSON)
    implementation(Dependency.Retrofit.OKHTTP)
    implementation(Dependency.Retrofit.OKHTTP_LOGGING_INTERCEPTOR)
    implementation(Dependency.Retrofit.SSE)
    testImplementation(Dependency.Retrofit.SSE)

    implementation(Dependency.AndroidX.PAGING)

    testImplementation(Dependency.UnitTest.JUNIT)
    testImplementation(Dependency.UnitTest.MOCKITO_KOTLIN)
    testImplementation(Dependency.UnitTest.MOCKITO_INLINE)
}