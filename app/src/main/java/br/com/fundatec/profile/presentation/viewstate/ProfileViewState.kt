package br.com.fundatec.profile.presentation.viewstate

sealed class ProfileViewState {
    object Loading : ProfileViewState()
    object ShowErrorRequestMessage : ProfileViewState()
    object OnSuccess : ProfileViewState()
}
