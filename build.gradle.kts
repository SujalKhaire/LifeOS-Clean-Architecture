// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0-rc01" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false
    id("com.google.gms.google-services") version "4.4.0" apply false // Added for Firebase
}

// This block handles dependencies for the build script itself
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // Make sure this matches your Android Gradle Plugin version
        classpath("com.android.tools.build:gradle:8.2.0-rc01")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.51.1")
    }
}