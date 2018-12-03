package com.github.kitwtnb.kotlinnativetutorial.common

expect fun platformName(): String

fun createApplicationScreenMessage() : String {
    return "Hello Kotlin on ${platformName()}"
}
