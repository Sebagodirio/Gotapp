package com.example.gotapp

import com.google.gson.annotations.SerializedName

data class PersonajesResponse (
        @SerializedName("name") var name:String,
        @SerializedName("gender") var gender:String,
        @SerializedName("culture") var culture:String,
        @SerializedName("url") var url:String
        )