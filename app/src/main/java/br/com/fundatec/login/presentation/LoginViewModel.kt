package br.com.fundatec.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.login.data.remote.LoginDataSource
import br.com.fundatec.profile.data.local.LocalDatasource
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val localDatasource: LocalDatasource by lazy {
        LocalDatasource()
    }

    private val state = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = state

    fun validateUserInput(email: String?, password: String?) {
        viewModelScope.launch {
            if (!email.isNullOrEmpty() && !password.isNullOrEmpty()) {
                val user = LoginDataSource().login(email, password)
                if (user != null) {
                    state.value = ViewState.ShowHome
                }
            }
        }
    }
}

sealed class ViewState {
    object ShowHome : ViewState()
}
