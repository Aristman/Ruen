object Dependencies {
    object Lifecycle {
        const val LIFECYCLE_VIEWMODEL_DEP = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Lifecycle.LIFECYCLE_VIEWMODEL_VERSION}"
        const val LIFECYCLE_RUNTIME_DEP = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Lifecycle.LIFECYCLE_RUNTIME_VERSION}"
        const val LIFECYCLE_LIVEDATA_DEP = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Lifecycle.LIFECYCLE_LIVEDATA_VERSION}"
    }

    object Retrofit {
        const val RETROFIT_DEP = "com.squareup.retrofit2:retrofit:${Versions.Retrofit.RETROFIT_VERSION}"
        const val RETROFIT_CONVERTER_DEP = "com.squareup.retrofit2:converter-gson:${Versions.Retrofit.RETROFIT_CONVERTER_VERSION}"
        const val OKHTTP3_INTERCEPTOR_DEP = "com.squareup.okhttp3:logging-interceptor:${Versions.Retrofit.OKHTTP3_INTERCEPTOR_VERSION}"
    }

    object Room {
        const val ROOM_RUNTIME_DEP = "androidx.room:room-runtime:${Versions.Room.ROOM_RUNTIME_VERSION}"
        const val ROOM_COMPILER_DEP = "androidx.room:room-compiler:${Versions.Room.ROOM_COMPILER_VERSION}"
        const val ROOM_KTX_DEP = "androidx.room:room-ktx:${Versions.Room.ROOM_KTX_VERSION}"
    }

    object Coroutines {
        const val COROUTINES_CORE_DEP = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Coroutines.COROUTINES_CORE_VERSION}"
        const val COROUTINES_ANDROID_DEP = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Coroutines.COROUTINES_ANDROID_VERSION}"
    }

    object JetpackCompose {
        const val COMPOSE_UI_DEP = "androidx.compose.ui:ui:${Versions.JetpackCompose.COMPOSE_UI_VERSION}"
        const val COMPOSE_UI_TOOLING_DEP = "androidx.compose.ui:ui-tooling:${Versions.JetpackCompose.COMPOSE_UI_TOOLING_VERSION}"
        const val COMPOSE_FOUNDATION_DEP = "androidx.compose.foundation:foundation:${Versions.JetpackCompose.COMPOSE_FOUNDATION_VERSION}"
        const val COMPOSE_MATERIAL_DEP = "androidx.compose.material:material:${Versions.JetpackCompose.COMPOSE_MATERIAL_VERSION}"
        const val COMPOSE_MATERIAL_ICONS_CORE_DEP = "androidx.compose.material:material-icons-core:${Versions.JetpackCompose.COMPOSE_MATERIAL_ICONS_CORE_VERSION}"
        const val COMPOSE_MATERIAL_ICONS_EXTENDED_DEP = "androidx.compose.material:material-icons-extended:${Versions.JetpackCompose.COMPOSE_MATERIAL_ICONS_EXTENDED_VERSION}"
        const val COMPOSE_RUNTIME_LIVEDATA_DEP = "androidx.compose.runtime:runtime-livedata:${Versions.JetpackCompose.COMPOSE_RUNTIME_LIVEDATA_VERSION}"
        const val COMPOSE_THEME_ADAPTER_DEP = "com.google.android.material:compose-theme-adapter:${Versions.JetpackCompose.COMPOSE_THEME_ADAPTER_VERSION}"
        const val ACCOMPANIST_APPCOMPAT_THEME_DEP = "com.google.accompanist:accompanist-appcompat-theme:${Versions.JetpackCompose.ACCOMPANIST_APPCOMPAT_THEME_VERSION}"
        const val COMPOSE_NAVIGATION_DEP = "androidx.navigation:navigation-compose:${Versions.JetpackCompose.COMPOSE_NAVIGATION_VERSION}"
    }

    object Glide {
        const val GLIDE_DEP = "com.github.bumptech.glide:glide:${Versions.Glide.GLIDE_VERSION}"
        const val GLIDE_COMPILER_DEP = "com.github.bumptech.glide:compiler:${Versions.Glide.GLIDE_COMPILER_VERSION}"
    }

    object Hilt {
        const val HILT_ANDROID_DEP = "com.google.dagger:hilt-android:${Versions.Hilt.HILT_ANDROID_VERSION}"
        const val HILT_ANDROID_COMPILER_DEP = "com.google.dagger:hilt-android-compiler:${Versions.Hilt.HILT_ANDROID_COMPILER_VERSION}"
        const val HILT_NAVIGATION_FRAGMENT_DEP = "androidx.hilt:hilt-navigation-fragment:${Versions.Hilt.HILT_NAVIGATION_FRAGMENT_VERSION}"
        const val HILT_WORK_DEP = "androidx.hilt:hilt-work:${Versions.Hilt.HILT_WORK_VERSION}"
        const val HILT_COMPILER_DEP = "androidx.hilt:hilt-compiler:${Versions.Hilt.HILT_COMPILER_VERSION}"
    }

    object JetpackCore {
        const val CORE_KTX_DEP = "androidx.core:core-ktx:${Versions.JetpackCore.CORE_KTX_VERSION}"
        const val COLLECTION_KTX_DEP = "androidx.collection:collection-ktx:${Versions.JetpackCore.COLLECTION_KTX_VERSION}"
        const val ACTIVITY_KTX_DEP = "androidx.activity:activity-ktx:${Versions.JetpackCore.ACTIVITY_KTX_VERSION}"
        const val FRAGMENT_KTX_DEP = "androidx.fragment:fragment-ktx:${Versions.JetpackCore.FRAGMENT_KTX_VERSION}"
        const val APPCOMPAT_DEP = "androidx.appcompat:appcompat:${Versions.JetpackCore.APPCOMPAT_VERSION}"
        const val MATERIAL_DEP = "com.google.android.material:material:${Versions.JetpackCore.MATERIAL_VERSION}"
        const val CONSTRAINT_LAYOUT_DEP = "androidx.constraintlayout:constraintlayout:${Versions.JetpackCore.CONSTRAINT_LAYOUT_VERSION}"
    }

    object Tests {
        const val JUNIT_DEP = "junit:junit:${Versions.Tests.JUNIT_VERSION}"
        const val JUNIT_EXT_DEP = "androidx.test.ext:junit:${Versions.Tests.JUNIT_EXT_VERSION}"
        const val ESPRESSO_CORE_DEP = "androidx.test.espresso:espresso-core:${Versions.Tests.ESPRESSO_CORE_VERSION}"
        const val COMPOSE_UI_TESTS_DEP = "androidx.compose.ui:ui-test-junit4:${Versions.Tests.COMPOSE_UI_TESTS_VERSION}"
    }
}