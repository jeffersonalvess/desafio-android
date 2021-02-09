package com.picpay.desafio.android.viewmodel

data class DataLoadingState private constructor(val status: Status) {
    enum class Status {
        RUNNING,
        SUCCESS,
        FAILED
    }

    companion object {
        val LOADED = DataLoadingState(Status.SUCCESS)
        val LOADING = DataLoadingState(Status.RUNNING)
        val FAILED = DataLoadingState(Status.FAILED)
    }
}
