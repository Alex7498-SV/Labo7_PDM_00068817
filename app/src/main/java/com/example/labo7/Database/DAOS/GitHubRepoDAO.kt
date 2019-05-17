package com.example.labo7.Database.DAOS

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.labo7.Database.Entities.GitHubRepo

@Dao
interface GitHubRepoDAO {

    @Query("SELECT * FROM repos")
    fun getAll():LiveData<List<GitHubRepo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repo:GitHubRepo)

    @Query("DELETE FROM repos")
    fun nukeTable()
}