package carlos.nicolau.galves.login_mvpc.domain.usecase

import carlos.nicolau.galves.login_mvpc.domain.model.login.GetUserResponse
import carlos.nicolau.galves.login_mvpc.domain.model.login.User
import io.reactivex.Single

interface IGetUserUseCase {
    fun execute(user: User): Single<GetUserResponse>
    fun isRunning(): Boolean
}