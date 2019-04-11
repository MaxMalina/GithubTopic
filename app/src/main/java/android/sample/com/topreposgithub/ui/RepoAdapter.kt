package android.sample.com.topreposgithub.ui

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

import android.sample.com.topreposgithub.databinding.RepoBinding
import android.sample.com.topreposgithub.model.Repo

class RepoAdapter(private var mDataList: List<Repo>): RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    private val TOPICS_DIVIDER = " / "
    private val DEFAULT_LANGUAGE = "Unknown"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val repoBinding = RepoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepoViewHolder(repoBinding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repository = mDataList[position]
        holder.binding.repoName.text = repository.fullName
        holder.binding.repoDesc.text = repository.description
        holder.binding.repoStars.text = repository.stars.toString()

        if(repository.language != "null") {
            holder.binding.repoLanguage.text = repository.language
        } else {
            holder.binding.repoLanguage.text = DEFAULT_LANGUAGE
        }

        var strTopic = ""
        repository.topics.forEach {
            topic -> strTopic += topic + TOPICS_DIVIDER
        }

        holder.binding.repoTopics.text = strTopic

    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    inner class RepoViewHolder(val binding: RepoBinding) : RecyclerView.ViewHolder(binding.root)
}
