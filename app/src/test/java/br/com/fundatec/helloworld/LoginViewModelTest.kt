package br.com.fundatec.helloworld

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.fundatec.login.data.remote.LoginDataSource
import br.com.fundatec.login.data.response.LoginResponse
import br.com.fundatec.login.presentation.LoginViewModel
import br.com.fundatec.login.presentation.ViewState
import br.com.fundatec.test.CoroutinesRule
import org.junit.Test
import org.junit.Assert.*
import io.mockk.mockk
import  br.com.fundatec.webservice.Result
import io.mockk.coEvery
import io.mockk.coVerify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule

@ExperimentalCoroutinesApi
class LoginViewModelTest {

    @get:Rule
    val instantTask = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesRule = CoroutinesRule()

    private val loginDataSource = mockk<LoginDataSource>()
    private val viewModel = LoginViewModel(loginDataSource)

    @Test
    fun validateViewState_returnShowErrorEmptyFields() = runTest {
        prepareScenario()
        viewModel.validateUserInput(null, null)
        coVerify(exactly = 0) { loginDataSource.login(any(), any()) }
        assertEquals(viewModel.viewState.value, ViewState.ShowErrorEmptyFileds)
    }

    @Test
    fun callLogin_verifyIsCalledLoginDataSource() = runTest {
        prepareScenario()
        viewModel.validateUserInput("email", "password")
        coVerify(exactly = 1) { loginDataSource.login(any(), any()) }
    }

    private fun prepareScenario() {
        coEvery {
            loginDataSource.login(any(), any())
        } returns Result.Success(
            LoginResponse(
                id = 1,
                name = "name",
                email = "email",
                password = "password",
            )
        )
    }
}