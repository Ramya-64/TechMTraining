import 'package:flutter/material.dart';
import 'screens/home_screen.dart';
import 'screens/adopt_screen.dart';
import 'screens/pet_details_screen.dart';
import 'screens/events_screen.dart';
import 'screens/profile_screen.dart';

class Routes {
  static Route<dynamic> generateRoute(RouteSettings settings) {
    switch (settings.name) {
      case '/':
        return _fadeRoute(HomeScreen());

      case '/adopt':
        if (settings.arguments is Map<String, dynamic>) {
          final args = settings.arguments as Map<String, dynamic>;
          return _fadeRoute(AdoptScreen(
            petName: args['petName'] ?? 'Unknown',
            petImage: args['petImage'] ?? '',
          ));
        }
        return _fadeRoute(HomeScreen()); // Default if no args provided

      case '/details':
        if (settings.arguments is Map<String, dynamic>) {
          final args = settings.arguments as Map<String, dynamic>;
          return _fadeRoute(PetDetailsScreen(
            petName: args['petName'] ?? 'Unknown',
            petImage: args['petImage'] ?? '',
            breed: args['breed'] ?? 'Unknown',
            age: args['age'] ?? 0,
            description: args['description'] ?? '',
          ));
        }
        return _fadeRoute(HomeScreen()); // Default if no arguments provided

        
      case '/events':
        return _fadeRoute(EventsScreen());

      case '/profile':
  if (settings.arguments is Map<String, dynamic>) {
    final args = settings.arguments as Map<String, dynamic>;
    return _fadeRoute(ProfileScreen(
      username: args['username'] ?? 'Guest',
      email: args['email'] ?? 'guest@example.com',
    ));
  }
  // Provide default values if no arguments are passed
  return _fadeRoute(ProfileScreen(username: 'Guest', email: 'guest@example.com'));


      default:
        return _fadeRoute(HomeScreen());
    }
  }

  static PageRouteBuilder _fadeRoute(Widget page) {
    return PageRouteBuilder(
      transitionDuration: Duration(milliseconds: 500),
      pageBuilder: (_, __, ___) => page,
      transitionsBuilder: (_, animation, __, child) {
        return FadeTransition(opacity: animation, child: child);
      },
    );
  }
}
