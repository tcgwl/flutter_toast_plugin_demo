import 'package:flutter/material.dart';
import 'package:flutter_toast2019/flutter_toast2019.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Plugin Toast Demo',
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Flutter Plugin Toast Demo'),
        ),
        body: Center(
          child: RaisedButton(
            onPressed: (){
              final msg = 'Toast from Flutter.';
              print('log: $msg');
              FlutterToast2019.toast(msg, ToastDuration.short);
            },
            child: Text('toast'),
          ),
        ),
      ),
    );
  }
}

