package carlos.nicolau.galves.login_mvpc

import android.app.Application
import android.content.Context
import carlos.nicolau.galves.login_mvpc.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

open class MyApplication : Application() {

    companion object {
        var context: Context? = null

        fun getAppContext(): Context? {
            return context
        }
    }

    override fun onCreate() {
        super.onCreate()

        context = applicationContext

        startKoin {
            printLogger(Level.DEBUG)
            androidContext(this@MyApplication)
            modules(appComponent)
        }
    }

}