plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.nevidimka655.ui.compose_core"
    compileSdk = project.property("compileSdk").toString().toInt()

    defaultConfig {
        minSdk = project.property("minSdk").toString().toInt()
        consumerProguardFiles("consumer-rules.pro")

        buildFeatures.run {
            compose = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    api(project(mapOf("path" to ":core:haptic")))
    api(platform(libs.compose.bom))
    api(libs.compose.material3.icons.core)
    api(libs.compose.material3.icons.extended)
    api(libs.compose.material3)
    api(libs.compose.material3.windowSizeClass)

    api(libs.compose.ui.tooling)
    debugApi(libs.compose.ui.test.manifest)

    api(libs.androidx.core.ktx)
}