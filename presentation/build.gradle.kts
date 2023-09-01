plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    namespace = "com.example.stack_knowledge_android"
    compileSdk 33

    defaultConfig {
        applicationId "com.example.stack_knowledge_android"
        minSdk 24
        targetSdk 33
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
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
    implementation(project(":di"))

    implementation(Dependency.AndroidX.CORE_KTX)
    implementation(Dependency.AndroidX.LIFECYCLE)
    implementation(Dependency.AndroidX.PAGING_COMPOSE)

    implementation(Dependency.Retrofit.RETROFIT)
    implementation(Dependency.Retrofit.RETROFIT_CONVERTER_GSON)

    implementation(Dependency.Accompanist.ANIMATE_NAVIGATION)

    implementation(Dependency.Kotlin.COROUTINES_CORE)
    implementation(Dependency.Kotlin.COROUTINES_ANDROID)

    implementation(Dependency.Hilt.HILT_ANDROID)
    kapt(Dependency.Hilt.HILT_ANDROID_COMPILER)

    implementation(Dependency.Coil.COIL)

    implementation(Dependency.ExoPlayer.EXO_PLAYER_CORE)
    implementation(Dependency.ExoPlayer.EXO_PLAYER_UI)

    implementation(Dependency.BootPay.BOOT_PAY)

    debugImplementation(Dependency.AndroidTest.COMPOSE_TOOL)
    debugImplementation(Dependency.AndroidTest.COMPOSE_MANIFEST)
    androidTestImplementation(Dependency.AndroidTest.COMPOSE_TEST)
}