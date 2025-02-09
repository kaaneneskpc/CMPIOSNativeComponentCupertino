# Native iOS Components in Compose Multiplatform with Cupertino

This project demonstrates how to effectively integrate native iOS components within Compose Multiplatform projects using Cupertino styling, creating a seamless cross-platform experience while maintaining native iOS look and feel.

## Overview

This project serves as a comprehensive example of implementing native iOS components in a Compose Multiplatform application. It showcases how to bridge the gap between Compose Multiplatform's declarative UI paradigm and iOS native components while maintaining the Cupertino design language.

## App Contents

- Native iOS UI components integration examples
- Cupertino design system implementation
- Cross-platform shared code architecture
- Platform-specific implementations
- Example screens demonstrating various iOS native components
- Integration patterns and best practices

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
1. Clone the repository
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
1. Configure your project's `build.gradle.kts` with necessary dependencies
2. Set up shared code in the common source set
3. Implement platform-specific code where necessary
4. Use Cupertino components for iOS-style UI elements
5. Test on both platforms to ensure consistency

## Acknowledgments

- JetBrains for Compose Multiplatform
- The Cupertino Adaptive library contributors
- The Kotlin Multiplatform community
- All contributors to this project

## Contacts

For questions, suggestions, or contributions:

- **GitHub Issues**: Please use the issues tab in this repository
- **Email**: [Your contact email]
- **Twitter**: [@YourTwitterHandle]

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