plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.shoppinglist"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.shoppinglist"
        minSdk = 24
        targetSdk = 36
        versionCode = 2
        versionName = "0.0.1"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
