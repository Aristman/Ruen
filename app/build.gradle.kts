plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
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
        kotlinCompilerExtensionVersion = "1.0.5"
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    //Lifecycle
    implementation(Dependencies.Lifecycle.LIFECYCLE_VIEWMODEL_DEP)
    implementation(Dependencies.Lifecycle.LIFECYCLE_RUNTIME_DEP)
    implementation(Dependencies.Lifecycle.LIFECYCLE_LIVEDATA_DEP)

    //Retrofit
    implementation(Dependencies.Retrofit.RETROFIT_DEP)
    implementation(Dependencies.Retrofit.RETROFIT_CONVERTER_DEP)
    implementation(Dependencies.Retrofit.OKHTTP3_INTERCEPTOR_DEP)

    //Room
    implementation(Dependencies.Room.ROOM_RUNTIME_DEP)
    kapt(Dependencies.Room.ROOM_COMPILER_DEP)
    implementation(Dependencies.Room.ROOM_KTX_DEP)

    //Coroutines
    implementation(Dependencies.Coroutines.COROUTINES_CORE_DEP)
    implementation(Dependencies.Coroutines.COROUTINES_ANDROID_DEP)

    //Jetpack Compose
    implementation(Dependencies.JetpackCompose.COMPOSE_UI_DEP)
    implementation(Dependencies.JetpackCompose.COMPOSE_UI_TOOLING_DEP)
    implementation(Dependencies.JetpackCompose.COMPOSE_FOUNDATION_DEP)
    implementation(Dependencies.JetpackCompose.COMPOSE_MATERIAL_DEP)
    implementation(Dependencies.JetpackCompose.COMPOSE_MATERIAL_ICONS_CORE_DEP)
    implementation(Dependencies.JetpackCompose.COMPOSE_MATERIAL_ICONS_EXTENDED_DEP)
    implementation(Dependencies.JetpackCompose.COMPOSE_RUNTIME_LIVEDATA_DEP)
    implementation(Dependencies.JetpackCompose.COMPOSE_THEME_ADAPTER_DEP)
    implementation(Dependencies.JetpackCompose.ACCOMPANIST_APPCOMPAT_THEME_DEP)
    implementation(Dependencies.JetpackCompose.COMPOSE_NAVIGATION_DEP)

    //Glide
    implementation(Dependencies.Glide.GLIDE_DEP)
    kapt(Dependencies.Glide.GLIDE_COMPILER_DEP)

    //Hilt
    implementation(Dependencies.Hilt.HILT_ANDROID_DEP)
    kapt(Dependencies.Hilt.HILT_ANDROID_COMPILER_DEP)
    implementation(Dependencies.Hilt.HILT_NAVIGATION_FRAGMENT_DEP)
    implementation(Dependencies.Hilt.HILT_WORK_DEP)
    kapt(Dependencies.Hilt.HILT_COMPILER_DEP)

    //Jetpack Core
    implementation(Dependencies.JetpackCore.CORE_KTX_DEP)
    implementation(Dependencies.JetpackCore.COLLECTION_KTX_DEP)
    implementation(Dependencies.JetpackCore.ACTIVITY_KTX_DEP)
    implementation(Dependencies.JetpackCore.FRAGMENT_KTX_DEP)
    implementation(Dependencies.JetpackCore.APPCOMPAT_DEP)
    implementation(Dependencies.JetpackCore.MATERIAL_DEP)
    implementation(Dependencies.JetpackCore.CONSTRAINT_LAYOUT_DEP)

    //Tests
    testImplementation(Dependencies.Tests.JUNIT_DEP)
    androidTestImplementation(Dependencies.Tests.JUNIT_EXT_DEP)
    androidTestImplementation(Dependencies.Tests.ESPRESSO_CORE_DEP)
    androidTestImplementation(Dependencies.Tests.COMPOSE_UI_TESTS_DEP)
}
