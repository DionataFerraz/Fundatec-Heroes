package br.com.fundatec.profile.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.login.domain.model.ErrorModel
import br.com.fundatec.profile.domain.model.UserModel
import br.com.fundatec.profile.domain.usecase.UserUseCase
import br.com.fundatec.profile.presentation.viewstate.ProfileViewState
import br.com.fundatec.webservice.Result
import kotlinx.coroutines.launch

class ProfileViewModel(private val userUseCase: UserUseCase) : ViewModel() {
    private val viewState: MutableLiveData<ProfileViewState> = MutableLiveData()
    val state: LiveData<ProfileViewState> = viewState

    fun saveUser(
        name: String?,
        email: String?,
        password: String?,
    ) {
        viewModelScope.launch {
            viewState.value = ProfileViewState.Loading
            if (!name.isNullOrBlank() && !email.isNullOrBlank() && !password.isNullOrBlank()) {
                val result = userUseCase.createUser(
                    UserModel(
                        name = name,
                        email = email,
                        password = password,
                    )
                )
                onResult(result)
            } else {
                // TODO: Criar cenário de viewstate que eu possa validar campo a campo
            }
        }
    }

    private fun onResult(result: Result<Unit, ErrorModel>) {
        when(result){
            is Result.Success -> viewState.value = ProfileViewState.OnSuccess
            is Result.Error -> viewState.value = ProfileViewState.ShowErrorRequestMessage
        }
    }
}