package carlos.nicolau.galves.login_mvpc.data.service

import carlos.nicolau.galves.login_mvpc.domain.model.login.GetUserResponse
import carlos.nicolau.galves.login_mvpc.domain.model.login.User
import io.reactivex.Single
import retrofit2.http.*

object EndPoints{
    const val DO_LOGIN = "/login/auth"
}

interface Service {
    @POST(EndPoints.DO_LOGIN)
    fun getUser(
        @Body request: User
    ): Single<GetUserResponse>
}
