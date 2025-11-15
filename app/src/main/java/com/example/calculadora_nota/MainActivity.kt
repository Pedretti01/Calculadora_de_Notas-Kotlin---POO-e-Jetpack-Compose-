package com.example.calculadora_nota

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculadora_nota.ui.GradeScreen
import com.example.calculadora_nota.ui.theme.Calculadora_NotaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o conteúdo da Activity usando Jatpack Compose
        setContent {

            // Aplica o tema Material 3 gerado pelo projeto
            Calculadora_NotaTheme {

                // Surface é só um contêinre para o fundo da tela
                Surface {

                    // Chama a nosaa tela principal
                    GradeScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Calculadora_NotaTheme {
        Greeting("Android")
    }
}