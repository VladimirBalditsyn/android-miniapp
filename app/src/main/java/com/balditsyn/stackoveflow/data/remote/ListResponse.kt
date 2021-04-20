package com.balditsyn.stackoveflow.data.remote

import com.google.gson.annotations.SerializedName

data class ListResponse<T> (
    @SerializedName("items") val items: List<T>
)
