package carlos.nicolau.galves.login_mvpc.app

import carlos.nicolau.galves.login_mvpc.MyApplication
import net.bytebuddy.description.type.TypeList
import org.koin.core.context.startKoin

class TestApp : MyApplication() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            emptyList<TypeList.Generic.Empty>()
        }
    }
}