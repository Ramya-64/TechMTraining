import 'dart:async';
import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:intl/intl.dart';

class EventsScreen extends StatefulWidget {
  @override
  _EventsScreenState createState() => _EventsScreenState();
}

class _EventsScreenState extends State<EventsScreen> {
  final List<Map<String, String>> events = [
    {
      "title": "Pet Adoption Drive 🐶",
      "date": "March 20, 2025",
      "location": "Central Park, NY",
      "image": "assets/event1.png"
    },
    {
      "title": "Rescue Awareness Camp 🐾",
      "date": "April 10, 2025",
      "location": "Los Angeles, CA",
      "image": "assets/event2.png"
    },
    {
      "title": "Pet Care Workshop 🏥",
      "date": "May 5, 2025",
      "location": "San Francisco, CA",
      "image": "assets/event3.png"
    },
  ];

  Map<String, Duration> countdowns = {};
  Set<String> registeredEvents = {}; // Store registered events
  late Timer _timer;

  @override
  void initState() {
    super.initState();
    _initializeCountdowns();
    _loadRegisteredEvents();
    _startTimer();
  }

  void _initializeCountdowns() {
    for (var event in events) {
      DateTime eventDate = DateFormat("MMMM d, yyyy").parse(event["date"]!);
      countdowns[event["title"]!] = eventDate.difference(DateTime.now());
    }
  }

  void _startTimer() {
    _timer = Timer.periodic(Duration(seconds: 1), (timer) {
      setState(() {
        for (var event in events) {
          String title = event["title"]!;
          DateTime eventDate = DateFormat("MMMM d, yyyy").parse(event["date"]!);
          countdowns[title] = eventDate.difference(DateTime.now());
        }
      });
    });
  }

  Future<void> _loadRegisteredEvents() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();
    setState(() {
      registeredEvents = prefs.getStringList('registeredEvents')?.toSet() ?? {};
    });
  }

  Future<void> _registerForEvent(BuildContext context, String eventTitle) async {
    bool confirmed = await _showConfirmationDialog(context, eventTitle);
    if (confirmed) {
      SharedPreferences prefs = await SharedPreferences.getInstance();
      registeredEvents.add(eventTitle);
      await prefs.setStringList('registeredEvents', registeredEvents.toList());
      setState(() {});
    }
  }

  Future<bool> _showConfirmationDialog(BuildContext context, String eventTitle) async {
    return await showDialog(
          context: context,
          builder: (context) => AlertDialog(
            title: Text("Confirm Registration"),
            content: Text("Do you want to register for '$eventTitle'?"),
            actions: [
              TextButton(
                onPressed: () => Navigator.pop(context, false),
                child: Text("Cancel", style: TextStyle(color: Colors.red)),
              ),
              TextButton(
                onPressed: () => Navigator.pop(context, true),
                child: Text("Confirm", style: TextStyle(color: Colors.green)),
              ),
            ],
          ),
        ) ??
        false;
  }

  String _formatDuration(Duration duration) {
    if (duration.isNegative) return "Event started!";
    int days = duration.inDays;
    int hours = duration.inHours.remainder(24);
    int minutes = duration.inMinutes.remainder(60);
    int seconds = duration.inSeconds.remainder(60);
    return "$days days, $hours hrs, $minutes min, $seconds sec";
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Upcoming Events"),
        backgroundColor: Colors.blue.shade900,
      ),
      body: ListView.builder(
        padding: EdgeInsets.all(16),
        itemCount: events.length,
        itemBuilder: (context, index) {
          return _eventCard(context, events[index]);
        },
      ),
    );
  }

  Widget _eventCard(BuildContext context, Map<String, String> event) {
    String title = event["title"]!;
    Duration remainingTime = countdowns[title] ?? Duration.zero;
    bool isRegistered = registeredEvents.contains(title);

    return TweenAnimationBuilder(
      duration: Duration(milliseconds: 600),
      tween: Tween<double>(begin: 0, end: 1),
      builder: (context, double value, child) {
        return Transform.translate(
          offset: Offset(0, 50 * (1 - value)),
          child: Opacity(opacity: value, child: child),
        );
      },
      child: Card(
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
        elevation: 6,
        margin: EdgeInsets.only(bottom: 20),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.center, // Center alignment
          children: [
            Stack(
              children: [
                ClipRRect(
                  borderRadius: BorderRadius.vertical(top: Radius.circular(12)),
                  child: Image.asset(
                    event["image"]!,
                    width: double.infinity,
                    height: 300, // Consistent height
                    fit: BoxFit.fitHeight,
                  ),
                ),
                Positioned(
                  top: 10,
                  right: 10,
                  child: Icon(
                    Icons.event,
                    color: Colors.blue.shade700,
                    size: 30,
                  ),
                ),
              ],
            ),
            Padding(
              padding: const EdgeInsets.all(16.0),
              child: Column(
                children: [
                  Text(
                    title,
                    textAlign: TextAlign.center,
                    style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold, color: Colors.black87),
                  ),
                  SizedBox(height: 8),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Icon(Icons.calendar_today, size: 18, color: Colors.blue.shade900),
                      SizedBox(width: 6),
                      Text(event["date"]!, style: TextStyle(fontSize: 16, color: Colors.black54)),
                    ],
                  ),
                  SizedBox(height: 6),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Icon(Icons.location_on, size: 18, color: Colors.red.shade700),
                      SizedBox(width: 6),
                      Text(event["location"]!, style: TextStyle(fontSize: 16, color: Colors.black54)),
                    ],
                  ),
                  SizedBox(height: 10),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Icon(Icons.timer, size: 18, color: Colors.orange.shade700),
                      SizedBox(width: 6),
                      Text(
                        _formatDuration(remainingTime),
                        style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold, color: Colors.orange.shade800),
                      ),
                    ],
                  ),
                  SizedBox(height: 12),
                  ElevatedButton.icon(
                    onPressed: isRegistered ? null : () => _registerForEvent(context, title),
                    icon: Icon(Icons.event_available, color: Colors.white),
                    label: Text(isRegistered ? "Registered" : "Register"),
                    style: ElevatedButton.styleFrom(
                      backgroundColor: isRegistered ? Colors.grey : Colors.green.shade600,
                      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(8)),
                    ),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }

  @override
  void dispose() {
    _timer.cancel();
    super.dispose();
  }
}
