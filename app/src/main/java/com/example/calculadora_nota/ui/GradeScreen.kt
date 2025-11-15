package com.example.calculadora_nota.ui



import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.calculadora_nota.model.Student

// Composable principal da Tela
@Composable
fun GradeScreen() {

    //--------------------------
    //  ESTADO DA TELA
    //--------------------------
    // Campos de entrada de texto (nome e notas)
    var nameInput by remember { mutableStateOf("") }
    var tp1Input by remember { mutableStateOf("") }
    var tp2Input by remember { mutableStateOf("") }
    var tp3Input by remember { mutableStateOf("") }

    // Campos de saída (resultado)
    // Iniciam com os valores mostrados no seu UX
    var average by remember { mutableStateOf("0.0") }
    var status by remember { mutableStateOf("Valor do Status") }

    //--------------------------
    //  LAYOUT PRINCIPAL
    //--------------------------
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        //======================================================
        // BLOCO 1 - NOME DO ALUNO
        //======================================================
        Column(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            // Rótulo "Aluno:"
            Text(
                text = "Aluno:",
                style = MaterialTheme.typography.titleMedium
            )

            // Campo de texto para digitar o nome
            OutlinedTextField(
                value = nameInput,
                onValueChange = { nameInput = it },
                placeholder = { Text("Digite seu Nome") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        //======================================================
        // BLOCO 2 - NOTAS (TP1, TP2, TP3)
        //======================================================

        // Linha com os textos "TP1:  TP2:  TP3:"
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("TP1:")
            Text("TP2:")
            Text("TP3:")
        }

        Spacer(Modifier.height(6.dp))

        // Linha com os três campos de nota
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            // Campo TP1
            OutlinedTextField(
                value = tp1Input,
                onValueChange = { tp1Input = it },
                placeholder = { Text("0.0") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 6.dp)
            )

            // Campo TP2
            OutlinedTextField(
                value = tp2Input,
                onValueChange = { tp2Input = it },
                placeholder = { Text("0.0") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 6.dp)
            )

            // Campo TP3
            OutlinedTextField(
                value = tp3Input,
                onValueChange = { tp3Input = it },
                placeholder = { Text("0.0") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 6.dp)
            )
        }

        //======================================================
        // BLOCO 3 - BOTÃO "Calcular Média"
        //======================================================
        Button(
            onClick = {
                // Conversão das Strings para Double
                val n1 = tp1Input.toDoubleOrNull()
                val n2 = tp2Input.toDoubleOrNull()
                val n3 = tp3Input.toDoubleOrNull()

                // Validação simples: nome não vazio e todas as notas válidas
                if (nameInput.isNotBlank() && n1 != null && n2 != null && n3 != null) {

                    // Cria a lista mutável de notas (MutableList<Double>)
                    val grades = mutableListOf(n1, n2, n3)

                    // Cria o objeto Student (POO)
                    val student = Student(nameInput, grades)

                    // Calcula a média usando a classe Student
                    val avg = student.calculateAverage()

                    // Atualiza o estado da tela com duas casas decimais
                    average = String.format("%.2f", avg)

                    // Atualiza o status chamando getStatus()
                    status = student.getStatus()
                } else {
                    // Caso o usuário deixe algo em branco ou digite errado
                    average = "0.0"
                    status = "Preencha o nome e as três notas corretamente."
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text("Calcular Média:")
        }

        //======================================================
        // BLOCO 4 - RESULTADO: NOTA MÉDIA
        //======================================================
        Column(
            Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Nota Média:",
                // aqui era litleMedium (não existe) -> titleMedium
                style = MaterialTheme.typography.titleMedium
            )

            // Caixa que simula o retângulo do layout
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(top = 4.dp)
                    .border(1.dp, Color.Gray) // borda cinza
                    .padding(10.dp)
            ) {
                // Texto da média em negrito
                Text(
                    text = average,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }

        //======================================================
        // BLOCO 5 - RESULTADO: STATUS
        //======================================================
        Column(
            Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Status:",
                style = MaterialTheme.typography.titleMedium
            )

            // Caixa para mostrar o valor do status
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(top = 4.dp)
                    .border(1.dp, Color.Gray)
                    .padding(10.dp)
            ) {
                Text(status)
            }
        }
    } // <- fim da Column principal
}