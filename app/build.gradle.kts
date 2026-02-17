plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android") // Hilt plugin
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.sujalkhaire.lifeos"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.sujalkhaire.lifeos"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // --- Compose BOM (latest stable) ---
    implementation(platform("androidx.compose:compose-bom:2024.02.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.material:material-icons-extended")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.runtime:runtime-livedata")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation("io.coil-kt:coil-compose:2.6.0")





    // Retrofit for networking
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
// Gson converter for parsing JSON
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Compose testing
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.02.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    // --- Firebase BoM (no versions for individual Firebase libs!) ---
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.firebase:firebase-firestore-ktx")
    implementation("com.google.firebase:firebase-messaging")

    // --- Google Sign-In ---
    implementation("com.google.android.gms:play-services-auth:21.0.0")

    // --- Appwrite SDK ---


    // --- Room (with KSP) ---
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1") // Use KSP for Room

    // --- Coroutines ---
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")

    // --- Hilt (Dependency Injection) ---
    implementation("com.google.dagger:hilt-android:2.51.1")
    ksp("com.google.dagger:hilt-android-compiler:2.51.1") // Use KSP for Hilt
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    // --- Navigation ---
    implementation("androidx.navigation:navigation-compose:2.7.5")

    // --- Lifecycle ---
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

    // --- Activity Compose ---
    implementation("androidx.activity:activity-compose:1.8.1")

    // --- Lottie Animations ---
    implementation("com.airbnb.android:lottie-compose:6.3.0")

    // --- Coil Image Loading ---
    implementation("io.coil-kt:coil-compose:2.5.0")

    // --- Android Core KTX ---
    implementation("androidx.core:core-ktx:1.12.0")

    // --- App Update ---
    implementation("com.google.android.play:app-update-ktx:2.1.0")

    // --- Accompanist ---
    implementation("com.google.accompanist:accompanist-swiperefresh:0.36.0")

    // --- Testing ---
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.1")

    // Hilt testing
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.51.1")
    kspAndroidTest("com.google.dagger:hilt-android-compiler:2.51.1")
}