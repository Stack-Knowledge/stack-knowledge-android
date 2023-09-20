import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties


plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

kotlin {
    jvmToolchain(17)
}

android {
    namespace = "com.kdn.data"
    compileSdk = Versions.COMPILE_SDK_VERSION

    defaultConfig {
                minSdk = Versions.MIN_SDK_VERSION
                targetSdk = Versions.TARGET_SDK_VERSION

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField(
            "String",
            "BASE_URL",
            gradleLocalProperties(rootDir).getProperty("BASE_URL")
        )

        buildConfigField(
            "String",
            "GAUTH_CLIENT_ID",
            gradleLocalProperties(rootDir).getProperty("GAUTH_CLIENT_ID")
        )
        buildConfigField(
            "String",
            "GOOGLE_CLIENT_ID",
            gradleLocalProperties(rootDir).getProperty("GOOGLE_CLIENT_ID")
        )

        buildConfigField(
            "String",
            "REDIRECT_URI",
            gradleLocalProperties(rootDir).getProperty("REDIRECT_URI")
        )

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
    implementation(project(":domain"))

    implementation(Dependency.JavaX.INJECT)

    implementation(Dependency.Room.ROOM)
    kapt(Dependency.Room.ROOM_COMPILER)

    implementation(Dependency.Libraries.RETROFIT)
    implementation(Dependency.Libraries.RETROFIT_CONVERTER_GSON)
    implementation(Dependency.Libraries.OKHTTP)
    implementation(Dependency.Libraries.OKHTTP_LOGGING_INTERCEPTOR)
    implementation(Dependency.Libraries.SSE)
    testImplementation(Dependency.Libraries.SSE)

    implementation(Dependency.AndroidX.PAGING)

    testImplementation(Dependency.UnitTest.JUNIT)

    implementation(Dependency.DataStore.PREFERENCES)
}