plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(SdkVersions.compileSDK)

    defaultConfig {
        minSdkVersion(SdkVersions.minSDK)
        targetSdkVersion(SdkVersions.targetSDK)

        versionCode = Releases.versionCode
        versionName = Releases.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") { }

        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(Deps.android.gson)

    implementation(Deps.okhttp.core)
    implementation(Deps.okhttp.mockBrowser)

    implementation(Deps.retrofit.core)
    implementation(Deps.retrofit.gson)

    implementation(Deps.koin.core)
    implementation(Deps.koin.android)

    testImplementation(Deps.test.junit)
    androidTestImplementation(Deps.test.espresso)
}