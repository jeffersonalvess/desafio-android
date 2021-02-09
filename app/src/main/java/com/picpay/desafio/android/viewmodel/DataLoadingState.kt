package com.picpay.desafio.android.viewmodel

data class DataLoadingState private constructor(
    val status: Status,
    val msg: String = ""
) {
    enum class Status {
        RUNNING,
        SUCCESS,
        FAILED
    }

    companion object {
        val LOADED = DataLoadingState(Status.SUCCESS)
        val LOADING = DataLoadingState(Status.RUNNING)
        fun error(msg: String) = DataLoadingState(Status.FAILED, msg)
    }
}
