import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application")
    id("kotlin-android")
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
        buildConfigField("String","BASE_URL", getApiKey("BASE_URL"))
        buildConfigField("String","REDIRECT_URI", getApiKey("REDIRECT_URI"))
        buildConfigField("String", "GAUTH_CLIENT_ID", getApiKey("GAUTH_CLIENT_ID"))
        buildConfigField("String", "GOOGLE_CLIENT_ID", getApiKey("GOOGLE_CLIENT_ID"))
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
        viewBinding = true
        compose = true
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":di"))

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
}

fun getApiKey(propertyKey: String): String {
    val propFile = rootProject.file("./local.properties")
    val properties = Properties()
    properties.load(FileInputStream(propFile))
    return properties.getProperty(propertyKey)
}