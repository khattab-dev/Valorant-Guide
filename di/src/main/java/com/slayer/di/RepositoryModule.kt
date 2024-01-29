package com.slayer.di

import com.slayer.data.repo.AgentsRepoImpl
import com.slayer.data.repo.BuddiesRepoImpl
import com.slayer.data.repo.MapsRepoImpl
import com.slayer.data.repo.WeaponsRepoImpl
import com.slayer.domain.repositories.AgentsRepository
import com.slayer.domain.repositories.BuddiesRepository
import com.slayer.domain.repositories.MapsRepository
import com.slayer.domain.repositories.WeaponsRepository
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
    abstract fun bindAgentsRepo(agentsRepoImpl: AgentsRepoImpl) : AgentsRepository

    @Binds
    @Singleton
    abstract fun bindBuddiesRepo(buddiesRepository: BuddiesRepoImpl) : BuddiesRepository

    @Binds
    @Singleton
    abstract fun bindWeaponsRepo(weaponsRepoImpl: WeaponsRepoImpl) : WeaponsRepository

    @Binds
    @Singleton
    abstract fun bindMapsRepo(mapsRepoImpl: MapsRepoImpl) : MapsRepository
}