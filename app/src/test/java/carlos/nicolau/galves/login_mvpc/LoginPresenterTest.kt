package carlos.nicolau.galves.login_mvpc

import carlos.nicolau.galves.login_mvpc.domain.model.login.GetUserResponse
import carlos.nicolau.galves.login_mvpc.domain.model.login.User
import carlos.nicolau.galves.login_mvpc.domain.usecase.IGetUserUseCase
import carlos.nicolau.galves.login_mvpc.mvp.provider.TestSchedulerProvider
import carlos.nicolau.galves.login_mvpc.ui.login.LoginContract
import carlos.nicolau.galves.login_mvpc.ui.login.LoginPresenter
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.koin.test.KoinTest
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class LoginPresenterTest : KoinTest {

    private val mView = mock(LoginContract.View::class.java)
    private val getUserUseCase: IGetUserUseCase = mock(IGetUserUseCase::class.java)
    private val getUserResponse: GetUserResponse = mock(GetUserResponse::class.java)
    private val testScheduler = TestScheduler()
    private val schedulerProvider = TestSchedulerProvider(testScheduler)
    private val presenter =
        LoginPresenter(schedulerProvider, getUserUseCase)

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        presenter.attach(mView)
    }

    @Test
    fun whenCallGetUser_callVerifyIfRemoveDots_success() {
        val user = User()
        `when`(getUserUseCase.execute(user)).thenReturn(Single.just(getUserResponse))
        presenter.getUser(user)
    }

    @Test
    fun whenCallGetUser_callGetUserUseCase_success() {
        val user = User()
        `when`(getUserUseCase.execute(user)).thenReturn(Single.just(getUserResponse))
        presenter.getUser(user)
        verify(getUserUseCase).execute(user)
    }
}