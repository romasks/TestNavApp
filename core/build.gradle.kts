plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
}

android {
  namespace = "com.romasks.core"
  compileSdk = 34

  defaultConfig {
    minSdk = 24

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
    viewBinding = true
  }
}

dependencies {
  api(libs.androidx.ktx)
  api(libs.androidx.appcompat)
  api(libs.material)

  api(libs.androidx.lifecycle.livedata.ktx)
  api(libs.androidx.lifecycle.viewmodel.ktx)

  api(libs.androidx.navigation.fragment.ktx)
  api(libs.androidx.navigation.ui.ktx)
  api(libs.androidx.navigation.dynamic.features.fragment)
}