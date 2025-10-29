package com.example.animeapp.StartingPage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.animeapp.Data.ValidateLogin

@Composable
fun LoginPage(navController: NavController){
    Scaffold { innerPadding ->
        LoginScaffold(innerPadding, navController)
    }
}

@Composable
fun LoginScaffold(
    innerPaddingValues: PaddingValues,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPaddingValues)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Sign in",
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(40.dp))

        var userEmail by rememberSaveable{ mutableStateOf("") }
        var userPass by rememberSaveable { mutableStateOf("") }
        var passwordVisible by rememberSaveable { mutableStateOf(false) }

        EmailTextField(
            userEmail,
            onEmailChange = {userEmail = it},
            modifier = Modifier
        )
        PasswordTextField(
            userPass,
            onPasswordChange = {userPass = it},
            passVisiblity = passwordVisible,
            onEyeClick = {passwordVisible = !passwordVisible},
            modifier = Modifier
        )
        LoginButton(
            onClick = {navController.navigate("MainScreen")},
            email = userEmail,
            pass = userPass
        )
        RegisterLink(navController)
    }
}

@Composable
fun EmailTextField(
    userEmail: String,
    onEmailChange: (String) -> Unit,
    modifier: Modifier = Modifier
){
    OutlinedTextField(
        value = userEmail,
        singleLine = true,
        onValueChange = onEmailChange,
        label = { Text(text = "Email") },
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp)
    )
}

@Composable
fun PasswordTextField(
    userPass: String,
    onPasswordChange: (String) -> Unit,
    passVisiblity: Boolean,
    onEyeClick: () -> Unit,
    modifier: Modifier = Modifier
){
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp),
        value = userPass,
        singleLine = true,
        onValueChange = onPasswordChange,
        label = {Text(text = "Password")},
        visualTransformation = if(passVisiblity)
            VisualTransformation.None
        else
            PasswordVisualTransformation(),

        trailingIcon = {
            val image = if(passVisiblity)
                Icons.Default.Visibility
            else
                Icons.Default.VisibilityOff

            IconButton(onClick = onEyeClick) {
                Icon(imageVector = image, contentDescription = null)
            }
        }
    )
}

@Composable
fun LoginButton(
    onClick: () -> Unit,
    email: String,
    pass: String,
    modifier: Modifier = Modifier
){
    Button(
        onClick = if(ValidateLogin( email, pass)){
            onClick
        }else{{}},
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp)
            .padding(top = 20.dp, bottom = 8.dp),
        contentPadding = PaddingValues(18.dp),
        shape = MaterialTheme.shapes.small
    ) {
        Text(
            text = "Login",
            fontSize = 18.sp
        )
    }
}

@Composable
fun RegisterLink(navController: NavController){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Don't have an account? ",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Register",
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.clickable {
                // Handle navigation to Register Screen
                navController.navigate("register")
            }
        )
    }
}

