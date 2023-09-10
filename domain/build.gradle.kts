plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

kotlin {
    jvmToolchain(17)
}

android {
    namespace = "com.kdn.domain"
    compileSdk = Versions.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = Versions.MIN_SDK_VERSION
        targetSdk = Versions.TARGET_SDK_VERSION

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
        sourceCompatibility = Versions.JAVA_VERSION
        targetCompatibility = Versions.JAVA_VERSION
    }
    kotlinOptions {
        jvmTarget = Versions.JAVA_VERSION.toString()
    }
}

dependencies {
    implementation(Dependency.JavaX.INJECT)

    implementation(Dependency.Kotlin.COROUTINES_CORE)

    implementation(Dependency.AndroidX.PAGING)

    testImplementation(Dependency.UnitTest.JUNIT)

    implementation(Dependency.Libraries.OKHTTP)
}