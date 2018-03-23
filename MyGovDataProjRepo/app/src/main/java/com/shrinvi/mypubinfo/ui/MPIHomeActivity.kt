package com.shrinvi.mypubinfo.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.gson.Gson
import com.shrinvi.mypubinfo.controller.MPIAPIController
import com.shrinvi.mypubinfo.R
import com.shrinvi.mypubinfo.model.Records
import com.shrinvi.mypubinfo.mypubinfo.MPIServiceVolley
import org.json.JSONObject

class MPIHomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        findViewById<View>(R.id.request_button).setOnClickListener {
            val service = MPIServiceVolley()
            val apiController = MPIAPIController(service)

            val path = "/resource/3be1d78e-f20d-486b-9db1-28a0870daa0c"
            val params = JSONObject()
            params.put("email", "foo@email.com")
            params.put("password", "barpass")

            apiController.makeNetworkCall(path, params) { response ->
                // Parse the result
val records = Gson().fromJson(response.toString(), Records::class.java)

                findViewById<TextView>(R.id.text_area).setText(records.toString());
            }
        }
    }

    override fun onStart() {
        super.onStart()
    }
}
