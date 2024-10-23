package br.unisanta.arquitetura.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.unisanta.arquitetura.databinding.ActivityProfileBinding
//import coil.load

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Carregar imagem do perfil
        //binding.imgProfile.load("https://example.com/user/profile.jpg") {
            //placeholder(R.drawable.ic_launcher_foreground) // imagem de placeholder
            //error(R.drawable.ic_launcher_foreground) // imagem em caso de erro
       // }

        // Preencher os dados do usuário
        binding.edtName.setText("Nome do Usuário")
        binding.edtEmail.setText("email@example.com")

        // Listener para salvar as alterações
        binding.btnSave.setOnClickListener {
            val name = binding.edtName.text.toString()
            val email = binding.edtEmail.text.toString()

            if (name.isNotBlank() && email.isNotBlank()) {
                // Salvar os dados (fazer a lógica de persistência)
                Toast.makeText(this, "Dados salvos com sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}