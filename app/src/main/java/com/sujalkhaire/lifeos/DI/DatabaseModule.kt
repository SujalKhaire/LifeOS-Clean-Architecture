package com.sujalkhaire.lifeos.DI

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sujalkhaire.lifeos.Data.Local.Dao.ExpenseDao
import com.sujalkhaire.lifeos.Data.Local.Dao.HabitDao
import com.sujalkhaire.lifeos.Data.Local.Dao.RuleDao
import com.sujalkhaire.lifeos.Data.Local.Dao.focusDao
import com.sujalkhaire.lifeos.Data.Local.LifeOsDatbase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(app:Application):LifeOsDatbase{
        return Room.databaseBuilder(app,LifeOsDatbase::class.java,"focus_db").build()
    }

    @Provides
    fun provideFocusDao(db:LifeOsDatbase):focusDao{
        return db.focusDao()
    }

    @Provides
    fun provideExpenceDao(db:LifeOsDatbase):ExpenseDao{
        return db.expenceDao()
    }

    @Provides
    fun provideHabitDao(db: LifeOsDatbase):HabitDao{
        return db.habitDao()
    }
    @Provides
    fun provideRuleDao(db: LifeOsDatbase):RuleDao{
        return db.ruleDao()
    }
}