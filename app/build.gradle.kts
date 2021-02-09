plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(SdkVersions.compileSDK)

    defaultConfig {
        applicationId = "com.picpay.desafio.android"
        minSdkVersion(SdkVersions.minSDK)
        targetSdkVersion(SdkVersions.targetSDK)

        versionCode = Releases.versionCode
        versionName = Releases.versionName

        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") { }

        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        dataBinding = true
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
    implementation(project(":database"))
    implementation(project(":network"))
    implementation(project(":repository"))

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Deps.kotlin)

    implementation(Deps.android.appcompat)
    implementation(Deps.android.circleImageView)
    implementation(Deps.android.constraintLayout)
    implementation(Deps.android.gson)
    implementation(Deps.android.ktx)
    implementation(Deps.android.material)

    implementation(Deps.koin.android)
    implementation(Deps.koin.core)
    implementation(Deps.koin.viewModel)
    implementation(Deps.test.koin)

    implementation(Deps.lifeCycle.liveData)
    implementation(Deps.lifeCycle.runtime)
    implementation(Deps.lifeCycle.viewModel)

    implementation(Deps.coroutines.android)
    implementation(Deps.coroutines.core)
    testImplementation(Deps.test.coroutines)

    implementation(Deps.okhttp.core)
    implementation(Deps.okhttp.mockBrowser)
    implementation(Deps.picasso.core)
    implementation(Deps.retrofit.core)
    implementation(Deps.retrofit.gson)

    testImplementation(Deps.test.junit)
    testImplementation(Deps.test.mockitoCore)
    testImplementation(Deps.test.mockitoKotlin)
    testImplementation(Deps.test.androidx)

    androidTestImplementation(Deps.test.runner)
    androidTestImplementation(Deps.test.espresso)
    androidTestImplementation(Deps.test.ktx)
}
