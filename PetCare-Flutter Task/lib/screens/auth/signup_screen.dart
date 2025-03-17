import 'package:flutter/material.dart';

class SignupScreen extends StatelessWidget {
  final TextEditingController emailController = TextEditingController();
  final TextEditingController passwordController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Sign Up")),
      body: Padding(
        padding: EdgeInsets.all(16),
        child: Column(
          children: [
            TextField(decoration: InputDecoration(labelText: "Email"), controller: emailController),
            TextField(decoration: InputDecoration(labelText: "Password"), obscureText: true, controller: passwordController),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                Navigator.pushReplacementNamed(context, "/");
              },
              child: Text("Create Account"),
            ),
          ],
        ),
      ),
    );
  }
}
