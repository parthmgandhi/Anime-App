package com.example.animeapp.Data

import android.util.Patterns

fun ValidateLogin(
    email: String,
    pass: String
): Boolean {
    val loginList = getLoginList()
    return loginList.any{it.Email.equals(email) && it.Password == pass}
}

fun CreateAcc(
    name: String,
    email: String,
    pass: String,
    rePass: String
): Boolean {
    if( (name.isNotEmpty()) && (email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) && (pass.isNotEmpty() && rePass.isNotEmpty() && pass == rePass)){
        users.add(RegisterData(name = name, email = email, pass = pass))
        return true
    }
    return false
}