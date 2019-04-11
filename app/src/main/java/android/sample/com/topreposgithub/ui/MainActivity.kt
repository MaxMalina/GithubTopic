package android.sample.com.topreposgithub.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

import android.os.Bundle
import android.sample.com.topreposgithub.R
import android.sample.com.topreposgithub.databinding.MainActivityBinding
import android.sample.com.topreposgithub.viewmodels.RepoViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class MainActivity: AppCompatActivity() {

    private lateinit var binding:MainActivityBinding
    private var viewModel: RepoViewModel? = null
    private val TOPIC = "topic:android"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)

        viewModel = ViewModelProviders.of(this).get(RepoViewModel::class.java)
        viewModel!!.fetchRepos(TOPIC).observe(this, Observer {
            binding.recycler.layoutManager = LinearLayoutManager(this.applicationContext)
            binding.recycler.adapter = RepoAdapter(it)
        })
    }
}
