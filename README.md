# Native iOS Components in Compose Multiplatform with Cupertino

This project demonstrates how to effectively integrate native iOS components within Compose Multiplatform projects using Cupertino styling, creating a seamless cross-platform experience while maintaining native iOS look and feel. You can this more information about [cupertino](https://github.com/alexzhirkevich/compose-cupertino)

## Overview

This project serves as a comprehensive example of implementing native iOS components in a Compose Multiplatform application. It showcases how to bridge the gap between Compose Multiplatform's declarative UI paradigm and iOS native components while maintaining the Cupertino design language.

## App Contents

<img width="388" alt="Ekran Resmi 2025-02-09 17 14 13" src="https://github.com/user-attachments/assets/21c7fe41-f3c3-46e6-88b2-f928fddb4a64" />
<img width="338" alt="Ekran Resmi 2025-02-09 17 14 28" src="https://github.com/user-attachments/assets/197c2e04-2f02-4c5f-8c41-5f984022e8b1" />


## Tech Stack

- **Compose Multiplatform** (version 1.6.1)
- **Kotlin Multiplatform**
- **Cupertino Adaptive** (version 0.1.0-alpha04)
- **iOS Native Components**
- **Android SDK 34**
- **Kotlin** (version 1.9.23)

### Key Dependencies
- Compose Multiplatform for cross-platform UI
- Cupertino Adaptive for iOS-style components
- AndroidX Core KTX for Android functionality
- Platform-specific libraries for native implementations

## Installation and Implementation

### Prerequisites
- Xcode (latest version recommended)
- Android Studio / IntelliJ IDEA
- Kotlin Multiplatform Mobile (KMM) plugin
- CocoaPods

### Setup Steps
1. Clone the repository:
```bash
git clone https://github.com/kaaneneskpc/CMPIOSNativeComponentCupertino.git
```
2. Open the project in Android Studio or IntelliJ IDEA
3. Install required dependencies:
   ```bash
   ./gradlew build
   ```
4. For iOS:
   ```bash
   cd iosApp
   pod install
   ```
5. Run the application on your desired platform

### Implementation Guide
1. Open In Android Studio, Click on File > Open and select the cloned project directory.

Add the dependency to your `libs.versions.toml` file:

```kotlin
[versions]
agp = "8.5.2"
android-compileSdk = "34"
android-minSdk = "24"
android-targetSdk = "34"
androidx-activityCompose = "1.9.3"
androidx-appcompat = "1.7.0"
androidx-constraintlayout = "2.2.0"
androidx-core-ktx = "1.15.0"
androidx-espresso-core = "3.6.1"
androidx-lifecycle = "2.8.4"
androidx-material = "1.12.0"
androidx-test-junit = "1.2.1"
compose-multiplatform = "1.6.1"
cupertinoAdaptive = "0.1.0-alpha04"
junit = "4.13.2"
kotlin = "1.9.23"

[libraries]
cupertino-adaptive = { module = "io.github.alexzhirkevich:cupertino-adaptive", version.ref = "cupertinoAdaptive" }
kotlin-test = { module = "org.jetbrains.kotlin:kotlin-test", version.ref = "kotlin" }
kotlin-test-junit = { module = "org.jetbrains.kotlin:kotlin-test-junit", version.ref = "kotlin" }
junit = { group = "junit", name = "junit", version.ref = "junit" }
androidx-core-ktx = { group = "androidx.core", name = "core-ktx", version.ref = "androidx-core-ktx" }
androidx-test-junit = { group = "androidx.test.ext", name = "junit", version.ref = "androidx-test-junit" }
androidx-espresso-core = { group = "androidx.test.espresso", name = "espresso-core", version.ref = "androidx-espresso-core" }
androidx-appcompat = { group = "androidx.appcompat", name = "appcompat", version.ref = "androidx-appcompat" }
androidx-material = { group = "com.google.android.material", name = "material", version.ref = "androidx-material" }
androidx-constraintlayout = { group = "androidx.constraintlayout", name = "constraintlayout", version.ref = "androidx-constraintlayout" }
androidx-activity-compose = { module = "androidx.activity:activity-compose", version.ref = "androidx-activityCompose" }
androidx-lifecycle-viewmodel = { group = "org.jetbrains.androidx.lifecycle", name = "lifecycle-viewmodel", version.ref = "androidx-lifecycle" }
androidx-lifecycle-runtime-compose = { group = "org.jetbrains.androidx.lifecycle", name = "lifecycle-runtime-compose", version.ref = "androidx-lifecycle" }

[plugins]
androidApplication = { id = "com.android.application", version.ref = "agp" }
androidLibrary = { id = "com.android.library", version.ref = "agp" }
composeMultiplatform = { id = "org.jetbrains.compose", version.ref = "compose-multiplatform" }
kotlinMultiplatform = { id = "org.jetbrains.kotlin.multiplatform", version.ref = "kotlin" }
```
</br>

Add the dependency to your `build.gradle.kts` file:

```kotlin
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)

            implementation(libs.cupertino.adaptive)
        }
    }
}

android {
    namespace = "com.kaaneneskpc.cmpnativeioscomponents"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.kaaneneskpc.cmpnativeioscomponents"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}
```
2. Set up shared code in the common source set
3. Implement platform-specific code where necessary
4. Use Cupertino components for iOS-style UI elements
5. Test on both platforms to ensure consistency

## Contribution Guide

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Acknowledgments

- JetBrains for Compose Multiplatform
- The Cupertino Adaptive library contributors
- The Kotlin Multiplatform community
- All contributors to this project

## Contacts

**Kaan Enes Kapıcı**
- LinkedIn: [Kaan Enes Kapıcı](https://www.linkedin.com/in/kaaneneskpc/)
- GitHub: [@kaaneneskpc](https://github.com/kaaneneskpc)
- Email: kaaneneskpc1@gmail.com

---

## License

This project is licensed under the MIT License - see the LICENSE file for details.

This is a Kotlin Multiplatform project targeting Android, iOS.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that's common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple's CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you're sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
