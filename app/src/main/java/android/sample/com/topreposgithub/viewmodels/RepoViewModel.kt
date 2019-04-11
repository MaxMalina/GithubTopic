package android.sample.com.topreposgithub.viewmodels

import android.app.Application
import android.sample.com.topreposgithub.TopReposGithubApplication
import android.sample.com.topreposgithub.model.Repo
import android.sample.com.topreposgithub.remote.Remote
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

class RepoViewModel (application: Application) : AndroidViewModel(application) {
    private var repository : Remote = getApplication<TopReposGithubApplication>().getRemote()
    private var repoList : MediatorLiveData<List<Repo>> = MediatorLiveData()

    fun getReposList() : LiveData<List<Repo>> {
        return repoList
    }

    fun fetchRepos(topic: String) : LiveData<List<Repo>> {
        repoList.addSource(repository.fetchRepos(topic)) {
            data -> repoList.setValue(data) }
        return repoList
    }
}