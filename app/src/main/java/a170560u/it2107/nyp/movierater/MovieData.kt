package a170560u.it2107.nyp.movierater

import android.os.Parcelable
import android.graphics.Movie
import android.os.Parcel
import kotlinx.android.parcel.Parcelize

@Parcelize
class MovieData(
    val title: String,
    val desc: String,
    val language: String,
    val date: String,
    val suitable: String) : Parcelable {

    companion object {
        @JvmField
        val Parceler = object : Parcelable.Creator<MovieData> {
            override fun createFromParcel(parcel: Parcel) = MovieData(parcel)
            override fun newArray(size: Int) = arrayOfNulls<MovieData>(size)
        }
    }

    private constructor(parcel: Parcel) : this(
        title = parcel.readString(),
        desc = parcel.readString(),
        language = parcel.readString(),
        date = parcel.readString(),
        suitable = parcel.readString()
    )

 //   override fun writeToParcel(parcel: Parcel, flags: Int) {
  //      parcel.writeString(title)
   //     parcel.writeString(desc)
  //      parcel.writeString(language)
  //      parcel.writeString(date)
  //      parcel.writeString(suitable)
  //  }

    override fun describeContents() = 0
}