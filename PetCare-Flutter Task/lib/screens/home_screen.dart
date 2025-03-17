import 'package:flutter/material.dart';
import 'adoption_screen.dart';
import 'events_screen.dart';
import 'profile_screen.dart';
import '../widgets/pet_adoption_journey.dart';

class HomeScreen extends StatefulWidget {
  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  String? loggedInUser; 
  String? loggedInEmail; 

  void _showLoginDialog() {
    TextEditingController usernameController = TextEditingController();
    TextEditingController emailController = TextEditingController();
    TextEditingController passwordController = TextEditingController();

    showDialog(
      context: context,
      builder: (context) {
        return AlertDialog(
          title: Text("Login", style: TextStyle(fontWeight: FontWeight.bold, fontSize: 20)),
          content: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              TextField(controller: usernameController, decoration: InputDecoration(labelText: "Username")),
              TextField(controller: emailController, decoration: InputDecoration(labelText: "Email")),
              TextField(controller: passwordController, obscureText: true, decoration: InputDecoration(labelText: "Password")),
            ],
          ),
          actions: [
            TextButton(
              onPressed: () => Navigator.pop(context),
              child: Text("Cancel", style: TextStyle(color: Colors.red, fontWeight: FontWeight.bold)),
            ),
            TextButton(
              onPressed: () {
                if (usernameController.text == "ramya" &&
                    emailController.text == "ramyajaramesh@gmail.com" &&
                    passwordController.text == "R") {
                  setState(() {
                    loggedInUser = "Ramya";
                    loggedInEmail = "ramyajaramesh@gmail.com";
                  });
                  Navigator.pop(context);
                } else {
                  ScaffoldMessenger.of(context).showSnackBar(
                    SnackBar(content: Text("Invalid credentials!"), backgroundColor: Colors.red),
                  );
                }
              },
              child: Text("Login", style: TextStyle(color: Colors.green, fontWeight: FontWeight.bold)),
            ),
          ],
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    double screenWidth = MediaQuery.of(context).size.width; 
    double screenHeight = MediaQuery.of(context).size.height; 

    return Scaffold(
      backgroundColor: Colors.white,
      appBar: PreferredSize(
        preferredSize: Size.fromHeight(70),
        child: Container(
          padding: EdgeInsets.symmetric(horizontal: 16),
          decoration: BoxDecoration(
            color: Colors.blue.shade900,
            boxShadow: [BoxShadow(color: Colors.black26, blurRadius: 4, offset: Offset(0, 2))],
          ),
          child: SafeArea(
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Text(
                  "🐾 Adopt a Pet",
                  style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold, color: Colors.white),
                ),
                Row(
                  children: [
                    _buildNavButton("Adopt", AdoptionScreen()),
                    _buildNavButton("Events", EventsScreen()),
                    _buildNavButton("Profile", ProfileScreen(
                      username: loggedInUser ?? "Guest",
                      email: loggedInEmail ?? "Not Set",
                    )),
                    TextButton(
                      onPressed: _showLoginDialog,
                      child: Text(
                        loggedInUser ?? "Login",
                        style: TextStyle(color: Colors.white, fontWeight: FontWeight.bold, fontSize: 16),
                      ),
                    ),
                  ],
                ),
              ],
            ),
          ),
        ),
      ),
      body: SingleChildScrollView(
        padding: EdgeInsets.symmetric(horizontal: screenWidth * 0.05, vertical: 20),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            SizedBox(height: screenHeight * 0.03),
            Text(
              "Welcome to Adopt a Pet! 🐶🐱",
              textAlign: TextAlign.center,
              style: TextStyle(
                fontSize: screenWidth * 0.08,
                fontWeight: FontWeight.bold,
                fontStyle: FontStyle.italic,
                color: Colors.blue.shade900,
              ),
            ),
            SizedBox(height: screenHeight * 0.015),
            Text(
              "Find your perfect pet and give them a loving home.\nBrowse adoption opportunities, upcoming pet events, and more!",
              textAlign: TextAlign.center,
              style: TextStyle(fontSize: screenWidth * 0.05, color: Colors.grey.shade700, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: screenHeight * 0.04),
            Container(
              width: screenWidth * 0.9,
              padding: EdgeInsets.all(10),
              decoration: BoxDecoration(
                color: Colors.blue.shade50,
                borderRadius: BorderRadius.circular(15),
                boxShadow: [
                  BoxShadow(color: Colors.black26, blurRadius: 4, offset: Offset(0, 2)),
                ],
              ),
              child: PetAdoptionJourney(), // ✅ Responsive Adoption Journey Widget
            ),
            SizedBox(height: screenHeight * 0.02),
          ],
        ),
      ),
    );
  }

  Widget _buildNavButton(String text, Widget screen) {
    return Padding(
      padding: EdgeInsets.only(left: 8),
      child: TextButton(
        onPressed: () => Navigator.push(context, MaterialPageRoute(builder: (context) => screen)),
        child: Text(
          text,
          style: TextStyle(
            color: Colors.white,
            fontSize: 16,
            fontWeight: FontWeight.bold,
          ),
        ),
      ),
    );
  }
}
