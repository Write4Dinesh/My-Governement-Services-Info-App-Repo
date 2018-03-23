package com.shrinvi.mypubinfo.mypubinfo

import org.json.JSONObject

interface MPIServiceInterface {
    fun makeNetworkCall(path: String, params: JSONObject, completionHandler: (response: JSONObject?) -> Unit)
}
