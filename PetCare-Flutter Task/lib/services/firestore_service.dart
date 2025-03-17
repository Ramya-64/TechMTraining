import 'package:cloud_firestore/cloud_firestore.dart';

class FirestoreService {
  final CollectionReference usersCollection = FirebaseFirestore.instance.collection('users');
  final CollectionReference skillsCollection = FirebaseFirestore.instance.collection('skills');

  Future<void> addUser(String uid, String name, String email) async {
    await usersCollection.doc(uid).set({
      'name': name,
      'email': email,
      'createdAt': Timestamp.now(),
    });
  }

  Future<void> addSkill(String userId, String skill, String description) async {
    await skillsCollection.add({
      'userId': userId,
      'skill': skill,
      'description': description,
      'timestamp': Timestamp.now(),
    });
  }

  Stream<QuerySnapshot> getSkills() {
    return skillsCollection.orderBy('timestamp', descending: true).snapshots();
  }
}
