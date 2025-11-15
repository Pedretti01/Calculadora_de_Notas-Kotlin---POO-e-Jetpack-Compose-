Raphael Pedretti da Silva - DSM5 - 2025/2

--------------------------------------------

  Instruções:

Desenvolva uma aplicação em Kotlin que utilize Programação Orientada a Objetos (POO) e Jetpack Compose para gerenciar as notas de um aluno.

Requisitos Funcionais:


  A aplicação deve permitir ao usuário:
  
    • Cadastro de Aluno: Inserir o nome completo do aluno.
    
    • Lançamento de Notas: Inserir as três notas parciais (TP1, TP2, TP3).
    
    • Cálculo da Média: Calcular a Média Geral (aritmética) das três notas.
    
    • Avaliação de Desempenho: Exibir o status final do aluno com base na Média Geral, seguindo a lógica:
  
      ➢ Reprovado: Média < 6.0 
      ➢ Aprovado: Média ≥ 6.0 e ≤ 9.0 
      ➢ Ótimo Aproveitamento: Média > 9.0 
      

Requisitos Técnicos Obrigatórios: 

  • POO: O código deve ser estruturado usando Classes ou Data Classes para representar as entidades. 

  • Interface Gráfica (UI): Exclusivamente usar a biblioteca Jetpack Compose para construir a interface. 
  
  • Gerenciamento de Estado (State Management): O estado da aplicação (como o Aluno e suas Notas e Média) deve ser gerenciado usando as funções reativas do Compose, como remember e/ou mutableStateOf , garantindo que a UI seja atualizada automaticamente. 

  • Estrutura de Dados: Uso obrigatório de uma lista mutável (MutableList<Double>) para gerenciar as notas parciais dentro da classe do aluno. 
