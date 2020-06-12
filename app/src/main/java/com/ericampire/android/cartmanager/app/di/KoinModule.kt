package com.ericampire.android.cartmanager.app.di

import android.app.Application
import androidx.room.Room
import com.ericampire.android.cartmanager.app.App
import com.ericampire.android.cartmanager.model.AppDatabase
import com.ericampire.android.cartmanager.model.dao.CartItemDao
import com.ericampire.android.cartmanager.model.dao.CategoryProductDao
import com.ericampire.android.cartmanager.model.dao.ProductDao
import com.ericampire.android.cartmanager.model.dao.ProductInCartDao
import com.ericampire.android.cartmanager.viewmodel.ProductViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val databaseModule = module {
    fun provideRoomDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, "test.db")
            .build()
    }

    fun provideProductDao(appDatabase: AppDatabase): ProductDao {
        return appDatabase.productDao
    }

    fun provideCategoryProductDao(appDatabase: AppDatabase): CategoryProductDao {
        return appDatabase.categoryProductDao
    }

    fun provideProductInCartDao(appDatabase: AppDatabase): ProductInCartDao {
        return appDatabase.productInCartDao
    }

    fun provideCartItemDao(appDatabase: AppDatabase): CartItemDao {
        return appDatabase.cartItemDao
    }

    single { provideProductDao(get()) }
    single { provideCategoryProductDao(get()) }
    single { provideProductInCartDao(get()) }
    single { provideCartItemDao(get()) }
    single { provideRoomDatabase(androidApplication()) }
}

val viewModelModule = module {
    viewModel { ProductViewModel() }
}