package com.ravi.taskflow.di

import com.ravi.taskflow.data.repository.TaskRepositoryImpl
import com.ravi.taskflow.domain.repository.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTaskRepository(): TaskRepository {
        return TaskRepositoryImpl()
    }
}
