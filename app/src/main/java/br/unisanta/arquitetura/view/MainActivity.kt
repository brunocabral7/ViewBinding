package br.unisanta.arquitetura.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.unisanta.arquitetura.databinding.ActivityMainBinding
import br.unisanta.arquitetura.viewmodel.LoginViewModel

class MainActivity : AppCompatActivity() {
    // View binding para o layout da Activity Main
    private lateinit var binding: ActivityMainBinding

    // Instância do ViewModel
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicializando o binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Botão para login
        binding.btnEntrar.setOnClickListener {
            val login = binding.edtUser.text.toString()
            val senha = binding.edtPass.text.toString()

            val retorno = loginViewModel.logar(login, senha)

            if (retorno == "Bem vindo!") {
                // Navegar para a tela de perfil se o login for bem-sucedido
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            } else {
                // Mostrar mensagem de erro
                Toast.makeText(this, "$retorno", Toast.LENGTH_SHORT).show()
            }
        }

        // Botão para cadastrar novo usuário
        binding.btnSalvar.setOnClickListener {
            val login = binding.edtUser.text.toString()
            val senha = binding.edtPass.text.toString()

            val retorno = loginViewModel.cadastrar(login, senha)
            Toast.makeText(this, "$retorno", Toast.LENGTH_SHORT).show()
        }
    }
}