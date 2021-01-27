package com.ekino.onekeysdk.model

import android.os.Parcel
import android.os.Parcelable
import com.ekino.onekeysdk.extensions.isNullable
import com.google.gson.annotations.SerializedName
import com.iqvia.onekey.GetCodeByLabelQuery

class OneKeySpecialityObject(@SerializedName("id") var id: String = "",
                             @SerializedName("lisCode") var lisCode: String = "",
                             @SerializedName("longLbl") var longLbl: String = "") : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString() ?: "",
            parcel.readString() ?: "",
            parcel.readString() ?: "") {
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.apply {
            writeString(id)
            writeString(lisCode)
            writeString(longLbl)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<OneKeySpecialityObject> {
        override fun createFromParcel(parcel: Parcel): OneKeySpecialityObject {
            return OneKeySpecialityObject(parcel)
        }

        override fun newArray(size: Int): Array<OneKeySpecialityObject?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return longLbl
    }

    /**
     * Convert data from GraphQL
     */
    fun parse(data: GetCodeByLabelQuery.Code?): OneKeySpecialityObject {
        if (data.isNullable()) return this
        this.id = data!!.id() ?: ""
        this.lisCode = data.lisCode()
        this.longLbl = data.longLbl()
        return this
    }
}