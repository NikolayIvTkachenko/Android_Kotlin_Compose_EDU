@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    kotlin("kapt")
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    //alias(libs.plugins.org.jetbrains.kotlin.kapt)
    //alias(libs.plugins.hilt.plugin)
    //alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.example.appjetpacktest001"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.appjetpacktest001"
        minSdk = 34
        targetSdk = 34
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

//https://kotlinlang.org/docs/kapt.html#non-existent-type-correction

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)

    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    implementation("io.coil-kt:coil-compose:1.3.2")
    implementation("androidx.compose.runtime:runtime-livedata:1.6.8")

    implementation("androidx.room:room-runtime:2.4.2")
    implementation ("androidx.room:room-ktx:2.4.2")
    implementation ("androidx.compose.runtime:runtime-livedata:1.1.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1")
    annotationProcessor ("androidx.room:room-compiler:2.4.2")
    kapt("androidx.room:room-compiler:2.4.2")
}