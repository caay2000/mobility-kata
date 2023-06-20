plugins {
    // Support convention plugins written in Kotlin.
    // Convention plugins are build scripts in 'src/main' that automatically become available as plugins in the main build.
    `kotlin-dsl`
}

project.ext.set("kotlin_version", "1.8.21")
project.ext.set("spotless_version", "6.19.0")

repositories {
    // Use the plugin portal to apply community plugins in convention plugins.
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${project.ext["kotlin_version"]}")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:${project.ext["spotless_version"]}")
}
