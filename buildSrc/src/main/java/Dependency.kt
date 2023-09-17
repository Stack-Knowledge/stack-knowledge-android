object Dependency {

    object GradlePlugin {
        const val ANDROID_APPLICATION = "com.androd.application"
        const val GRADLE_ANDROID = "com.android.tools.build:gradle:${Versions.GRADLE_ANDROID}"
        const val GRADLE_KOTLIN =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.GRADLE_KOTLIN}"
        const val GRADLE_HILT = "com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}"
        const val GRADLE_KTLINT = "org.jlleitschuh.gradle.ktlint"
    }

    object Kotlin {
        const val COROUTINES_CORE =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.KOTLINX_COROUTINES}"
        const val COROUTINES_ANDROID =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KOTLINX_COROUTINES}"
    }

    object Compose {
        const val ACTIVITY_COMPOSE =
            "androidx.activity:activity-compose:${Versions.COMPOSE_ACTIVITY}"
        const val COMPOSE = "androidx.compose.ui:ui:${Versions.COMPOSE}"
        const val COMPOSE_TOOLING = "androidx.compose.ui.ui-tooling:${Versions.COMPOSE}"
        const val VIEW_BINDING = "androidx.compose.ui:ui-viewbinding:${Versions.COMPOSE}"
        const val COMPOSE_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}"
        const val MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE_MATERIAL}"
        const val MATERIAL3 = "androidx.compose.material3:material3:${Versions.COMPOSE_MATERIAL3}"
        const val COMPOSE_HILT_NAV = "androidx.hilt:hilt-navigation-compose:${Versions.HILT_NAV}"
        const val FOUNDATION = "androidx.compose.foundation:foundation:${Versions.COMPOSE}"
    }

    object AndroidX {
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
        const val LIFECYCLE = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_KTX}"
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
        const val PREFERENCE_KTX = "androidx.preference:preference-ktx:${Versions.PREFERENCE_KTX}"
        const val LIFECYCLE_VIEWMODEL_KTX =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_KTX}"
        const val CONSTRAINT_LAYOUT =
            "androidx.constraintlayout:constraintlayout:${Versions.CONTRAINT_LAYOUT}"
        const val PAGING = "androidx.paging:paging-runtime:${Versions.PAGING}"
        const val PAGING_COMPOSE = "androidx.paging:paging-compose:${Versions.PAGING_COMPOSE}"
        const val LEANBACK = "androidx.leanback:leanback:${Versions.LEANBACK}"
        const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"
    }

    object Accompanist {
        const val ANIMATE_NAVIGATION =
            "com.google.accompanist:accompanist-navigation-animation:${Versions.ACCOMPANIST}"
        const val VIEW_PAGER =
            "com.google.accompanist:accompanist-pager:${Versions.ACCOMPANIST}"
    }

    object Hilt {
        const val HILT_ANDROID = "com.google.dagger:hilt-android:${Versions.HILT}"
        const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
    }

    object Room {
        const val ROOM = "androidx.room:room-ktx:${Versions.ROOM}"
        const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"
    }

    object Libraries {
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
        const val RETROFIT_CONVERTER_GSON =
            "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
        const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
        const val OKHTTP_LOGGING_INTERCEPTOR =
            "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
        const val SSE = "com.squareup.okhttp3:okhttp-sse:${Versions.OKHTTP}"
    }

    object UnitTest {
        const val JUNIT = "junit:junit:${Versions.JUNIT}"
        const val MOCKITO_KOTLIN = "org.mockito.kotlin:mockito-kotlin:${Versions.MOCKITO_KOTLIN}"
        const val MOCKITO_INLINE = "org.mockito:mockito-inline:${Versions.MOCKITO_KOTLIN}"
    }

    object AndroidTest {
        const val ANDROID_JUNIT = "androidx.test.ext:junit:${Versions.ANDROID_JUNIT}"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"
        const val COMPOSE_TEST = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE}"
        const val COMPOSE_TOOL = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
        const val COMPOSE_MANIFEST = "androidx.compose.ui:ui-test-manifest:${Versions.COMPOSE}"
    }

    object Coil {
        const val COIL = "io.coil-kt:coil-compose:${Versions.COIL}"
    }

    object JavaX {
        const val INJECT = "javax.inject:javax.inject:${Versions.INJECT}"
    }

    object Google {
        const val FIREBASE_ANALYTICS = "com.google.firebase:firebase-analytics-ktx:${Versions.FIREBASE_ANALYTICS}"
        const val FIREBASE_MESSAGING = "com.google.firebase:firebase-messaging-ktx:${Versions.FIREBASE_MESSAGING}"
        const val FIREBASE_BOM = "com.google.firebase:firebase-bom:${Versions.FIREBASE_BOM}"
        const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
        const val GMS_GOOGLE_SERVICE = "com.google.gms.google-services:${Versions.GMS_GOOGLE_SERVICE}"
    }

    object DataStore {
        const val PREFERENCES = "androidx.datastore:datastore-preferences:${Versions.PREFERENCES}"
    }

    object GAuth {
        const val GAUTH = "com.github.GSM-MSG:GAuth-Signin-Android:${Versions.GAUTH}"
    }
}