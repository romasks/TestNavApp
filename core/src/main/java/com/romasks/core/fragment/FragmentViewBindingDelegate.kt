package com.romasks.core.fragment

import android.view.View
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified T : ViewBinding> Fragment.viewBinding(noinline bindFunction: (View) -> T) =
    FragmentViewBindingDelegate(this, bindFunction)

class FragmentViewBindingDelegate<T : ViewBinding>(
    private val fragment: Fragment,
    private val bindFunction: (View) -> T
) : ReadOnlyProperty<Fragment, T>, DefaultLifecycleObserver {

    private var binding: T? = null

    override fun onDestroy(owner: LifecycleOwner) {
        binding = null
        owner.lifecycle.removeObserver(this)
        super.onDestroy(owner)
    }

    @MainThread
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        if (binding == null) {
            binding = bindFunction.invoke(thisRef.requireView())
            fragment.viewLifecycleOwner.lifecycle.addObserver(this)
        }
        return binding!!
    }
}
