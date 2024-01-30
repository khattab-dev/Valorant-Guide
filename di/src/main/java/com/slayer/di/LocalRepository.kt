package com.slayer.di

import android.content.Context
import androidx.room.Room
import com.slayer.data.local.dao.AgentsDao
import com.slayer.data.local.dao.GunsBuddyDao
import com.slayer.data.local.dao.MapsDao
import com.slayer.data.local.dao.PlayerCardsDao
import com.slayer.data.local.dao.RanksDao
import com.slayer.data.local.dao.SpraysDao
import com.slayer.data.local.dao.WeaponsDao
import com.slayer.data.local.databases.ValorantGuideDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalRepository {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ValorantGuideDatabase {
        return Room.databaseBuilder(
            context,
            ValorantGuideDatabase::class.java,
            "valorant_guide_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideAgentsDao(
        valorantGuideDatabase: ValorantGuideDatabase
    ): AgentsDao = valorantGuideDatabase.agentDao()

    @Provides
    @Singleton
    fun provideBuddiesDao(
        valorantGuideDatabase: ValorantGuideDatabase
    ): GunsBuddyDao = valorantGuideDatabase.buddyDao()

    @Provides
    @Singleton
    fun provideMapsDao(
        valorantGuideDatabase: ValorantGuideDatabase
    ): MapsDao = valorantGuideDatabase.mapsDao()

    @Provides
    @Singleton
    fun provideCardDao(
        valorantGuideDatabase: ValorantGuideDatabase
    ): PlayerCardsDao = valorantGuideDatabase.playerCardDao()

    @Provides
    @Singleton
    fun provideRanksDao(
        valorantGuideDatabase: ValorantGuideDatabase
    ): RanksDao = valorantGuideDatabase.rankDao()

    @Provides
    @Singleton
    fun provideSpraysDao(
        valorantGuideDatabase: ValorantGuideDatabase
    ): SpraysDao = valorantGuideDatabase.sprayDao()

    @Provides
    @Singleton
    fun provideWeaponsDao(
        valorantGuideDatabase: ValorantGuideDatabase
    ): WeaponsDao = valorantGuideDatabase.weaponDao()
}