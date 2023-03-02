package br.com.fundatec.profile.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.profile.domain.usecase.UserUsecase
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    private val usecase: UserUsecase by lazy {
        UserUsecase()
    }

    fun saveUser() {
        viewModelScope.launch {
            usecase.saveUser()
        }
    }
}