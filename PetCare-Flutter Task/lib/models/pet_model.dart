class Pet {
  String id;
  String name;
  String image;  // ✅ Make sure this matches `image` in `HomeScreen`
  String breed;
  int age;
  String description;

  Pet({
    required this.id,
    required this.name,
    required this.image,
    required this.breed,
    required this.age,
    required this.description,
  });

  // Convert Firestore data to Pet object
  factory Pet.fromJson(Map<String, dynamic> json, String id) {
    return Pet(
      id: id,
      name: json['name'],
      image: json['image'],
      breed: json['breed'],
      age: json['age'],
      description: json['description'],
    );
  }

  // Convert Pet object to Firestore data
  Map<String, dynamic> toJson() {
    return {
      "name": name,
      "image": image,
      "breed": breed,
      "age": age,
      "description": description,
    };
  }
}
