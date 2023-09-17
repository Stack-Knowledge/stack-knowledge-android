buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Dependency.GradlePlugin.GRADLE_ANDROID)
        classpath(Dependency.GradlePlugin.GRADLE_KOTLIN)
        classpath(Dependency.GradlePlugin.GRADLE_HILT)
    }
}

plugins {
    id(Dependency.GradlePlugin.GRADLE_KTLINT) version Versions.GRADLE_KTLINT
    id("com.google.gms.google-services") version Versions.GMS_GOOGLE_SERVICE apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}