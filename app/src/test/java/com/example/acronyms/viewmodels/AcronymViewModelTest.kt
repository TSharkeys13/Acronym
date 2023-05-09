package com.example.acronyms.viewmodels

import com.example.acronyms.models.AcronymRepository
import com.example.acronyms.util.CoroutinesTestExtension
import com.example.acronyms.util.InstantTaskExecutorExtension
import com.example.acronyms.viewModels.AcronymViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.RegisterExtension

@OptIn(ExperimentalCoroutinesApi::class)
@ExtendWith(InstantTaskExecutorExtension::class)
internal class AcronymViewModelTest {
    private val repo = mockk<AcronymRepository>()
    private val acronymVM = AcronymViewModel(repo)

    @RegisterExtension
    private val extension = CoroutinesTestExtension()

    @Test
    fun getWordsFromAcronym() = runTest(extension.dispatcher) {
        // given
        val initials = "tia"
        val expected = listOf("thanks in advance")
        coEvery { repo.getWordsFromAcronym(initials) } coAnswers { expected }

        // when
        acronymVM.input.value = "tia"
        acronymVM.getWordsFromAcronym()

        // then
        Assertions.assertFalse(acronymVM.state.value?.isLoading ?: true)
        Assertions.assertEquals(expected, acronymVM.state.value?.response)
    }
}
