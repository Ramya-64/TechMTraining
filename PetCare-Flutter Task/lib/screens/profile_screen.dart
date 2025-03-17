import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:shared_preferences/shared_preferences.dart';
import '../providers/favorite_provider.dart';
import '../models/pet_model.dart';
import 'package:firebase_database/firebase_database.dart';

class ProfileScreen extends StatefulWidget {
  final String username;
  final String email;

  ProfileScreen({required this.username, required this.email});

  @override
  _ProfileScreenState createState() => _ProfileScreenState();
}

class _ProfileScreenState extends State<ProfileScreen> {
  TextEditingController phoneController = TextEditingController();
  String? selectedCountry;
  List<String> registeredEvents = [];
  bool isPhoneEntered = false;

  final List<String> countries = [
    "United States", "India", "Canada", "Australia", "United Kingdom",
    "Germany", "France", "Italy", "Brazil", "Japan", "China", "South Africa", "Russia"
  ];

  Future<void> _loadSavedDetails() async {
  SharedPreferences prefs = await SharedPreferences.getInstance();

  // Check if username and email are saved (i.e., user is logged in)
  String? savedUsername = prefs.getString('username');
  String? savedEmail = prefs.getString('email');

  if (savedUsername == null || savedEmail == null) {
    // Navigate back to login if user details are missing
    Navigator.pushReplacementNamed(context, '/login');
    return;
  }

  setState(() {
    phoneController.text = prefs.getString('phoneNumber') ?? "";
    selectedCountry = prefs.getString('selectedCountry');
    registeredEvents = prefs.getStringList('registeredEvents') ?? [];
    isPhoneEntered = phoneController.text.isNotEmpty && selectedCountry != null;
  });
}


  // Save phone number and country when updated
  Future<void> _saveDetails() async {
  SharedPreferences prefs = await SharedPreferences.getInstance();
  await prefs.setString('phoneNumber', phoneController.text);
  if (selectedCountry != null) {
    await prefs.setString('selectedCountry', selectedCountry!);
  }
  await prefs.setBool('isLoggedIn', true);  // Mark user as logged in
  setState(() {
    isPhoneEntered = phoneController.text.isNotEmpty && selectedCountry != null;
  });
}


  // Logout with confirmation
 Future<void> _logout() async {
  SharedPreferences prefs = await SharedPreferences.getInstance();
  bool isLoggedIn = prefs.getBool('isLoggedIn') ?? false;

  if (!isLoggedIn) {
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(content: Text("You are not logged in!")),
    );
    return;
  }

