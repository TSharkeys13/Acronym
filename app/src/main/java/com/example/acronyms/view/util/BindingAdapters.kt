package com.example.acronyms.view.util

import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.acronyms.view.AcronymScreenState
import com.example.acronyms.view.LongformAdapter
import com.google.android.material.snackbar.Snackbar

@BindingAdapter("android:updateState")
fun RecyclerView.updateState(state: AcronymScreenState) {
    adapter?.apply {
        (this as LongformAdapter).submitList(state.response)
    }
}

@BindingAdapter("android:showError")
fun ViewGroup.showError(state: AcronymScreenState) {
    state.errorTextId?.let {
        Snackbar.make(this, state.errorTextId, Snackbar.LENGTH_SHORT).show()
    }
}
