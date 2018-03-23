package com.shrinvi.mypubinfo.mypubinfo

import android.util.Log
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.VolleyLog
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONObject

class MPIServiceVolley : MPIServiceInterface {
    val TAG = MPIServiceVolley::class.java.simpleName
    val basePath = "https://api.data.gov.in"


    override fun makeNetworkCall(path: String, params: JSONObject, completionHandler: (response: JSONObject?) -> Unit) {
        val str = "?api-key=579b464db66ec23bdd0000019e8d64bf112b4a4c632410af8993a517&format=json"
        val jsonObjReq = object : JsonObjectRequest(Method.GET, basePath + path+str, params,
                Response.Listener<JSONObject> { response ->
                    Log.d(TAG, "/makeNetworkCall request OK! Response: $response")
                    completionHandler(response)
                },
                Response.ErrorListener { error ->
                    VolleyLog.e(TAG, "/makeNetworkCall request fail! Error: ${error.message}")
                    completionHandler(null)
                }) {
            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                val headers = HashMap<String, String>()
                headers.put("Content-Type", "application/json")
                return headers
            }
        }

        MPIBackendVolley.instance?.addToRequestQueue(jsonObjReq, TAG)
    }
}
