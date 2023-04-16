package br.com.fundatec.di

import br.com.fundatec.login.data.remote.LoginDataSource
import br.com.fundatec.login.data.remote.LoginDataSourceImpl
import br.com.fundatec.login.presentation.LoginViewModel
import br.com.fundatec.profile.data.repository.UserRepository
import br.com.fundatec.profile.data.repository.UserRepositoryImpl
import br.com.fundatec.profile.domain.usecase.UserUseCase
import br.com.fundatec.profile.domain.usecase.UserUseCaseImpl
import br.com.fundatec.profile.presentation.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.bind
import org.koin.dsl.module

val loginModule = module {
    factoryOf(::LoginDataSourceImpl) { bind<LoginDataSource>() }
    viewModelOf(::LoginViewModel)

    factoryOf(::UserRepositoryImpl) { bind<UserRepository>() }
    factoryOf(::UserUseCaseImpl) { bind<UserUseCase>() }
    viewModelOf(::ProfileViewModel)
}