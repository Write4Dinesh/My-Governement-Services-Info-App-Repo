package com.shrinvi.mypubinfo.controller

/**
 * Created by shrinvigroup on 23/03/2018.
 */
import com.shrinvi.mypubinfo.mypubinfo.MPIServiceInterface
import org.json.JSONObject

class MPIAPIController constructor(MPIServiceInjection: MPIServiceInterface): MPIServiceInterface {
    private val MPIService: MPIServiceInterface = MPIServiceInjection

    override fun makeNetworkCall(path: String, params: JSONObject, completionHandler: (response: JSONObject?) -> Unit) {
        MPIService.makeNetworkCall(path, params, completionHandler)
    }
}