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
import com.example.animeapp.Data.CreateAcc

@Composable
fun RegisterPage(navController: NavController){
    Scaffold { innerPadding ->
        RegisterScaffold(innerPadding, navController)
    }
}

@Composable
fun RegisterScaffold(
    innerPaddingValues: PaddingValues,
    navController: NavController
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPaddingValues)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Create Account",
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(40.dp))

        var userName by rememberSaveable { mutableStateOf("") }
        var userEmail by rememberSaveable{ mutableStateOf("") }
        var userPass by rememberSaveable { mutableStateOf("") }
        var reEnterPass by rememberSaveable { mutableStateOf("") }
        var passwordVisible by rememberSaveable { mutableStateOf(false) }
        var rePassVisiblity by rememberSaveable { mutableStateOf(false) }


        RegNameTextField(
            userName,
            onNameChange = {userName = it},
            modifier = Modifier
        )
        RegEmailTextField(
            userEmail,
            onEmailChange = {userEmail = it},
            modifier = Modifier
        )
        RegPasswordTextField(
            userPass,
            onPasswordChange = {userPass = it},
            passVisiblity = passwordVisible,
            onEyeClick = {passwordVisible = !passwordVisible},
            modifier = Modifier
        )
        ReEnterPassTextField(
            reEnterPass,
            onRePassChange = {reEnterPass = it},
            rePassVisiblity =  rePassVisiblity,
            onEyeClick = {rePassVisiblity = !rePassVisiblity},
            modifier = Modifier
        )
        RegisterButton(
            onClick = {navController.navigate("Sign In")},
            name = userName,
            email = userEmail,
            pass = userPass,
            rePass = reEnterPass,
        )
        SignInLink(navController)
    }
}

@Composable
fun RegNameTextField(
    userName: String,
    onNameChange: (String) -> Unit,
    modifier: Modifier = Modifier
){
    OutlinedTextField(
        value = userName,
        singleLine = true,
        onValueChange = onNameChange,
        label = { Text(text = "Name") },
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp)
    )
}

@Composable
fun RegEmailTextField(
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
fun RegPasswordTextField(
    userPass: String,
    onPasswordChange: (String) -> Unit,
    passVisiblity: Boolean,
    onEyeClick: () -> Unit,
    modifier: Modifier = Modifier
){
    OutlinedTextField(
        modifier = modifier
            .padding(top = 15.dp)
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
fun ReEnterPassTextField(
    reEnterPass: String,
    onRePassChange: (String) -> Unit,
    rePassVisiblity: Boolean,
    onEyeClick: () -> Unit,
    modifier: Modifier = Modifier
){
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp),
        value = reEnterPass,
        singleLine = true,
        onValueChange = onRePassChange,
        label = {Text(text = "Re-Enter-Password")},
        visualTransformation = if(rePassVisiblity)
            VisualTransformation.None
        else
            PasswordVisualTransformation(),

        trailingIcon = {
            val image = if(rePassVisiblity)
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
fun RegisterButton(
    onClick: () -> Unit,
    name: String,
    email: String,
    pass: String,
    rePass: String,
    modifier: Modifier = Modifier
){
    Button(
        onClick = if(CreateAcc(name, email, pass, rePass)){
            onClick
        }else{{}},
        modifier
            .padding(top = 20.dp, bottom = 8.dp)
            .fillMaxWidth()
            .padding(horizontal = 25.dp),
        contentPadding = PaddingValues(18.dp),
        shape = MaterialTheme.shapes.small
    ) {
        Text(
            text = "Register",
            fontSize = 18.sp
        )
    }
}

@Composable
fun SignInLink(navController : NavController){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Already have an account? ",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Sign In",
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.clickable {
                // Handle navigation to Register Screen
                navController.navigate("Sign In")
            }
        )
    }
}



