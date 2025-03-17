import 'package:flutter/material.dart';

class PetAdoptionJourney extends StatefulWidget {
  @override
  _PetAdoptionJourneyState createState() => _PetAdoptionJourneyState();
}

class _PetAdoptionJourneyState extends State<PetAdoptionJourney> {
  final GlobalKey _adoptionJourneyKey = GlobalKey(); // Key for scrolling target

  void _scrollToJourney() {
    Scrollable.ensureVisible(
      _adoptionJourneyKey.currentContext!,
      duration: Duration(seconds: 1),
      curve: Curves.easeInOut,
    );
  }

  @override
  Widget build(BuildContext context) {
    double screenWidth = MediaQuery.of(context).size.width; // ✅ Get screen width
    bool isMobile = screenWidth < 600; // ✅ Define mobile layout breakpoint

    return SingleChildScrollView(
      child: Padding(
        padding: EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            // ✅ Heading
            Text(
              "A Forever Family For Pets In Need",
              style: TextStyle(
                fontSize: isMobile ? 24 : 30, // ✅ Scaled text for mobile
                fontWeight: FontWeight.bold,
                color: Colors.blue.shade900,
                fontStyle: FontStyle.italic,
              ),
              textAlign: TextAlign.center,
            ),
            SizedBox(height: 10),

            // ✅ Text & Image Section (Stacked on mobile, Row on larger screens)
            isMobile
                ? Column(
                    children: [
                      _buildInfoText(),
                      SizedBox(height: 20),
                      _buildImage('assets/image.png', 250), // ✅ Adjusted Image
                    ],
                  )
                : Row(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Expanded(flex: 2, child: _buildInfoText()),
                      SizedBox(width: 20),
                      Expanded(flex: 1, child: _buildImage('assets/image.png', 400)),
                    ],
                  ),
            SizedBox(height: 20),

            // ✅ Adoption Journey Section
            KeyedSubtree(
              key: _adoptionJourneyKey,
              child: Column(
                children: [
                  Text(
                    "Your Pet Adoption Journey With ThePetNest",
                    style: TextStyle(
                      fontSize: isMobile ? 24 : 30, // ✅ Scaled text
                      fontWeight: FontWeight.bold,
                      color: Colors.blue.shade900,
                      fontStyle: FontStyle.italic,
                    ),
                    textAlign: TextAlign.center,
                  ),
                  SizedBox(height: 20),

                  // ✅ Image & Feature Section
                  isMobile
                      ? Column(
                          children: [
                            _buildImage('assets/dog.png', 200),
                            SizedBox(height: 20),
                            _buildFeatures(),
                          ],
                        )
                      : Row(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Expanded(flex: 1, child: _buildImage('assets/dog.png', 300)),
                            SizedBox(width: 30),
                            Expanded(flex: 2, child: _buildFeatures()),
                          ],
                        ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }

  // ✅ Function to build Information Text
  Widget _buildInfoText() {
    return Text(
      "Love has no breed.\n"
      "Adopting a pet is not only a wonderful way to bring joy into your life, "
      "it’s also a chance to save a life.\n"
      "Find your fur-ever loyal companion and bring home sheer happiness – Adopt today!\n"
      "Start your search for companionship now.\n"
      "Within a few clicks, you’ll be one step closer to finding a lovable pet to make memories with!",
      style: TextStyle(
        fontSize: 18, // ✅ Adjusted font size
        color: Colors.grey[800],
        height: 1.5,
        fontWeight: FontWeight.bold,
      ),
      textAlign: TextAlign.center,
    );
  }

  // ✅ Function to build Features List
  Widget _buildFeatures() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        FeatureItem(
          icon: Icons.pets,
          title: "Search Pet",
          description: "Find the perfect pet in your city with a few clicks.",
        ),
        FeatureItem(
          icon: Icons.call,
          title: "Connect",
          description: "Contact pet parents or rescues directly.",
        ),
        FeatureItem(
          icon: Icons.favorite,
          title: "AdoptLove",
          description: "Follow an easy adoption process for your new pet.",
        ),
        FeatureItem(
          icon: Icons.medical_services,
          title: "Free Vet Consultation",
          description: "Get free vet consultations to help your pet adjust.",
        ),
      ],
    );
  }

  // ✅ Function to build Image with constraints
  Widget _buildImage(String imagePath, double height) {
    return Image.asset(
      imagePath,
      height: height,
      fit: BoxFit.cover,
    );
  }
}

// ✅ Feature Item Widget
class FeatureItem extends StatelessWidget {
  final IconData icon;
  final String title;
  final String description;

  FeatureItem({required this.icon, required this.title, required this.description});

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.only(bottom: 15),
      child: Row(
        children: [
          Icon(icon, size: 30, color: Colors.blue.shade800), // ✅ Reduced icon size for mobile
          SizedBox(width: 10),
          Expanded(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  title,
                  style: TextStyle(
                    fontSize: 16, // ✅ Adjusted size
                    fontWeight: FontWeight.bold,
                    color: Colors.blue.shade900,
                  ),
                ),
                SizedBox(height: 5),
                Text(
                  description,
                  style: TextStyle(fontSize: 14, color: Colors.grey[700]),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
