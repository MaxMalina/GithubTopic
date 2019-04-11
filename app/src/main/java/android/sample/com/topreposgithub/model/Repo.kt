package android.sample.com.topreposgithub.model

import com.google.gson.annotations.SerializedName

data class Repo (
        @SerializedName("html_url")
        var url: String,

        @SerializedName("full_name")
        var fullName: String,

        @SerializedName("description")
        var description: String,

        @SerializedName("language")
        var language: String,

        @SerializedName("topics")
        var topics: List<String>,

        @SerializedName("stargazers_count")
        var stars: Int
)
