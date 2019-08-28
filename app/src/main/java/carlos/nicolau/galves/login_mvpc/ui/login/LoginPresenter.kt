package carlos.nicolau.galves.login_mvpc.ui.login

import carlos.nicolau.galves.login_mvpc.domain.model.login.GetUserResponse
import carlos.nicolau.galves.login_mvpc.domain.model.login.User
import carlos.nicolau.galves.login_mvpc.domain.usecase.IGetUserUseCase
import carlos.nicolau.galves.login_mvpc.mvp.BasePresenter
import carlos.nicolau.galves.login_mvpc.mvp.provider.SchedulerProvider
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class LoginPresenter(private val scheduler: SchedulerProvider, private val getUserUseCase: IGetUserUseCase) :
    BasePresenter<LoginContract.View>(),
    LoginContract.Presenter {

    private lateinit var mGetUserResponse: GetUserResponse

    override fun getUser(user: User) {
        getUserUseCase.execute(user)
            .subscribeOn(scheduler.io())
            .retry(1)
            .observeOn(scheduler.ui())
            .subscribe(object : SingleObserver<GetUserResponse> {
                override fun onSuccess(getUserResponse: GetUserResponse) {
                    mGetUserResponse = getUserResponse
                    mView?.onLoading(false)
                    mView?.onLoadLogin()
                }

                override fun onSubscribe(d: Disposable) {
                    mView?.onLoading(true)
                }

                override fun onError(e: Throwable) {
                    mView?.onLoading(false)
                }
            })
    }

    private var mUser: User = User()

}