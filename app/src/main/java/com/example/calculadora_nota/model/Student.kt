package com.example.calculadora_nota.model

// Data class que representa o aluno
// Guarda o nome e uma lista MUTÁVEL de notas (MutableList<Double>)

data class Student (
    var name: String = "",
    val grades: MutableList<Double> = mutableListOf()
) {

    // Função para calcular a média aritmética das notas
    fun calculateAverage(): Double {

        // se não tiver nenhuma nota, evita erro e retorna 0.0
        if (grades.isEmpty()) return 0.0

        // average(0 é uma função Kotlin stdlib que calcula a média da lista
        return grades.average()
    }

    // Função que devolve o STATUS do aluno de acordo com a média
    fun getStatus(): String {
        val avg = calculateAverage()

        // Regras de atividade:
        // Reprovado -> MÉDIA < 6.0
        // Aprovado -> 0.6 <= média < 9.0
        // Ótimo Aproveitamento -> média >= 9.0
        return when {
            avg < 6.0 -> "Reprovado"
            avg < 9.0 -> "Aprovado"
            else -> "Ótimo Aproveitamento"
        }
    }
}