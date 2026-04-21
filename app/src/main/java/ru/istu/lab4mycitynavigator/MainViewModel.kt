package ru.istu.lab4mycitynavigator

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var lastBottomItemId: Int = R.id.homeFragment
    var reopenDrawerAfterRotation: Boolean = false
}
