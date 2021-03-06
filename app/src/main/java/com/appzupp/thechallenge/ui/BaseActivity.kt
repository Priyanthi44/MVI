package com.appzupp.thechallenge.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseActivity: Fragment() {
    private lateinit var disposables: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initRx()
    }

    private fun initRx() {
        disposables = CompositeDisposable()
    }

    @Synchronized protected fun addSub(disposable: Disposable?) {
        if (disposable == null) return
        disposables.add(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (!disposables.isDisposed) disposables.dispose()
    }


}