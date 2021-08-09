package com.peerbitskuldeep.retrofitpost.retrofit

import android.hardware.usb.UsbEndpoint
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface ApiInterface {

    @POST
    fun insertData(@Url endPoint:String, @Body reqBody: Any): Call<ResponseBody>


}