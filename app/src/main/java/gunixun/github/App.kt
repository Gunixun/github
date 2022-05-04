package gunixun.github

import android.app.Application
import android.content.Context
import gunixun.github.di.AppDependenciesComponent
import gunixun.github.di.AppDependenciesModule
import gunixun.github.di.DaggerAppDependenciesComponent


class App : Application() {

    lateinit var appDependenciesComponent: AppDependenciesComponent

    override fun onCreate() {
        super.onCreate()

        appDependenciesComponent = DaggerAppDependenciesComponent
            .builder()
            .appDependenciesModule(AppDependenciesModule(this))
            .build()
    }
}

val Context.app: App
    get() {
        return applicationContext as App
    }
