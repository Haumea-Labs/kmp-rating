plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    id("com.vanniktech.maven.publish") version "0.32.0"
    id("signing")
}

group = "com.haumealabs"
version = "1.0.0"

kotlin {
    jvmToolchain(17)

    androidTarget { publishLibraryVariants("release") }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.coroutines.test)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        androidMain.dependencies {
            implementation(libs.kotlinx.coroutines.android)
            implementation(libs.review)
            implementation(libs.review.ktx)
        }

    }

    //https://kotlinlang.org/docs/native-objc-interop.html#export-of-kdoc-comments-to-generated-objective-c-headers
    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
        compilations["main"].compileTaskProvider.configure {
            compilerOptions {
                freeCompilerArgs.add("-Xexport-kdoc")
            }
        }
    }

}

android {
    namespace = "com.haumealabs.rating"
    compileSdk = 35

    defaultConfig {
        minSdk = 21
    }
}

mavenPublishing {

    coordinates(group.toString(), "kmp-rating", version.toString())

    pom {
        name.set("KMP Ratings")
        description.set("Kotlin Multiplatform Library for Ratings")
        url.set("https://github.com/Haumea-Labs/kmp-rating")

        licenses {
            license {
                name.set("MIT")
                url.set("https://opensource.org/licenses/MIT")
            }
        }
        developers {
            developer {
                id.set("jsoriase")
                name.set("jsoriase")
                email.set("haumealabs@gmail.com")
            }
        }
        scm {
            connection.set("scm:git:git://github.com/Haumea-Labs/kmp-rating.git")
            developerConnection.set("scm:git:ssh://git@github.com:haumealabs/tu-repo.git")
            url.set("https://github.com/Haumea-Labs/kmp-rating")
            url.set("https://github.com/Haumea-Labs/kmp-rating")
        }
    }

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()




}
