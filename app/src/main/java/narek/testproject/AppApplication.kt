package narek.testproject

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import java.lang.ref.WeakReference

@HiltAndroidApp
class AppApplication : Application() {

    companion object {

        private lateinit var weakContext: WeakReference<Context>

        fun getContext(): Context {
            return weakContext.get()!!
        }
    }
}