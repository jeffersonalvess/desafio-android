// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files

        classpath(Deps.gradle.buildGradle)
        classpath(Deps.gradle.kotlinGradle)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
