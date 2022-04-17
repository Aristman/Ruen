import org.gradle.api.JavaVersion

object AppConfig {
    const val applicationId = "ru.marslab.ruen"
    const val applicationIdDevSuffix = ".beta"
    const val minSdk = 26
    const val completeSdk = 32
    const val targetSdk = 32
    const val jvmTarget = "1.8"
    val javaVersion = JavaVersion.VERSION_1_8
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val testVersionName = "1"
}

object Module {
    const val app = ":app"
    const val core = ":core"
}
