package com.example.apifinal

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SpaceX(
    @SerializedName("fairings") var fairings: Any?,
    @SerializedName("links") var links: Links,
    @SerializedName("reddit") var reddit: Reddit?,
    @SerializedName("launch") var launch: String?,
    @SerializedName("rocket") var rocket: String?,
    @SerializedName("success") var success: Boolean?,
    @SerializedName("failures") var failures: List<Any?>?,
    @SerializedName("details") var details: Any?,
    @SerializedName("crew") var crew: List<Crew>,
    @SerializedName("ships") var ships: List<Any?>?,
    @SerializedName("capsules") var capsules: List<String>?,
    @SerializedName("payloads") var payloads: List<String>?,
    @SerializedName("launchpad") var launchpad: String?,
    @SerializedName("flight_number") var flightNumber: Int?,
    @SerializedName("name") var name: String?,
    @SerializedName("date_utc") var dateUtc: String?,
    @SerializedName("date_unix") var dateUnix: Long?,
    @SerializedName("date_local") var dateLocal: String?,
    @SerializedName("date_precision") var datePrecision: String?,
    @SerializedName("upcoming") var upcoming: Boolean?,
    @SerializedName("cores") var cores: List<Cores>,
    @SerializedName("id") var id: String?
) : Serializable

data class Links(
    val patch: Patch?,
    val small: String?,
    val large: String?,
    val presskit: Any?,
    val media: Any?,
    val recovery: Any?,
    @SerializedName("wikipedia") var wikipedia: String?,
    @SerializedName("webcast") var webcast: String?,
    @SerializedName("youtube_id") var youtubeId: String?,
    val flickr: Flickr?,
    val article: Any?
): Serializable

data class Patch(
    val small: String?,
    val large: String?
): Serializable

data class Reddit(
    val campaign: Any?
): Serializable

data class Flickr(
    val small: List<Any?>?,
    val original: List<Any?>?
): Serializable

data class Crew(
    val crew: String?,
    val role: String?
): Serializable

data class Cores(
    val core: String?,
    val flight: Int?,
    val gridfins: Boolean?,
    val legs: Boolean?,
    val reused: Boolean?,
    val landing_attempt: Boolean?,
    val landing_success: Boolean?,
    val landing_type: String?,
    val landpad: String?,
    val auto_update: Boolean?,
    val tbd: Boolean?,
    val launch_library_id: String?
) : Serializable