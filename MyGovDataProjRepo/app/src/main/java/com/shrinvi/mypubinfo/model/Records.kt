package com.shrinvi.mypubinfo.model

import com.google.gson.annotations.SerializedName

/**
 * Created by shrinvigroup on 23/03/2018.
 */
class Records {
    private lateinit var records: List<Record>

    inner class Record {

        @SerializedName("year")
        var mYear: String = ""
        @SerializedName("rural___male")
        var mRuralMale: String = ""
        @SerializedName("rural___female")
        var mRuralFemale: String = ""
        @SerializedName("rural___persons")
        var mRuralPersons: String = ""
        @SerializedName("urban___male")
        var mUrbanMale: String = ""
        @SerializedName("urban___female")
        var mUrbanFemale: String = ""
        @SerializedName("urban___persons")
        var mUrbanPersons: String = ""
            get() = field
            set(value) {
                field = value
            }

        override fun toString(): String {
            val str: String = "year=" + this.mYear + ",rural_male=" + this.mRuralMale
            return str;
        }
    }

    override fun toString(): String {
        var str: String = ""
        for (item: Record in records) {
            str = str + item.toString();
        }
        return str;
    }
}