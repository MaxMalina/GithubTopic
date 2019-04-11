package android.sample.com.topreposgithub.model

import com.google.gson.annotations.SerializedName

data class RepoResponse (
        @SerializedName("items")
        var repos: List<Repo>
)