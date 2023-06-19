plugins {
    // Support convention plugins written in Kotlin.
    // Convention plugins are build scripts in 'src/main' that automatically become available as plugins in the main build.
    `kotlin-dsl`
}

val versionKotlin by extra("1.8.21")
val versionSpotless by extra("6.19.0")

repositories {
    // Use the plugin portal to apply community plugins in convention plugins.
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$versionKotlin")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:$versionSpotless")
}
