package carlos.nicolau.galves.login_mvpc.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import carlos.nicolau.galves.login_mvpc.R
import carlos.nicolau.galves.login_mvpc.domain.model.login.User
import carlos.nicolau.galves.login_mvpc.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject

class LoginActivity : AppCompatActivity(), LoginContract.View {

    override fun onLoadLogin() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    override fun onLoading(isLoading: Boolean) = if (isLoading) {
        loading.visibility = View.VISIBLE
    } else {
        loading.visibility = View.INVISIBLE
    }

    private val mPresenter: LoginContract.Presenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mPresenter.attach(this)

        setupView()
    }

    private fun setupView() {
        login.setOnClickListener {
            val user = User()
            user.email = username.text.toString()
            user.password = password.text.toString()

            mPresenter.getUser(user)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detach()
    }
}
