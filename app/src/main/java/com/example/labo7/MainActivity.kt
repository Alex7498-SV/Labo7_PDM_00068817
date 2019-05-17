package com.example.labo7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labo7.Database.Entities.GitHubRepo
import com.example.labo7.Database.ViewModels.GitHubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: RepoAdapter
    lateinit var viewModel:GitHubRepoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun bind(){
        adapter = RepoAdapter(ArrayList())
        viewModel = ViewModelProviders.of(this).get(GitHubRepoViewModel::class.java)
        rv_repos.apply{
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        viewModel.getAll().observe(this, Observer {
            adapter.updateList(it)
        })

        btn_add.setOnClickListener {
            viewModel.insert(GitHubRepo(et_repo_name.text.toString()))
        }
    }


}
