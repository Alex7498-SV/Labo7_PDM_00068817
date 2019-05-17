package com.example.labo7.Database.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.labo7.Database.Entities.GitHubRepo
import com.example.labo7.Database.Repository.GitHubRepository
import com.example.labo7.Database.RoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GitHubRepoViewModel(app:Application):AndroidViewModel(app){

    private val repository:GitHubRepository

    init {
        val repoDAO = RoomDB.getInstance(app).repoDAO()
        repository = GitHubRepository(repoDAO)
    }

    fun getAll() : LiveData<List<GitHubRepo>> = repository.getAll()

    fun insert(repo:GitHubRepo) =viewModelScope.launch(Dispatchers.IO) {
        repository.insert(repo)
    }

    //fun nuke() = repository.nuke()
}