package com.example.android.samplemvvmproject.data.network.response

import androidx.room.Embedded
import androidx.room.Entity
import com.google.gson.annotations.SerializedName


data class UserResultsResponse(
    @SerializedName("results")
    val results: List<Results>
)

@Entity(tableName = "userResponse")
data class Results(
    @SerializedName("gender")
    val gender: String,
    @SerializedName("name")
    @Embedded(prefix = "name_")
    val name: Name,
    @SerializedName("location")
    @Embedded(prefix = "location_")
    val location: Location,
    @SerializedName("dob")
    @Embedded(prefix = "dob_")
    val dob: Dob,
    @Embedded(prefix = "picture_")
    @SerializedName("picture")
    val picture: Picture
)

data class Name(
    @SerializedName("title")
    val title: String,
    @SerializedName("first")
    val first: String,
    @SerializedName("last")
    val last: String
)

data class Location(
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String
)

data class Dob(
    @SerializedName("age")
    val age: Int
)

data class Picture(
    @SerializedName("large")
    val large: String,
    @SerializedName("thumbnail")
    val thumbnail: String
)