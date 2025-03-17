import 'package:flutter/material.dart';
import 'routes.dart';
import 'theme.dart'; // ✅ Import theme.dart

class App extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Pet Care App',
      theme: AppTheme.lightTheme, // ✅ Use AppTheme.lightTheme instead of appTheme
      initialRoute: '/',
      onGenerateRoute: Routes.generateRoute,
      debugShowCheckedModeBanner: false,
    );
  }
}
