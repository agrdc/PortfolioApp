package br.com.portfolioapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
open class BaseApiResponse: Parcelable {
 @SerializedName("error_message") var errorMessage: String? = null
}