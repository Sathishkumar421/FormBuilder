package com.example.formbuilder.di

import androidx.fragment.app.FragmentActivity
import com.example.formbuilder.resultRegistry.LifeCycleResultObserver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@InstallIn(ActivityComponent::class)
@Module
object ResultObserverModule {

    @Provides
    @ActivityScoped
    fun provideObserver(activity: FragmentActivity): LifeCycleResultObserver {
        return LifeCycleResultObserver(activity.activityResultRegistry)
    }
}