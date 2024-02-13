plugins {
    id("com.android.application")
}

android {
    namespace = "com.klyukvin.numberconverter"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.klyukvin.numberconverter"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")

    implementation(project(":domain"))
    implementation(project(":data"))

    val viewModel = "2.7.0"
    val dagger = "2.50"

    runtimeOnly("androidx.lifecycle:lifecycle-viewmodel:$viewModel")
    runtimeOnly("androidx.lifecycle:lifecycle-livedata:$viewModel")

    implementation("com.google.dagger:dagger:$dagger")
    annotationProcessor("com.google.dagger:dagger-compiler:$dagger")
}