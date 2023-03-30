package br.com.fundatec.di

import br.com.fundatec.login.data.remote.LoginDataSource
import br.com.fundatec.login.data.remote.LoginDataSourceImpl
import br.com.fundatec.login.presentation.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.bind
import org.koin.dsl.module

val loginModule = module {
    factoryOf(::LoginDataSourceImpl) { bind<LoginDataSource>() }
    viewModelOf(::LoginViewModel)
}