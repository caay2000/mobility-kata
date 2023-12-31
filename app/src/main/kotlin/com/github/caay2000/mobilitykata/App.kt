package com.github.caay2000.mobilitykata

import com.github.caay2000.mobilitykata.common.serialization.LocalDateSerializer
import com.github.caay2000.mobilitykata.common.serialization.UUIDSerializer
import com.github.caay2000.mobilitykata.configuration.DependencyInjectionConfiguration
import com.github.caay2000.mobilitykata.configuration.RoutingConfiguration
import com.github.caay2000.mobilitykata.configuration.ShutdownHookConfiguration
import com.github.caay2000.mobilitykata.configuration.StartupHookConfiguration
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.callloging.CallLogging
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.serializersModuleOf
import mu.KotlinLogging
import java.time.LocalDate
import java.util.UUID

fun Application.main() {
    module()
}

fun Application.module() {
    install(CallLogging) { logger = KotlinLogging.logger {} }
    install(StartupHookConfiguration)
    install(ShutdownHookConfiguration)
    install(DependencyInjectionConfiguration)
    install(RoutingConfiguration)
    configureSerialization()
}

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json(
            Json {
                prettyPrint = true
                isLenient = true
            },
        )
        serializersModuleOf(UUID::class, UUIDSerializer)
        serializersModuleOf(LocalDate::class, LocalDateSerializer)
    }
}
