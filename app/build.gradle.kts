plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "ru.marslab.ruen"
        minSdk = 26
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.JetpackCompose.compose
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    //Lifecycle
    implementation(Dependencies.Lifecycle.viewModel)
    implementation(Dependencies.Lifecycle.runTime)
    implementation(Dependencies.Lifecycle.liveData)

    //Retrofit
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.converter)
    implementation(Dependencies.Retrofit.interceptor)

    //Room
    implementation(Dependencies.Room.runTime)
    kapt(Dependencies.Room.compiler)
    implementation(Dependencies.Room.ktx)

    //Coroutines
    implementation(Dependencies.Coroutines.core)
    implementation(Dependencies.Coroutines.android)

    //Jetpack Compose
    implementation(Dependencies.JetpackCompose.ui)
    implementation(Dependencies.JetpackCompose.uiTooling)
    implementation(Dependencies.JetpackCompose.foundation)
    implementation(Dependencies.JetpackCompose.material)
    implementation(Dependencies.JetpackCompose.materialIconsCore)
    implementation(Dependencies.JetpackCompose.materialIconsExtended)
    implementation(Dependencies.JetpackCompose.runTimeLiveData)
    implementation(Dependencies.JetpackCompose.themeAdapter)
    implementation(Dependencies.JetpackCompose.accompanistAppcompatTheme)
    implementation(Dependencies.JetpackCompose.navigation)

    //Glide
    implementation(Dependencies.Glide.glide)
    kapt(Dependencies.Glide.compiler)

    //Hilt
    implementation(Dependencies.Hilt.hilt)
    kapt(Dependencies.Hilt.hiltCompiler)

    //Jetpack Core
    implementation(Dependencies.JetpackCore.coreKtx)
    implementation(Dependencies.JetpackCore.collectionKtx)
    implementation(Dependencies.JetpackCore.activityKtx)
    implementation(Dependencies.JetpackCore.fragmentKtx)
    implementation(Dependencies.JetpackCore.appcompat)
    implementation(Dependencies.JetpackCore.material)
    implementation(Dependencies.JetpackCore.constraintLayout)
    implementation(Dependencies.JetpackCore.navigationFragment)
    implementation(Dependencies.JetpackCore.navigationKtx)

    //Tests
    testImplementation(Dependencies.Tests.jUnit)
    androidTestImplementation(Dependencies.Tests.jUnitExt)
    androidTestImplementation(Dependencies.Tests.espressoCore)
    androidTestImplementation(Dependencies.Tests.composeUiTests)
}
