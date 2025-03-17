import 'package:cloud_firestore/cloud_firestore.dart';

class UserModel {
  String id;
  String email;
  DateTime createdAt;

  UserModel({required this.id, required this.email, required this.createdAt});

  // Convert Firestore data to User object
  factory UserModel.fromJson(Map<String, dynamic> json, String id) {
    return UserModel(
      id: id,
      email: json['email'],
      createdAt: (json['createdAt'] as Timestamp).toDate(), // ✅ Fix: Import Timestamp
    );
  }

  // Convert User object to Firestore data
  Map<String, dynamic> toJson() {
    return {
      "email": email,
      "createdAt": Timestamp.fromDate(createdAt), // ✅ Ensure Firestore stores it correctly
    };
  }
}
