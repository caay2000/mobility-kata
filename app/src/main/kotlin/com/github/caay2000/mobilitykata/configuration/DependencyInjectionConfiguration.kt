package com.github.caay2000.mobilitykata.configuration

import com.github.caay2000.mobilitykata.libs.db.InMemoryDatasource
import com.github.caay2000.mobilitykata.libs.di.DiKt
import io.ktor.server.application.createApplicationPlugin

val DependencyInjectionConfiguration = createApplicationPlugin(name = "DependencyInjectionConfiguration") {
    DiKt.register { InMemoryDatasource() }
//    DiKt.register { InMemoryUserRepository(DiKt.bind()) }
//    DiKt.register { InMemoryLoanRepository(DiKt.bind()) }
//    DiKt.register { InMemoryBookRepository(DiKt.bind()) }
//    DiKt.register { InMemoryLoanBookRepository(DiKt.bind()) }
//    DiKt.register { InMemoryUserLoanRepository(DiKt.bind()) }
//    DiKt.register { InMemoryLoanUserRepository(DiKt.bind()) }
//    DiKt.register { UUIDGenerator() }
//    DiKt.register { LocalDateProvider() }
//    DiKt.register { EventBus(numPartitions = 3) }
//    DiKt.register { AsyncDomainEventBus(DiKt.bind()) }
//    DiKt.get<DomainEventBus>()
//        // User
//        .subscribe(CreateLoanOnLoanCreatedEventSubscriber(DiKt.bind()))
//        .subscribe(UpdateUserBanOnLoanFinishedEventSubscriber(DiKt.bind(), DiKt.bind(), DiKt.bind()))
//        .subscribe(UpdateUserLoanOnLoanFinishedEventSubscriber(DiKt.bind()))
//        // Book
//        .subscribe(UpdateBookAvailabilityOnLoanCreatedEventSubscriber(DiKt.bind()))
//        .subscribe(UpdateBookAvailabilityOnLoanFinishedEventSubscriber(DiKt.bind()))
//        // Loan
//        .subscribe(CreateLoanUserOnUserCreatedEventSubscriber(DiKt.bind()))
//        .subscribe(UpdateLoanBookAvailabilityOnLoanCreatedEventSubscriber(DiKt.bind()))
//        .subscribe(UpdateLoanBookAvailabilityOnLoanFinishedEventSubscriber(DiKt.bind()))
//        .subscribe(CreateLoanBookOnBookCreatedEventSubscriber(DiKt.bind()))
//        .subscribe(UpdateUserPenaltyOnUserBannedEventSubscriber(DiKt.bind()))
//
//    DiKt.register { CreateUserController(DiKt.bind(), DiKt.bind(), DiKt.bind()) }
//    DiKt.register { FindUserController(DiKt.bind(), DiKt.bind()) }
//    DiKt.register { CreateLoanController(DiKt.bind(), DiKt.bind(), DiKt.bind(), DiKt.bind(), DiKt.bind(), DiKt.bind()) }
//    DiKt.register { ReturnBookController(DiKt.bind(), DiKt.bind(), DiKt.bind()) }
//    DiKt.register { SearchBookController(DiKt.bind()) }
//    DiKt.register { CreateBookController(DiKt.bind(), DiKt.bind(), DiKt.bind()) }
}
