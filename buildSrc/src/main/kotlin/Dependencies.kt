object Dependencies {
    object Lifecycle {
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Lifecycle.lifeCycle}"
        const val runTime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Lifecycle.lifeCycle}"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Lifecycle.lifeCycle}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.Retrofit.retrofit}"
        const val converter = "com.squareup.retrofit2:converter-gson:${Versions.Retrofit.retrofit}"
        const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.Retrofit.okhttp3}"
    }

    object Room {
        const val runTime = "androidx.room:room-runtime:${Versions.Room.room}"
        const val compiler = "androidx.room:room-compiler:${Versions.Room.room}"
        const val ktx = "androidx.room:room-ktx:${Versions.Room.room}"
    }

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Coroutines.coroutines}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Coroutines.coroutines}"
    }

    object JetpackCompose {
        const val ui = "androidx.compose.ui:ui:${Versions.JetpackCompose.compose}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.JetpackCompose.compose}"
        const val foundation = "androidx.compose.foundation:foundation:${Versions.JetpackCompose.compose}"
        const val material = "androidx.compose.material:material:${Versions.JetpackCompose.compose}"
        const val materialIconsCore = "androidx.compose.material:material-icons-core:${Versions.JetpackCompose.compose}"
        const val materialIconsExtended = "androidx.compose.material:material-icons-extended:${Versions.JetpackCompose.compose}"
        const val runTimeLiveData = "androidx.compose.runtime:runtime-livedata:${Versions.JetpackCompose.compose}"
        const val themeAdapter = "com.google.android.material:compose-theme-adapter:${Versions.JetpackCompose.composeThemeAdapter}"
        const val accompanistAppcompatTheme = "com.google.accompanist:accompanist-appcompat-theme:${Versions.JetpackCompose.accompanistAppcompatTheme}"
        const val navigation = "androidx.navigation:navigation-compose:${Versions.JetpackCompose.composeNavigation}"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${Versions.Glide.glide}"
        const val compiler = "com.github.bumptech.glide:compiler:${Versions.Glide.glide}"
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:${Versions.Hilt.hilt}"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.Hilt.hilt}"
    }

    object JetpackCore {
        const val coreKtx = "androidx.core:core-ktx:${Versions.JetpackCore.coreKtx}"
        const val collectionKtx = "androidx.collection:collection-ktx:${Versions.JetpackCore.collectionKtx}"
        const val activityKtx = "androidx.activity:activity-ktx:${Versions.JetpackCore.activityKtx}"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.JetpackCore.fragmentKtx}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.JetpackCore.appcompat}"
        const val material = "com.google.android.material:material:${Versions.JetpackCore.material}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.JetpackCore.constraintLayout}"
    }

    object Tests {
        const val jUnit = "junit:junit:${Versions.Tests.jUnit}"
        const val jUnitExt = "androidx.test.ext:junit:${Versions.Tests.jUnitExt}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.Tests.espressoCore}"
        const val composeUiTests = "androidx.compose.ui:ui-test-junit4:${Versions.Tests.composeUiTests}"
    }
}