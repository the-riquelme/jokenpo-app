package com.riquelme.jokenpo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.riquelme.jokenpo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var matchesWon = 0
    private var lostMatches = 0

    private var playerChoice: String = ""
    private var cpuChoice: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun startNewGame(view: View) {
        playerChoice = ""
        cpuChoice = ""

        binding.resultText.text = getString(R.string.choose_text)
        binding.cpuChoiceText.text = getString(R.string.cpu_choice_text)
    }

    private fun updateScore() {
        binding.resultValue.text = getString(R.string.score_template, matchesWon, lostMatches)
    }

    private fun identifyWinner() {
        if (playerChoice == cpuChoice) {
            binding.resultText.text = getString(R.string.tie)
        } else if (cpuChoice == "scissors" && playerChoice == "rock") {
            binding.resultText.text = getString(R.string.player_win)
            matchesWon++
            updateScore()
        } else if (cpuChoice == "rock" && playerChoice == "paper" ) {
            binding.resultText.text = getString(R.string.player_win)
            matchesWon++
            updateScore()
        } else if (cpuChoice == "paper" && playerChoice == "scissors" ) {
            binding.resultText.text = getString(R.string.player_win)
            matchesWon++
            updateScore()
        } else {
            binding.resultText.text = getString(R.string.player_loss)
            lostMatches++
            updateScore()
        }
    }

    private fun cpuChoice() {
        val choices = arrayOf("rock", "paper", "scissors")
        cpuChoice = choices.random()

        when (cpuChoice) {
            "rock" -> {
                binding.cpuChoiceText.text = buildString {
                    append("Máquina ")
                    append(getString(R.string.selected_rock))
                }
            }
            "paper" -> {
                binding.cpuChoiceText.text = buildString {
                    append("Máquina ")
                    append(getString(R.string.selected_paper))
                }
            }
            else -> {
                binding.cpuChoiceText.text = buildString {
                    append("Máquina ")
                    append(getString(R.string.selected_scissors))
                }
            }
        }

        identifyWinner()
    }

    fun clickOnRock(view: View) {
        if (playerChoice.isEmpty()) {
            binding.selectedText.text = buildString {
                append("Jogador ")
                append(getString(R.string.selected_rock))
            }
            playerChoice = "rock"
            cpuChoice()
        }
    }

    fun clickOnPaper(view: View) {
        if (playerChoice.isEmpty()) {
            binding.selectedText.text = buildString {
                append("Jogador ")
                append(getString(R.string.selected_paper))
            }
            playerChoice = "paper"
            cpuChoice()
        }
    }

    fun clickOnScissors(view: View) {
        if (playerChoice.isEmpty()) {
            binding.selectedText.text = buildString {
                append("Jogador ")
                append(getString(R.string.selected_scissors))
            }
            playerChoice = "scissors"
            cpuChoice()
        }
    }

}