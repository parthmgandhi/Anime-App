package com.example.animeapp.Data

data class LoginData(
    val Email:String,
    val Password:String
)

data class RegisterData(
    val name: String,
    val email: String,
    val pass: String
)

val users = mutableListOf(
    RegisterData("Admin User", "admin@example.com", "Admin@123"),
    RegisterData("John Doe", "john.doe@example.com", "JDoe2025!"),
    RegisterData("Tester Account", "tester+android@example.com", "Test@456"),
    RegisterData("Demo Account", "demo.account@example.com", "DemoPass#1")
)

fun getLoginList(): List<LoginData> {
    return users.map { LoginData(it.email, it.pass) }
}

