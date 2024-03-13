package com.rja.workmanage

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class SimpleWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {

        val message = inputData.getString("WORK_MESSAGE")
        Log.d("WorkManager", message!!)
        return Result.success()
    }
}