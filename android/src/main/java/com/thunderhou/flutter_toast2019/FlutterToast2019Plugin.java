package com.thunderhou.flutter_toast2019;

import android.content.Context;
import android.widget.Toast;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** FlutterToast2019Plugin */
public class FlutterToast2019Plugin implements MethodCallHandler {
  private final Context mContext;

  public FlutterToast2019Plugin(Context context) {
    mContext = context;
  }

  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "thunderHou.com/flutter_toast2019");
    channel.setMethodCallHandler(new FlutterToast2019Plugin(registrar.context()));
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    // call.method 是方法名，这里我们就叫它 toast
    if (call.method.equals("toast")) {
      // 调用本地代码的时候，只能传递一个参数。为了传递多个，可以把参数放在一个 map 里面。
      // call.argument() 方法支持 Map 和 JSONObject
      String content = call.argument("content");
      String duration = call.argument("duration");
      Toast.makeText(mContext, content,
              "short".equals(duration) ? Toast.LENGTH_SHORT : Toast.LENGTH_LONG)
              .show();

      result.success(true);
    } else {
      result.notImplemented();
    }
  }
}
