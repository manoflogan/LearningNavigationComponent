package com.krishnanand.kotlinfundamentals

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal


@Parcelize
data class Money(val amount: BigDecimal): Parcelable {
    /*constructor(parcel: Parcel) : this(parcel.readSerializable() as BigDecimal)


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeSerializable(amount)
    }

    override fun describeContents(): Int = 0

    companion object {

        @JvmField
        val CREATOR = object : Parcelable.Creator<Money> {
            override fun createFromParcel(parcel: Parcel): Money {
                return Money(parcel)
            }

            override fun newArray(size: Int): Array<Money?> {
                return arrayOfNulls(size)
            }
        }
    } */

}