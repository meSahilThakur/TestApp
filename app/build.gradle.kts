plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    kotlin("plugin.serialization") version "2.1.0"
    //    id ("kotlin-kapt")
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)

    id("androidx.room")

}

android {
    namespace = "com.example.testapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.testapp"
        minSdk = 29
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }

    room {
        schemaDirectory("$projectDir/schemas")
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

//hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

//retrofit
    implementation(libs.retrofit){
        exclude(module = "okhttp" )
    }
    implementation(libs.retrofit.gson)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.retrofit.okhttp)
    implementation(libs.retrofit.urlConnection)
    implementation(libs.retrofit.logging)


    //icons
    implementation("androidx.compose.material:material-icons-extended:1.7.6")

//coil for image
    implementation("io.coil-kt:coil-compose:2.6.0")

    //navigation
    implementation("androidx.navigation:navigation-compose:2.8.5")

    //serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0")


    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    // If this project uses any Kotlin source, use Kotlin Symbol Processing (KSP)
    // See Add the KSP plugin to your project
    ksp("androidx.room:room-compiler:$room_version")
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")
    // optional - Paging 3 Integration
    implementation("androidx.room:room-paging:$room_version")

}




