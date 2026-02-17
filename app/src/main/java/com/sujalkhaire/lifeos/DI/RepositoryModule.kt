package com.sujalkhaire.lifeos.DI

import com.sujalkhaire.lifeos.Data.Local.Repository.ExpenceRepositoryImpl
import com.sujalkhaire.lifeos.Data.Local.Repository.FocusRepositoryImpl
import com.sujalkhaire.lifeos.Data.Local.Repository.HabitRepositoryImpl
import com.sujalkhaire.lifeos.Data.Local.Repository.RuleRepositoryImple
import com.sujalkhaire.lifeos.Domain.repository.ExpenceRepository
import com.sujalkhaire.lifeos.Domain.repository.HabitRepository
import com.sujalkhaire.lifeos.Domain.repository.RuleRepository
import com.sujalkhaire.lifeos.Domain.repository.focusRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun repoImpl(impl:FocusRepositoryImpl):focusRepository

    @Binds
    @Singleton
    abstract fun expenceRepoImple(impl: ExpenceRepositoryImpl):ExpenceRepository

    @Binds
    @Singleton
    abstract fun habitRepoImpl(impl: HabitRepositoryImpl):HabitRepository

    @Binds
    @Singleton
    abstract fun ruleRepoImpl(imple: RuleRepositoryImple):RuleRepository
}