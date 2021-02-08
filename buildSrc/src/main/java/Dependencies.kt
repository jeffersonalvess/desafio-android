object Releases {
    const val versionCode = 10000
    const val versionName = "1.0.0"
}

object SdkVersions {
    const val compileSDK = 30
    const val minSDK = 21
    const val targetSDK = 30
}

object Versions {
    // Kotlin and Gradle plugins
    const val buildGradle = "7.0.0-alpha05"
    const val kotlin = "1.4.21"

    // Dependency Injection
    const val koin = "2.0.1"

    // UI
    const val appcompat = "1.2.0"
    const val circleimageview = "3.0.0"
    const val constraintlayout = "2.0.4"
    const val material = "1.3.0"

    // Lifecycle
    const val coroutines = "1.3.7"
    const val lifecycle = "2.2.0"

    // Kotlin libs
    const val core_ktx = "1.3.2"
    const val gson = "2.8.6"

    // Rest
    const val okhttp = "4.3.1"
    const val picasso = "2.71828"
    const val retrofit = "2.7.1"

    // Testing
    const val core_ktx_test = "1.3.0"
    const val core_testing = "2.1.0"
    const val espresso = "3.3.0"
    const val junit = "4.12"
    const val mockito = "2.27.0"
    const val mockito_kotlin = "2.1.0"
    const val test_runner = "1.3.0"
}

object Deps {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    val android = AndroidDeps
    val coroutines = CoroutinesDeps
    val gradle = GradleDeps
    val koin = KoinDeps
    val lifeCycle = LifeCycleDeps
    val okhttp = OkHttpDeps
    val picasso = PicassoDeps
    val retrofit = RetrofitDeps
    val test = TestDeps
}

object AndroidDeps {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val circleImageView = "de.hdodenhof:circleimageview:${Versions.circleimageview}"
    const val constraintLayout =  "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    const val material = "com.google.android.material:material:${Versions.material}"
}

object KoinDeps {
    const val android = "org.koin:koin-android:${Versions.koin}"
    const val core = "org.koin:koin-core:${Versions.koin}"
    const val viewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
}

object LifeCycleDeps {
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
}

object CoroutinesDeps {
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
}

object RetrofitDeps {
    const val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
}

object OkHttpDeps {
    const val core = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val mockBrowser = "com.squareup.okhttp3:mockwebserver:${Versions.okhttp}"
}

object PicassoDeps {
    const val core = "com.squareup.picasso:picasso:${Versions.picasso}"
}

object TestDeps {
    const val androidx = "androidx.arch.core:core-testing:${Versions.core_testing}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val junit = "junit:junit:${Versions.junit}"
    const val koin = "org.koin:koin-test:${Versions.koin}"
    const val ktx = "androidx.test:core-ktx:${Versions.core_ktx_test}"
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockito_kotlin}"
    const val runner = "androidx.test:runner:${Versions.test_runner}"
}

object GradleDeps {
    const val buildGradle = "com.android.tools.build:gradle:${Versions.buildGradle}"
    const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}
