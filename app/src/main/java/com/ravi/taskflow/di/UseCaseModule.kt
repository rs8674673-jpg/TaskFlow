package com.ravi.taskflow.di

import com.ravi.taskflow.domain.repository.TaskRepository
import com.ravi.taskflow.domain.usecase.GetTasksUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetTasksUseCase(
        repository: TaskRepository
    ): GetTasksUseCase {
        return GetTasksUseCase(repository)
    }
}
