package com.example.labo7.Database.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.labo7.Database.DAOS.GitHubRepoDAO
import com.example.labo7.Database.Entities.GitHubRepo

class GitHubRepository(private  val repoDAO: GitHubRepoDAO) {

    fun getAll():LiveData<List<GitHubRepo>> = repoDAO.getAll()

    fun nuke() = repoDAO.nukeTable()

    @WorkerThread
    suspend fun insert(repo : GitHubRepo){
        repoDAO.insert(repo)
    }
}