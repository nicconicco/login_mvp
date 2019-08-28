package carlos.nicolau.galves.login_mvpc.mvp.provider

import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler

class TestSchedulerProvider(private val testSchedulerProvider: TestScheduler):
    SchedulerProvider {
    override fun io(): Scheduler {
        return testSchedulerProvider
    }

    override fun ui(): Scheduler {
        return testSchedulerProvider
    }
}