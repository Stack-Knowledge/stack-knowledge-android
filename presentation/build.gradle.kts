import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties


plugins {
    id("com.android.application")
    id("kotlin-android")
    id("androidx.navigation.safeargs.kotlin")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

kotlin {
    jvmToolchain(17)
}
android {
    namespace = "com.kdn.stack_knowledge_android"
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
            proguardFiles (
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
    composeOptions{
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }
    buildFeatures {
        dataBinding = true
        compose = true
    }
    packagingOptions {
        exclude("mozilla/public-suffix-list.txt")
        exclude("kotlin/coroutines/coroutines.kotlin_builtins")
        exclude("META-INF/gradle/incremental.annotation.processors")
        pickFirst("META-INF/AL2.0")
        pickFirst("META-INF/LGPL2.1")
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":di"))

    implementation(Dependency.AndroidX.RECYCLER_VIEW)
    implementation(Dependency.Compose.COMPOSE)
    implementation(Dependency.Compose.COMPOSE_HILT_NAV)
    implementation(Dependency.AndroidX.FRAGMENT_KTX)
    implementation(Dependency.Compose.ACTIVITY_COMPOSE)
    implementation(Dependency.AndroidX.CORE_KTX)
    implementation(Dependency.AndroidX.LIFECYCLE)
    implementation(Dependency.AndroidX.CONSTRAINT_LAYOUT)
    implementation(Dependency.AndroidX.APP_COMPAT)
    implementation(Dependency.Google.MATERIAL)
    implementation(Dependency.Compose.MATERIAL3)

    implementation(Dependency.Libraries.RETROFIT)
    implementation(Dependency.Libraries.RETROFIT_CONVERTER_GSON)

    implementation(Dependency.Accompanist.ANIMATE_NAVIGATION)

    implementation(Dependency.Kotlin.COROUTINES_CORE)
    implementation(Dependency.Kotlin.COROUTINES_ANDROID)

    implementation(Dependency.Hilt.HILT_ANDROID)
    kapt(Dependency.Hilt.HILT_ANDROID_COMPILER)

    implementation(Dependency.UnitTest.JUNIT)
    androidTestImplementation(Dependency.AndroidTest.ANDROID_JUNIT)
    testImplementation(Dependency.UnitTest.JUNIT)

    implementation(Dependency.AuthSlider.AUTO_SLIDER)
    implementation(Dependency.Glide.GLIDE)

    implementation(Dependency.GAuth.GAUTH)

    implementation(Dependency.AndroidTest.ESPRESSO_CORE)

    implementation(Dependency.AndroidX.NAVIGATION_FRAGMENT)
    implementation(Dependency.AndroidX.NAVIGATION_UI)
}