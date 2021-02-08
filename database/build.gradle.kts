plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
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
    kapt(Deps.room.compiler)
    implementation(Deps.room.ktx)
    implementation(Deps.room.runtime)

    implementation(Deps.lifeCycle.liveData)

    implementation(Deps.koin.core)
    implementation(Deps.koin.android)

    testImplementation(Deps.test.junit)
    testImplementation(Deps.test.room)

    androidTestImplementation(Deps.test.espresso)
}