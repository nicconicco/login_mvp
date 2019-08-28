package carlos.nicolau.galves.login_mvpc

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import carlos.nicolau.galves.login_mvpc.di.modules.presenterModule
import carlos.nicolau.galves.login_mvpc.di.modules.useCaseModule
import carlos.nicolau.galves.login_mvpc.domain.model.login.GetUserResponse
import carlos.nicolau.galves.login_mvpc.domain.model.login.User
import carlos.nicolau.galves.login_mvpc.domain.usecase.IGetUserUseCase
import carlos.nicolau.galves.login_mvpc.mvp.provider.TestSchedulerProvider
import carlos.nicolau.galves.login_mvpc.ui.login.LoginActivity
import carlos.nicolau.galves.login_mvpc.ui.login.LoginContract
import carlos.nicolau.galves.login_mvpc.ui.login.LoginPresenter
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


class LoginActivityTest {

    @JvmField
    @Rule
    val activityTestRule = ActivityTestRule(LoginActivity::class.java)

    private val getUserResponse: GetUserResponse = Mockito.mock(GetUserResponse::class.java)
    private val getUserUseCase: IGetUserUseCase = Mockito.mock(IGetUserUseCase::class.java)
    private val testScheduler = TestScheduler()
    private val schedulerProvider = TestSchedulerProvider(testScheduler)
    private val presenter =
        LoginPresenter(schedulerProvider, getUserUseCase)

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        stopKoin()
        startKoin {
           presenter
           getUserUseCase
        }
    }

    @After
    fun after() {
        stopKoin()
    }

    @Test
    fun whenClickBtnLogin_shouldDoLogin() {
        val user = User()
//        Mockito.`when`(presenter.getUser(user))
//        Mockito.`when`(getUserUseCase.execute(user)).thenReturn(Single.just(getUserResponse))

        activityTestRule.launchActivity(null)

        onView(withId(R.id.username)).perform(
            ViewActions.typeText("teste@teste.com.br"),
            ViewActions.pressImeActionButton()
        )

        onView(withId(R.id.password)).perform(
            ViewActions.typeText("123456"),
            ViewActions.pressImeActionButton()
        )

        Espresso.onView(withId(R.id.login)).perform(ViewActions.click())

        verify(presenter.getUser(user))
    }
}