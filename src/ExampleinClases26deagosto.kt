package com.example.a26deagostoenclasesejemplo

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.RuntimeException
import java.net.HttpURLConnection
import java.net.URL


fun main(){

    val test = Test()
    test.connectApi()
}

class Test{


    fun connectApi() {
        try {
            val url = URL("https://jsonplaceholder.typicode.com/posts")
            val conn = url.openConnection() as HttpURLConnection

            if (conn.responseCode != 200){
                throw RuntimeException("FAILED HTTP:" + conn.responseCode)
            }
            val br = BufferedReader(InputStreamReader(conn.inputStream))
            println("OUT from Server ...")
            while(br.readLine()!= null){
                println(br.readLine())
            }
            conn.disconnect()
        }catch (e: IOException){
            e.printStackTrace()
        }

    }
}