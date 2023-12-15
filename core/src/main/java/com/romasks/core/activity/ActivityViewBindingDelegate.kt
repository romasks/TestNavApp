package com.romasks.core.activity

import android.view.LayoutInflater
import androidx.annotation.MainThread
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified T : ViewBinding> viewBinding(noinline inflatingFunction: (LayoutInflater) -> T) =
    ActivityViewBindingDelegate(inflatingFunction)

class ActivityViewBindingDelegate<T : ViewBinding>(
    private val inflateFunction: (LayoutInflater) -> T
) : ReadOnlyProperty<AppCompatActivity, T>, DefaultLifecycleObserver {

    private var binding: T? = null

    override fun onDestroy(owner: LifecycleOwner) {
        binding = null
        super.onDestroy(owner)
    }

    @MainThread
    override fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): T {
        return binding ?: inflateFunction
            .invoke(thisRef.layoutInflater)
            .apply { binding = this }
    }
}
