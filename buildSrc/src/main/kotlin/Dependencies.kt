object Dependencies {
    object Lifecycle {
        const val viewModel =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycle}"
        const val runTime =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycle}"
        const val liveData =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycle}"
    }

    object Retrofit {
        const val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val gsonConverter =
            "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        const val logger = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    }

    object Room {
        const val runTime = "androidx.room:room-runtime:${Versions.room}"
        const val compiler = "androidx.room:room-compiler:${Versions.room}"
        const val ktx = "androidx.room:room-ktx:${Versions.room}"
    }

    object Coroutines {
        const val core =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    }

    object JetpackCompose {
        const val ui = "androidx.compose.ui:ui:${Versions.JetpackCompose.compose}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.JetpackCompose.compose}"
        const val foundation =
            "androidx.compose.foundation:foundation:${Versions.JetpackCompose.compose}"
        const val material = "androidx.compose.material:material:${Versions.JetpackCompose.compose}"
        const val materialIconsCore =
            "androidx.compose.material:material-icons-core:${Versions.JetpackCompose.compose}"
        const val materialIconsExtended =
            "androidx.compose.material:material-icons-extended:${Versions.JetpackCompose.compose}"
        const val runTimeLiveData =
            "androidx.compose.runtime:runtime-livedata:${Versions.JetpackCompose.compose}"
        const val themeAdapter =
            "com.google.android.material:compose-theme-adapter:${Versions.JetpackCompose.composeThemeAdapter}"
        const val accompanistAppcompatTheme =
            "com.google.accompanist:accompanist-appcompat-theme:${Versions.JetpackCompose.accompanistAppcompatTheme}"
        const val navigation =
            "androidx.navigation:navigation-compose:${Versions.JetpackCompose.composeNavigation}"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    }

    object JetpackCore {
        const val coreKtx = "androidx.core:core-ktx:${Versions.JetpackCore.coreKtx}"
        const val collectionKtx =
            "androidx.collection:collection-ktx:${Versions.JetpackCore.collectionKtx}"
        const val activityKtx = "androidx.activity:activity-ktx:${Versions.JetpackCore.activityKtx}"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.JetpackCore.fragmentKtx}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.JetpackCore.appcompat}"
        const val material = "com.google.android.material:material:${Versions.JetpackCore.material}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.JetpackCore.constraintLayout}"
        const val navigationFragment =
            "androidx.navigation:navigation-fragment-ktx:${Versions.JetpackCore.navigation}"
        const val navigationKtx =
            "androidx.navigation:navigation-ui-ktx:${Versions.JetpackCore.navigation}"
    }

    object FlexBoxLayout {
        const val flexBoxLayout =
            "com.google.android.flexbox:flexbox:${Versions.flexBoxLayout}"
    }

    object Tests {
        const val jUnit = "junit:junit:${Versions.Tests.jUnit}"
        const val jUnitExt = "androidx.test.ext:junit:${Versions.Tests.jUnitExt}"
        const val espressoCore =
            "androidx.test.espresso:espresso-core:${Versions.Tests.espressoCore}"
        const val composeUiTests =
            "androidx.compose.ui:ui-test-junit4:${Versions.Tests.composeUiTests}"
    }
}
