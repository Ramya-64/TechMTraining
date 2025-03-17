import 'package:flutter/material.dart';
import 'package:firebase_auth/firebase_auth.dart';
import '../services/auth_service.dart';

class LoginScreen extends StatefulWidget {
  @override
  _LoginScreenState createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  final AuthService _authService = AuthService();

  void _signIn() async {
  try {
    User? user = await _authService.signInWithGoogle();
    if (user != null) {
      print("Logged in as: ${user.email}");
      Navigator.pushReplacementNamed(context, '/home'); // Ensure navigation
    } else {
      print("Login failed");
    }
  } catch (e) {
    print("Error: $e");
  }
}


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Skill Swap - Login")),
      body: Center(
        child: ElevatedButton(
          onPressed: _signIn,
          child: Text("Sign in with Google"),
        ),
      ),
    );
  }
}
