package br.com.fundatec.login.domain.model


sealed class ErrorModel {
    object ErrorLogin : ErrorModel()
}