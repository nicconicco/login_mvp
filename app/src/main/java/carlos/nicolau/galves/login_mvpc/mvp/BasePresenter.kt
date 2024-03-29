package carlos.nicolau.galves.login_mvpc.mvp

import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.Lifecycle
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class BasePresenter <V: Contract.View>: Contract.Presenter<V> {

    protected var mView: V? = null
    private var compositeDisposable = CompositeDisposable()

    override fun attach(view: V) {
        this.mView = view
        view.getLifecycle()?.addObserver(this)
    }

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun detach() {
        disposeDisposable()
        this.mView = null
    }

    private fun disposeDisposable() {
        compositeDisposable.clear()
    }

}