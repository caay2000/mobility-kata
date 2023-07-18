package com.github.caay2000.mobilitykata.configuration

import io.ktor.server.application.createApplicationPlugin
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

val RoutingConfiguration = createApplicationPlugin(name = "RoutingConfiguration") {
    application.routing {
//        post("/register") { DiKt.get<CreateUserController>().invoke(this.call) }
//        get("/user/{id}") { DiKt.get<FindUserController>().invoke(this.call) }
//        post("/retrieve") { DiKt.get<CreateLoanController>().invoke(this.call) }
//        post("/return/{id}") { DiKt.get<ReturnBookController>().invoke(this.call) }
//
//        get("/books") { DiKt.get<SearchBookController>().invoke(this.call) }
//        post("/books") { DiKt.get<CreateBookController>().invoke(this.call) }
    }
}
