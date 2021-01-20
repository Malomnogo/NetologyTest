package com.malomnogo.netologytest.utils

import android.content.Context
import android.os.Environment
import android.util.Log
import android.widget.Toast
import java.io.*
import java.text.SimpleDateFormat
import java.util.*

class FileLogger {
    companion object {
        private const val LOG_FILE_NAME = "NetworkLog"

        private fun getFileName(): String {
            val time = Calendar.getInstance().time
            val format = SimpleDateFormat("dd-MMM-yyyy")
            val currDate = format.format(time)
            return "${LOG_FILE_NAME}_$currDate.txt"
        }

        fun getOutputStream(context: Context): OutputStream {
            val currName = getFileName();
            Environment.getDownloadCacheDirectory()
            val logFile = File(context.obbDir, currName)
            if (logFile.exists().not()) {
                logFile.createNewFile()
            }
            return FileOutputStream(logFile, true)
        }

        fun writeData(data: String?, context: Context) {
            val currName = getFileName();
            Environment.getDownloadCacheDirectory()
            val logFile = File(context.obbDir, currName)
            if (logFile.exists().not()) {
                logFile.createNewFile()
            }
            val writer = FileOutputStream(logFile, true)
            try {
                writer.write("\n".toByteArray())
                writer.write(data?.toByteArray())
                Log.d("FileLogger", "data to file ${logFile.path} wrote $data")
            } catch (e: Exception) {
                Toast.makeText(
                    context,
                    "error when write to file ${logFile.path}",
                    Toast.LENGTH_LONG
                ).show()
            } finally {
                writer.close()
            }
        }
    }
}

fun java.lang.Exception.writeToFile(context: Context) {
    this.printStackTrace(PrintWriter(FileLogger.getOutputStream(context)))
}