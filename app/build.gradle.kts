plugins {
    id("com.android.application")
}

val appVersion = Regex("APP_VERSION = '(.+)'")
    .find(file("src/main/assets/version.js").readText())!!
    .groupValues[1]

android {
    namespace = "com.example.shoppinglist"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.shoppinglist"
        minSdk = 24
        targetSdk = 36
        versionCode = 3
        versionName = appVersion
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
