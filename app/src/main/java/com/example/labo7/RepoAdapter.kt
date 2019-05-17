package com.example.labo7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.labo7.Database.Entities.GitHubRepo
import kotlinx.android.synthetic.main.repo_cardview.view.*

class RepoAdapter(var repos : List<GitHubRepo>):RecyclerView.Adapter<RepoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repo_cardview,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return repos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(repos[position])
    }

    fun updateList(newRepos : List<GitHubRepo>){
        this.repos = newRepos
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){
        fun bind(repo:GitHubRepo) = with(itemView){
            tv_repo_name.text = repo.name
        }
    }
}