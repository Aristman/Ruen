buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {

        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.JetpackCore.navigation}")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:${Versions.ktLint}")
    }
}

plugins {
//    id("org.jlleitschuh.gradle.ktlint")
    id("com.android.application") version "7.1.2" apply false
    id("com.android.library") version "7.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.6.20" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
