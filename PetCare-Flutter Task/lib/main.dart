import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:provider/provider.dart';
import 'firebase_options.dart';
import 'app.dart';
import 'providers/favorite_provider.dart'; // Import your provider

void testFirestore() async {
  try {
    await FirebaseFirestore.instance.collection("adoptions").add({
      "test_field": "Testing Firestore collection creation",
      "timestamp": FieldValue.serverTimestamp(),
    });

    print("✅ Test adoption data uploaded successfully!");
  } catch (error) {
    print("❌ Firestore test error: $error");
  }
}
void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp(
    options: DefaultFirebaseOptions.currentPlatform,
  );
  testFirestore();
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MultiProvider(
      providers: [
        ChangeNotifierProvider(create: (context) => FavoriteProvider()), // Favorite provider
      ],
      child: MaterialApp(
        debugShowCheckedModeBanner: false,
        title: 'Pet Care App',
        theme: ThemeData.light(),
        home: App(),
      ),
    );
  }
}
