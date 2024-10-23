package br.unisanta.arquitetura.viewmodel

import androidx.lifecycle.ViewModel
import br.unisanta.arquitetura.model.User

class LoginViewModel: ViewModel() {
    private val users = mutableListOf<User>()

    fun logar(login:String, pass:String):String{
        val user = users.find { it.login ==login&&it.pass == pass }
        if (user!=null){
            return "Bem vindo!"
        }else {
            return "Não está cadastrado!"
        }
    }

    fun cadastrar(login:String, pass:String):String{
        val user = User(login,pass)
        users.add(user)
        return "Cadastrado!"
    }

}
