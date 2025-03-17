import 'package:flutter/material.dart';
import '../localization.dart';

class SettingsPage extends StatelessWidget {
  final Function(Locale) changeLanguage;

  SettingsPage({required this.changeLanguage});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text(AppLocalizations.of(context)!.translate('settings'))),
      body: Center(
        child: DropdownButton<Locale>(
          onChanged: (Locale? locale) {
            if (locale != null) {
              changeLanguage(locale); // Call function to change language
              Navigator.pop(context); // Go back to HomeScreen after selection
            }
          },
          items: [
            DropdownMenuItem(
              value: Locale('en', ''),
              child: Text('English'),
            ),
            DropdownMenuItem(
              value: Locale('es', ''),
              child: Text('Español'),
            ),
          ],
        ),
      ),
    );
  }
}
