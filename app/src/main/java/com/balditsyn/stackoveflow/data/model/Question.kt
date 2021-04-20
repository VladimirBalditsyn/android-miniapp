package com.balditsyn.stackoveflow.data.model

import android.text.Spanned
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import com.balditsyn.stackoveflow.data.remote.OwnerDeserializer
import org.sufficientlysecure.htmltextview.HtmlFormatter
import org.sufficientlysecure.htmltextview.HtmlFormatterBuilder

@Entity
data class Question (
    @SerializedName("title") val title: String,
    @SerializedName("score") val score: Int,
    @SerializedName("body") val body: String,
    @SerializedName("owner")
    @JsonAdapter(OwnerDeserializer::class)
    val ownerName: String,
    @PrimaryKey
    @SerializedName("question_id")
    var id: Long,
) {
    fun getHtmlBody(): Spanned {
        return HtmlFormatter.formatHtml(HtmlFormatterBuilder().setHtml(body))
    }
}

