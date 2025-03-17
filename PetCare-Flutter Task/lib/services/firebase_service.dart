import 'package:firebase_auth/firebase_auth.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

class FirebaseService {
  final FirebaseAuth _auth = FirebaseAuth.instance;
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;

  // Sign Up User
  Future<User?> signUp(String email, String password) async {
    try {
      UserCredential userCredential = await _auth.createUserWithEmailAndPassword(email: email, password: password);
      await _firestore.collection("users").doc(userCredential.user!.uid).set({
        "email": email,
        "createdAt": DateTime.now(),
      });
      return userCredential.user;
    } catch (e) {
      print("Error: $e");
      return null;
    }
  }

  // Sign In User
  Future<User?> signIn(String email, String password) async {
    try {
      UserCredential userCredential = await _auth.signInWithEmailAndPassword(email: email, password: password);
      return userCredential.user;
    } catch (e) {
      print("Error: $e");
      return null;
    }
  }

  // Logout User
  Future<void> signOut() async {
    await _auth.signOut();
  }

  // Get Pets from Firestore
  Future<List<Map<String, dynamic>>> getPets() async {
    try {
      QuerySnapshot snapshot = await _firestore.collection("pets").get();
      return snapshot.docs.map((doc) => doc.data() as Map<String, dynamic>).toList();
    } catch (e) {
      print("Error: $e");
      return [];
    }
  }
}
