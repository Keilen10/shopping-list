import java.util.Properties

plugins {
    id("com.android.application")
}

// Upload key for Google Play. keystore.properties and the .jks file are never
// committed (see .gitignore); without them, release builds are just unsigned.
val keystoreFile = rootProject.file("keystore.properties")
val keystoreProps = Properties().apply {
    if (keystoreFile.exists()) keystoreFile.inputStream().use { load(it) }
}

val appVersion = Regex("APP_VERSION = '(.+)'")
    .find(file("src/main/assets/version.js").readText())!!
    .groupValues[1]

android {
    namespace = "com.example.shoppinglist"
    compileSdk = 36

    defaultConfig {
        applicationId = "no.itproas.handleliste"
        minSdk = 24
        targetSdk = 36
        versionCode = 4
        versionName = appVersion
    }

    signingConfigs {
        if (keystoreFile.exists()) {
            create("upload") {
                storeFile = rootProject.file(keystoreProps.getProperty("storeFile"))
                storePassword = keystoreProps.getProperty("storePassword")
                keyAlias = keystoreProps.getProperty("keyAlias")
                keyPassword = keystoreProps.getProperty("keyPassword")
            }
        }
    }

    buildTypes {
        release {
            if (keystoreFile.exists()) signingConfig = signingConfigs.getByName("upload")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
