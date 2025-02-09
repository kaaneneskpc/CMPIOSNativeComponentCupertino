package com.kaaneneskpc.cmpnativeioscomponents

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform