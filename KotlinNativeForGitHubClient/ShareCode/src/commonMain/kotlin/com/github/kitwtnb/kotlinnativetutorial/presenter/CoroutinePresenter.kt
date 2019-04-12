package com.github.kitwtnb.kotlinnativetutorial.presenter

import com.github.kitwtnb.kotlinnativetutorial.applicationDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

internal abstract class CoroutinePresenter : CoroutineScope, Presenter {
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = applicationDispatcher + job

    override fun dispose() {
        job.cancel()
    }
}
