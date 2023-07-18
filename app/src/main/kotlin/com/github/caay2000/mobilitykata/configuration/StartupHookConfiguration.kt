package com.github.caay2000.mobilitykata.configuration

import io.ktor.server.application.ApplicationStarted
import io.ktor.server.application.createApplicationPlugin
import io.ktor.server.application.hooks.MonitoringEvent
import mu.KLogger
import mu.KotlinLogging

val StartupHookConfiguration = createApplicationPlugin(name = "StartupHookConfiguration") {
    val logger: KLogger = KotlinLogging.logger {}
    on(MonitoringEvent(ApplicationStarted)) {

        logger.info {
            """

                    __    _ ___ __              __         __
   ____ ___  ____  / /_  (_) (_) /___  __      / /______ _/ /_____ _
  / __ `__ \/ __ \/ __ \/ / / / __/ / / /_____/ //_/ __ `/ __/ __ `/
 / / / / / / /_/ / /_/ / / / / /_/ /_/ /_____/ ,< / /_/ / /_/ /_/ /
/_/ /_/ /_/\____/_.___/_/_/_/\__/\__, /     /_/|_|\__,_/\__/\__,_/
                                /____/
            """.trimIndent()
        }
    }
}
