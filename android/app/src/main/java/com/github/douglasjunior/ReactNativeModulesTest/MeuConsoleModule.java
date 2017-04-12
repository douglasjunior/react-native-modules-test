package com.github.douglasjunior.ReactNativeModulesTest;

import android.util.Log;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableNativeMap;

/**
 * Created by douglas on 12/04/17.
 */

public class MeuConsoleModule extends ReactContextBaseJavaModule {

    public MeuConsoleModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "MeuConsole";
    }

    @ReactMethod
    public void log(String text) {
        Log.d("MEU_CONSOLE", text);
    }

    @ReactMethod
    public void logObject(ReadableMap object) {
        final ReadableMapKeySetIterator keys = object.keySetIterator();

        while (keys.hasNextKey()) {
            final String key = keys.nextKey();
            final ReadableType type = object.getType(key);
            switch (type) {
                case Boolean:
                    Log.d("MEU_CONSOLE", key + ": " + object.getBoolean(key) + "");
                    break;
                case Number:
                    Log.d("MEU_CONSOLE", key + ": " + object.getDouble(key) + "");
                    break;
                case String:
                    Log.d("MEU_CONSOLE", key + ": " + object.getString(key));
                    break;
            }
        }
    }

    @ReactMethod
    public void logCallback(String text, Callback callError, Callback callSuccess) {
        if (text == null) {
            WritableNativeMap error = new WritableNativeMap();
            error.putString("code", "100");
            error.putString("message", "O parâmetro de texto não pode ser nulo.");

            callError.invoke(error);
            return;
        }

        Log.d("MEU_CONSOLE", text);

        callSuccess.invoke();
    }

    @ReactMethod
    public void logPromise(String text, Promise promise) {
        if (text == null) {
            promise.reject("100", "O parâmetro de texto não pode ser nulo.");
            return;
        }

        Log.d("MEU_CONSOLE", text);

        promise.resolve(null);
    }

}
