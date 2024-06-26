plugins {
    id ("com.android.application")
    id ("kotlin-android")
    id ("kotlin-kapt")
}

android {
    namespace = "com.example.loginassessment"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.loginassessment"
        minSdk = 26 // Minimum SDK version required for Dagger Hilt
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {

    implementation ("androidx.core:core-ktx:1.7.0")
    implementation ("androidx.appcompat:appcompat:1.4.0")
    implementation ("com.google.android.material:material:1.5.0")
    implementation ("androidx.activity:activity-ktx:1.4.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

    // Dagger Hilt
    implementation ("com.google.dagger:hilt-android:2.42")
    annotationProcessor ("com.google.dagger:hilt-compiler:2.42")

    // Navigation
    implementation ("androidx.navigation:navigation-fragment-ktx:2.4.0")
    implementation ("androidx.navigation:navigation-ui-ktx:2.4.0")

    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")


    // Lifecycle
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0")

   }
