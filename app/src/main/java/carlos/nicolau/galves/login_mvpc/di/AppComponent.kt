package carlos.nicolau.galves.login_mvpc.di

import carlos.nicolau.galves.login_mvpc.di.modules.appModule
import carlos.nicolau.galves.login_mvpc.di.modules.presenterModule
import carlos.nicolau.galves.login_mvpc.di.modules.useCaseModule

val appComponent = listOf(
    presenterModule,
    appModule,
    useCaseModule
)