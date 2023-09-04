object Dependency {

    object GradlePlugin {
        const val GRADLE_ANDROID = "com.android.tools.build:gradle:${Version.GRADLE_ANDROID}"
        const val GRADLE_KOTLIN =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.GRADLE_KOTLIN}"
        const val GRADLE_HILT = "com.google.dagger:hilt-android-gradle-plugin:${Version.HILT}"
        const val GRADLE_KTLINT = "org.jlleitschuh.gradle.ktlint"
    }

    object Kotlin {
        const val COROUTINES_CORE =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.KOTLINX_COROUTINES}"
        const val COROUTINES_ANDROID =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.KOTLINX_COROUTINES}"
    }

    object AndroidX {
        const val CORE_KTX = "androidx.core:core-ktx:${Version.CORE_KTX}"
        const val LIFECYCLE = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.LIFECYCLE_KTX}"
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Version.APP_COMPAT}"
        const val PREFERENCE_KTX = "androidx.preference:preference-ktx:${Version.PREFERENCE_KTX}"
        const val LIFECYCLE_VIEWMODEL_KTX =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.LIFECYCLE_KTX}"
        const val CONSTRAINT_LAYOUT =
            "androidx.constraintlayout:constraintlayout:${Version.CONTRAINT_LAYOUT}"
        const val PAGING = "androidx.paging:paging-runtime:${Version.PAGING}"
        const val PAGING_COMPOSE = "androidx.paging:paging-compose:${Version.PAGING_COMPOSE}"
        const val LEANBACK = "androidx.leanback:leanback:${Version.LEANBACK}"
    }

    object Accompanist {
        const val ANIMATE_NAVIGATION =
            "com.google.accompanist:accompanist-navigation-animation:${Version.ACCOMPANIST}"
        const val VIEW_PAGER =
            "com.google.accompanist:accompanist-pager:${Version.ACCOMPANIST}"
    }

    object Hilt {
        const val HILT_ANDROID = "com.google.dagger:hilt-android:${Version.HILT}"
        const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${Version.HILT}"
    }

    object Room {
        const val ROOM = "androidx.room:room-ktx:${Version.ROOM}"
        const val ROOM_COMPILER = "androidx.room:room-compiler:${Version.ROOM}"
    }

    object Retrofit {
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Version.RETROFIT}"
        const val RETROFIT_CONVERTER_GSON =
            "com.squareup.retrofit2:converter-gson:${Version.RETROFIT}"
        const val OKHTTP = "com.squareup.okhttp3:okhttp:${Version.OKHTTP}"
        const val OKHTTP_LOGGING_INTERCEPTOR =
            "com.squareup.okhttp3:logging-interceptor:${Version.OKHTTP}"
        const val SSE = "com.squareup.okhttp3:okhttp-sse:${Version.OKHTTP}"
    }

    object UnitTest {
        const val JUNIT = "junit:junit:${Version.JUNIT}"
        const val MOCKITO_KOTLIN = "org.mockito.kotlin:mockito-kotlin:${Version.MOCKITO_KOTLIN}"
        const val MOCKITO_INLINE = "org.mockito:mockito-inline:${Version.MOCKITO_KOTLIN}"
    }

    object AndroidTest {
        const val ANDROID_JUNIT = "androidx.test.ext:junit:${Version.ANDROID_JUNIT}"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Version.ESPRESSO_CORE}"
        const val COMPOSE_TEST = "androidx.compose.ui:ui-test-junit4:${Version.COMPOSE}"
        const val COMPOSE_TOOL = "androidx.compose.ui:ui-tooling:${Version.COMPOSE}"
        const val COMPOSE_MANIFEST = "androidx.compose.ui:ui-test-manifest:${Version.COMPOSE}"
    }

    object Coil {
        const val COIL = "io.coil-kt:coil-compose:${Version.COIL}"
    }

    object JavaX {
        const val INJECT = "javax.inject:javax.inject:${Version.INJECT}"
    }

    object Google {
        const val MATERIAL = "com.google.android.material:material:${Version.MATERIAL}"
    }
}