  bool confirmLogout = await _showLogoutDialog();
  if (confirmLogout) {
    await prefs.clear();
    await prefs.setBool('isLoggedIn', false); // Ensure login state resets
    setState(() {
      phoneController.clear();
      selectedCountry = null;
      registeredEvents.clear();
      isPhoneEntered = false;
    });
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(content: Text("Logged out successfully!")),
    );
  }
}


  // Show logout confirmation dialog
  Future<bool> _showLogoutDialog() async {
    return await showDialog(
          context: context,
          builder: (context) => AlertDialog(
            title: Text("Confirm Logout"),
            content: Text("Are you sure you want to log out?"),
            actions: [
              TextButton(
                onPressed: () => Navigator.pop(context, false),
                child: Text("Cancel"),
              ),
              TextButton(
                onPressed: () => Navigator.pop(context, true),
                child: Text("Logout", style: TextStyle(color: Colors.red)),
              ),
            ],
          ),
        ) ??
        false;
  }

  // Adopt pet and save details in Firebase
  Future<void> adoptPet(Pet pet) async {
    DatabaseReference ref = FirebaseDatabase.instance.ref("adopted_pets");

    await ref.push().set({
      "pet_name": pet.name,
      "breed": pet.breed,
      "age": pet.age,
      "image": pet.image,
      "adopted_by": widget.username,
      "email": widget.email,
    });

    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(content: Text("${pet.name} adopted successfully!")),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.username), // Username displayed in AppBar
        backgroundColor: Colors.blue.shade900,
        actions: [
          IconButton(
            icon: Icon(Icons.logout),
            onPressed: _logout, // Logout button
          ),
        ],
      ),
      body: Padding(
        padding: EdgeInsets.all(16),
        child: SingleChildScrollView(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              // User Details
              Text("Username: ${widget.username}",
                  style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
              SizedBox(height: 10),
              Text("Email: ${widget.email}",
                  style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
              SizedBox(height: 20),

              // Show input fields only if phone number is not entered
              if (!isPhoneEntered) ...[
                // Phone Number Input
                TextField(
                  controller: phoneController,
                  keyboardType: TextInputType.phone,
                  decoration: InputDecoration(
                    labelText: "Enter Phone Number",
                    border: OutlineInputBorder(),
                  ),
                  onChanged: (value) => _saveDetails(),
                ),
                SizedBox(height: 20),

                // Country Dropdown
                DropdownButtonFormField<String>(
                  value: selectedCountry,
                  decoration: InputDecoration(border: OutlineInputBorder()),
                  hint: Text("Select Country"),
                  items: countries.map((country) {
                    return DropdownMenuItem(
                      value: country,
                      child: Text(country),
                    );
                  }).toList(),
                  onChanged: (value) {
                    setState(() {
                      selectedCountry = value;
                    });
                    _saveDetails();
                  },
                ),
                SizedBox(height: 30),
              ],

              // Display Entered Details
              Text("Phone Number: ${phoneController.text}",
                  style: TextStyle(fontSize: 18)),
              Text("Country: ${selectedCountry ?? "Not Selected"}",
                  style: TextStyle(fontSize: 18)),
              SizedBox(height: 30),

              // Registered Events Section
              Text("Registered Events", style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold)),
              SizedBox(height: 10),
              registeredEvents.isEmpty
                  ? Text("No registered events yet.", style: TextStyle(fontSize: 16, color: Colors.grey))
                  : Column(
                      children: registeredEvents.map((event) {
                        return Card(
                          shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
                          elevation: 4,
                          margin: EdgeInsets.symmetric(vertical: 10),
                          child: ListTile(
                            leading: Icon(Icons.event, color: Colors.blue.shade900),
                            title: Text(event, style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
                          ),
                        );
                      }).toList(),
                    ),

              SizedBox(height: 30),

              // Favorite Pets Section
              Text("Favorite Pets", style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold)),
              SizedBox(height: 10),

              Consumer<FavoriteProvider>(
                builder: (context, favoriteProvider, child) {
                  final favoritePets = favoriteProvider.favoritePets;

                  if (favoritePets.isEmpty) {
                    return Text("No favorite pets yet.", style: TextStyle(fontSize: 16, color: Colors.grey));
                  }

                  return Column(
                    children: favoritePets.map((pet) {
                      return Card(
                        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
                        elevation: 4,
                        margin: EdgeInsets.symmetric(vertical: 10),
                        child: ListTile(
                          leading: ClipRRect(
                            borderRadius: BorderRadius.circular(8),
                            child: Image.asset(
                              pet.image,
                              width: 50,
                              height: 50,
                              fit: BoxFit.cover,
                            ),
                          ),
                          title: Text(pet.name, style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
                          subtitle: Text("${pet.breed} • ${pet.age} years old"),
                          trailing: Row(
                            mainAxisSize: MainAxisSize.min,
                            children: [
                              IconButton(
                                icon: Icon(Icons.favorite, color: Colors.red),
                                onPressed: () {
                                  favoriteProvider.toggleFavorite(pet);
                                },
                              ),
                              IconButton(
                                icon: Icon(Icons.pets, color: Colors.green),
                                onPressed: () {
                                  adoptPet(pet); // Adopt function
                                },
                              ),
                            ],
                          ),
                        ),
                      );
                    }).toList(),
                  );
                },
              ),
            ],
          ),
        ),
      ),
    );
  }
}
