plugins {
    id("com.android.application")
}

android {
    namespace = "zoeque.odin"
    compileSdk = 34

    defaultConfig {
        applicationId = "zoeque.odin"
        minSdk = 24
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
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("io.vavr:vavr:0.10.3")
    testImplementation("junit:junit:4.13.2")
    testImplementation ("org.mockito:mockito-core:3.6.0")
    testImplementation ("org.mockito:mockito-junit-jupiter:3.6.0")
    implementation ("androidx.room:room-runtime:2.0.0")
    annotationProcessor ("androidx.room:room-compiler:2.0.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}