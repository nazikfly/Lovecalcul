package com.geektech.lovecalcul.di
import android.content.Context
import androidx.room.Room
import com.geektech.lovecalcul.local.Preference
import com.geektech.lovecalcul.local.room.AppDataBase
import com.geektech.lovecalcul.local.room.LoveDao
import com.geektech.lovecalcul.model.LoveApi
import com.google.android.datatransport.runtime.dagger.Module
import com.google.android.datatransport.runtime.dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@dagger.Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)

    }

    @Provides
    fun providePrefs(@ApplicationContext context: Context): Preference {
        return Preference(context)
    }

    @Singleton
    @Provides
    fun provideAppDataBase(@ApplicationContext context: Context): AppDataBase {

        return Room.databaseBuilder(context, AppDataBase::class.java, "database")
            .allowMainThreadQueries().fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideHistoryDao(appDataBase: AppDataBase): LoveDao {
        return appDataBase.loveDao()
    }
}




