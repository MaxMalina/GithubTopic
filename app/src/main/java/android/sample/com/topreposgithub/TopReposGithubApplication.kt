package android.sample.com.topreposgithub

import android.app.Application
import android.sample.com.topreposgithub.remote.Remote

class TopReposGithubApplication: Application() {

    fun getRemote(): Remote  {
        return Remote.getInstance()
    }

}
