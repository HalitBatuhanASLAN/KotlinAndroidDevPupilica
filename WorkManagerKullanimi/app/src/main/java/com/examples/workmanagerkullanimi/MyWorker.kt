package com.examples.workmanagerkullanimi

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(context: Context,workerParameters: WorkerParameters): Worker(context,workerParameters) {
    override fun doWork(): Result {
        val toplam = 10 + 10
        Log.e("Arkaplan sonuç",toplam.toString())
        return Result.success()
    }
}