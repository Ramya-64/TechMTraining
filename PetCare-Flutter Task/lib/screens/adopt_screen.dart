import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';
import 'package:firebase_database/firebase_database.dart';


class AdoptScreen extends StatefulWidget {
  final String petName;
  final String petImage;

  const AdoptScreen({required this.petName, required this.petImage});

  @override
  _AdoptScreenState createState() => _AdoptScreenState();
}

class _AdoptScreenState extends State<AdoptScreen> {
  final _formKey = GlobalKey<FormState>();
  String name = '';
  String email = '';
  String phone = '';
  String address = '';


void _submitForm() async {
  if (_formKey.currentState!.validate()) {
    _formKey.currentState!.save();

    try {
      await FirebaseFirestore.instance.collection("adoptions").add({
        "name": name,
        "email": email,
        "phone": phone,
        "address": address,
        "Adopted petName": widget.petName,
      });

      print("✅ Adoption data uploaded successfully!"); // Debugging line

      // Show success dialog
      showDialog(
        context: context,
        builder: (context) => AlertDialog(
          title: Text("Application Submitted 🎉"),
          content: Text("Thank you, $name! Your adoption request for ${widget.petName} has been submitted."),
          actions: [
            TextButton(
              onPressed: () {
                Navigator.of(context).popUntil((route) => route.isFirst);
              },
              child: Text("OK"),
            ),
          ],
        ),
      );
    } catch (error) {
      print("❌ Firebase error: $error"); // Debugging line

      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text("Failed to submit. Please try again.")),
      );
    }
  }
}



  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Adopt ${widget.petName}")),
      body: SingleChildScrollView(
        padding: EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            Hero(
              tag: widget.petImage,
              child: Image.asset(widget.petImage, height: 200, fit: BoxFit.cover),
            ),
            SizedBox(height: 20),
            Text(
              "Fill in your details to adopt ${widget.petName}",
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 10),
            Form(
              key: _formKey,
              child: Column(
                children: [
                  TextFormField(
                    decoration: InputDecoration(labelText: "Full Name"),
                    validator: (value) =>
                        value!.isEmpty ? "Please enter your name" : null,
                    onSaved: (value) => name = value!,
                  ),
                  TextFormField(
                    decoration: InputDecoration(labelText: "Email"),
                    validator: (value) =>
                        value!.isEmpty || !value.contains("@")
                            ? "Enter a valid email"
                            : null,
                    onSaved: (value) => email = value!,
                  ),
                  TextFormField(
                    decoration: InputDecoration(labelText: "Phone Number"),
                    keyboardType: TextInputType.phone,
                    validator: (value) =>
                        value!.isEmpty ? "Enter your phone number" : null,
                    onSaved: (value) => phone = value!,
                  ),
                  TextFormField(
                    decoration: InputDecoration(labelText: "Address"),
                    validator: (value) =>
                        value!.isEmpty ? "Enter your address" : null,
                    onSaved: (value) => address = value!,
                  ),
                  SizedBox(height: 20),
                  ElevatedButton(
                    onPressed: _submitForm,
                    child: Text("Submit Application 📝"),
                    style: ElevatedButton.styleFrom(
                      backgroundColor: Colors.green,
                      padding: EdgeInsets.symmetric(horizontal: 20, vertical: 12),
                      textStyle: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
                    ),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
