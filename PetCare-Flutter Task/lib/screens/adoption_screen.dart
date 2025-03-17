import 'package:flutter/material.dart';
import '../widgets/pet_card.dart';
import '../models/pet_model.dart';

class AdoptionScreen extends StatelessWidget {
  final List<Pet> pets = [
    Pet(id: "1", name: "Buddy", breed: "Golden Retriever", age: 2, image: "assets/dog1.jpg", description: "Loyal and friendly!"),
    Pet(id: "2", name: "Luna", breed: "Persian Cat", age: 3, image: "assets/cat1.jpg", description: "Loves to cuddle."),
    Pet(id: "3", name: "Charlie", breed: "Beagle", age: 4, image: "assets/dog2.jpg", description: "Playful and energetic!"),
    Pet(id: "4", name: "Rose", breed: "African cat", age: 4, image: "assets/cat2.jpg", description: "cute and energetic!"),

  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Available Pets for Adoption")),
      body: ListView(
        padding: EdgeInsets.all(16),
        children: pets.map((pet) => PetCard(pet: pet)).toList(),
      ),
    );
  }
}
