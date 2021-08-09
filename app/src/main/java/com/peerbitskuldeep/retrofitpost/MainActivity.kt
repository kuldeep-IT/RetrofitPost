package com.peerbitskuldeep.retrofitpost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.peerbitskuldeep.retrofitpost.constants.Constants.Companion.END_POINT
import com.peerbitskuldeep.retrofitpost.model.User
import com.peerbitskuldeep.retrofitpost.retrofit.NetworkCall
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = User("Rudrax",21,"Surat")

        val retrofitData = NetworkCall.instance.insertData(END_POINT,user)

        retrofitData.enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(call: Call<ResponseBody?>, response: Response<ResponseBody?>) {
                Toast.makeText(this@MainActivity, "Data added successfully!", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error ${t.message}!", Toast.LENGTH_SHORT).show()
            }
        })

    }
}