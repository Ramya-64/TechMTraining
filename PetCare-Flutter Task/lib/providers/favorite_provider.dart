import 'package:flutter/material.dart';
import '../models/pet_model.dart';

class FavoriteProvider with ChangeNotifier {
  final List<Pet> _favoritePets = [];

  List<Pet> get favoritePets => _favoritePets;

  void toggleFavorite(Pet pet) {
    if (_favoritePets.contains(pet)) {
      _favoritePets.remove(pet);
    } else {
      _favoritePets.add(pet);
    }
    notifyListeners();
  }

  bool isFavorite(Pet pet) {
    return _favoritePets.contains(pet);
  }
}
