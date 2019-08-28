package carlos.nicolau.galves.login_mvpc.ui.login

import carlos.nicolau.galves.login_mvpc.domain.model.login.User
import carlos.nicolau.galves.login_mvpc.mvp.Contract


interface LoginContract {

    interface View: Contract.View{
        fun onLoadLogin()
        fun onLoading(isLoading: Boolean)
    }

    interface Presenter: Contract.Presenter<View> {
        fun getUser(user: User)
    }
}