import 'package:flutter/material.dart';
import 'history_screen.dart';
import '../db/database_helper.dart';

class CalculatorScreen extends StatefulWidget {
  @override
  _CalculatorScreenState createState() => _CalculatorScreenState();
}

class _CalculatorScreenState extends State<CalculatorScreen> {
  final TextEditingController num1Controller = TextEditingController();
  final TextEditingController num2Controller = TextEditingController();
  double _result = 0.0;

  void _calculate(String operation) async {
    double num1 = double.tryParse(num1Controller.text) ?? 0;
    double num2 = double.tryParse(num2Controller.text) ?? 0;
    double result = 0;
    String expression = "";

    switch (operation) {
      case 'add':
        result = num1 + num2;
        expression = "$num1 + $num2";
        break;
      case 'sub':
        result = num1 - num2;
        expression = "$num1 - $num2";
        break;
      case 'mul':
        result = num1 * num2;
        expression = "$num1 × $num2";
        break;
      case 'div':
        result = num2 != 0 ? num1 / num2 : 0;
        expression = num2 != 0 ? "$num1 ÷ $num2" : "Division by zero!";
        break;
    }

    setState(() {
      _result = result;
    });

    await DatabaseHelper().insertCalculation(expression, result.toString());
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Calculator')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            TextField(
              controller: num1Controller,
              keyboardType: TextInputType.number,
              decoration: InputDecoration(labelText: 'Enter first number'),
            ),
            TextField(
              controller: num2Controller,
              keyboardType: TextInputType.number,
              decoration: InputDecoration(labelText: 'Enter second number'),
            ),
            SizedBox(height: 20),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                ElevatedButton(onPressed: () => _calculate('add'), child: Text('+')),
                ElevatedButton(onPressed: () => _calculate('sub'), child: Text('-')),
                ElevatedButton(onPressed: () => _calculate('mul'), child: Text('*')),
                ElevatedButton(onPressed: () => _calculate('div'), child: Text('/')),
              ],
            ),
            SizedBox(height: 20),
            Text(
              'Result: $_result',
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => HistoryScreen()),
                );
              },
              child: Text('View History'),
            ),
          ],
        ),
      ),
    );
  }
}
