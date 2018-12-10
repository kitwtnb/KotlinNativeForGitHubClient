package com.github.kitwtnb.kotlinnativetutorial

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal actual val applicationDispatcher: CoroutineDispatcher = Dispatchers.Main
