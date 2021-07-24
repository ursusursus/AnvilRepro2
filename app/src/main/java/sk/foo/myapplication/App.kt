package sk.foo.myapplication

import android.app.Application
import android.util.Log

/**
 * Created by Vlastimil Brečka (www.vlastimilbrecka.sk)
 * on 22. 3. 2021.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val appComponent = DaggerAppComponent.factory().create(this)
    }
}