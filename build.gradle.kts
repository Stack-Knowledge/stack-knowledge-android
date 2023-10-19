buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependency.GradlePlugin.GRADLE_HILT)
        classpath(Dependency.AndroidX.SAFE_ARGS)
    }
}

plugins {
    id(Dependency.GradlePlugin.KTLINT_PLUGIN) version Versions.GRADLE_KTLINT
    id(Dependency.GradlePlugin.ANDROID_APPLICATION_PLUGIN) version Versions.GRADLE_ANDROID apply false
    id(Dependency.GradlePlugin.ANDROID_LIBRARY_PLUGIN) version Versions.GRADLE_ANDROID apply false
    id(Dependency.GradlePlugin.KOTLIN_ANDROID_PLUGIN) version Versions.GRADLE_KOTLIN apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}