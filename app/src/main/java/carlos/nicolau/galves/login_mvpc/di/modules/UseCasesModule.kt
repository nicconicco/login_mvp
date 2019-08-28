package carlos.nicolau.galves.login_mvpc.di.modules

import carlos.nicolau.galves.login_mvpc.data.RetrofitConfig.getServiceRX
import carlos.nicolau.galves.login_mvpc.domain.usecase.GetUserUseCase
import carlos.nicolau.galves.login_mvpc.domain.usecase.IGetUserUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetUserUseCase(getServiceRX()) as IGetUserUseCase }
}