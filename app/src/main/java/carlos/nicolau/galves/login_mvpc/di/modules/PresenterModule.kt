package carlos.nicolau.galves.login_mvpc.di.modules


import carlos.nicolau.galves.login_mvpc.mvp.provider.AppSchedulerProvider
import carlos.nicolau.galves.login_mvpc.ui.login.LoginPresenter
import carlos.nicolau.galves.login_mvpc.mvp.provider.SchedulerProvider
import carlos.nicolau.galves.login_mvpc.ui.login.LoginContract
import org.koin.dsl.module

val presenterModule = module {

    factory { AppSchedulerProvider() as SchedulerProvider }
    factory { LoginPresenter(
        get(),
        get()
    ) as LoginContract.Presenter }
}