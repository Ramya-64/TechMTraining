import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../screens/pet_details_screen.dart';
import '../models/pet_model.dart';
import '../providers/favorite_provider.dart';

class PetCard extends StatelessWidget {
  final Pet pet;

  PetCard({required this.pet});

  @override
  Widget build(BuildContext context) {
    return TweenAnimationBuilder(
      duration: Duration(milliseconds: 600),
      tween: Tween<double>(begin: 0, end: 1),
      builder: (context, double value, child) {
        return Transform.translate(
          offset: Offset(0, 50 * (1 - value)),
          child: Opacity(opacity: value, child: child),
        );
      },
      child: Consumer<FavoriteProvider>(
        builder: (context, favoriteProvider, child) {
          final isFavorite = favoriteProvider.isFavorite(pet);

          return Card(
            shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
            elevation: 4,
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                Stack(
                  children: [
                    ClipRRect(
                      borderRadius: BorderRadius.vertical(top: Radius.circular(12)),
                      child: Image.asset(
                        pet.image,
                        width: double.infinity,
                        height: 300, // Increased height for better visibility
                        fit: BoxFit.fitHeight, // Ensures full image is shown without cropping
                      ),
                    ),
                    Positioned(
                      top: 10,
                      right: 10,
                      child: IconButton(
                        icon: Icon(
                          isFavorite ? Icons.favorite : Icons.favorite_border,
                          color: isFavorite ? Colors.red : Colors.grey,
                          size: 30,
                        ),
                        onPressed: () {
                          favoriteProvider.toggleFavorite(pet);
                          ScaffoldMessenger.of(context).showSnackBar(
                            SnackBar(
                              content: Text(
                                isFavorite ? "Removed from Favorites" : "Added to Favorites",
                              ),
                              duration: Duration(seconds: 1),
                            ),
                          );
                        },
                      ),
                    ),
                  ],
                ),
                Padding(
                  padding: const EdgeInsets.all(12),
                  child: Column(
                    children: [
                      Text(pet.name, style: Theme.of(context).textTheme.titleLarge),
                      SizedBox(height: 5),
                      Text("${pet.breed} • ${pet.age} years old", style: TextStyle(color: Colors.grey)),
                      SizedBox(height: 10),
                      Row(
                        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                        children: [
                          ElevatedButton.icon(
                            onPressed: () => _viewDetails(context),
                            icon: Icon(Icons.info),
                            label: Text("Details"),
                          ),
                          ElevatedButton.icon(
                            onPressed: () => _adoptPet(context),
                            icon: Icon(Icons.pets),
                            label: Text("Adopt"),
                            style: ElevatedButton.styleFrom(backgroundColor: Colors.orangeAccent),
                          ),
                        ],
                      ),
                    ],
                  ),
                ),
              ],
            ),
          );
        },
      ),
    );
  }

  void _viewDetails(BuildContext context) {
    Navigator.push(
      context,
      MaterialPageRoute(
        builder: (context) => PetDetailsScreen(
          petName: pet.name,       
          petImage: pet.image,     
          breed: pet.breed,        
          age: pet.age,            
          description: pet.description, 
        ),
      ),
    );
  }

  void _adoptPet(BuildContext context) {
    Navigator.pushNamed(
      context,
      '/adopt',
      arguments: {
        "petName": pet.name,
        "petImage": pet.image,
      },
    );
  }
}
