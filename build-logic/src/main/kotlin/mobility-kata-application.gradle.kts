plugins {
    // Apply the common convention plugin for shared build configuration between library and application projects.
    id("mobility-kata-common")

    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}
