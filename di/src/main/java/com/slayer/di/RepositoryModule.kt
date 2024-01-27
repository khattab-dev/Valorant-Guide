package com.slayer.di

import com.slayer.data.AgentsRepositoryImpl
import com.slayer.domain.AgentsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAgentsRepo(agentsRepositoryImpl: AgentsRepositoryImpl) : AgentsRepository
}