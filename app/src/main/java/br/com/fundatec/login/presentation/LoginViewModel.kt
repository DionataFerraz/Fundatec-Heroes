package br.com.fundatec.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fundatec.profile.data.local.LocalDatasource

class LoginViewModel : ViewModel() {

    private val localDatasource: LocalDatasource by lazy {
        LocalDatasource()
    }

    private val state = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = state

    fun validateUserInput(email: String?, password: String?) {
        if (!email.isNullOrEmpty() && !password.isNullOrEmpty()) {
            state.value = ViewState.ShowHome
        }
    }
}

sealed class ViewState {
    object ShowHome : ViewState()
}
