package br.com.fundatec.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.login.data.remote.LoginDataSource
import br.com.fundatec.login.data.remote.LoginDataSourceImpl
import kotlinx.coroutines.launch

class LoginViewModel(private val loginDataSource: LoginDataSource) : ViewModel() {

    private val state = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = state

    fun validateUserInput(email: String?, password: String?) {
        viewModelScope.launch {
            state.value = ViewState.ShowLoading
            if (!email.isNullOrEmpty() && !password.isNullOrEmpty()) {
                val user = loginDataSource.login(email, password)
                if (user.get() != null) {
                    state.value = ViewState.ShowHome
                } else {
                    state.value = ViewState.ShowErrorApiLogin
                }
            } else {
                state.value = ViewState.ShowErrorEmptyFileds
            }
        }
    }
}

sealed class ViewState {
    object ShowHome : ViewState()
    object ShowLoading : ViewState()
    object ShowErrorEmptyFileds : ViewState()
    object ShowErrorApiLogin : ViewState()
}
