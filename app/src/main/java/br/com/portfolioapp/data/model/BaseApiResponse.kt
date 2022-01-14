package br.com.portfolioapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
open class BaseApiResponse (
 @SerializedName("error_message") val errorMessage: String?
) : Parcelable