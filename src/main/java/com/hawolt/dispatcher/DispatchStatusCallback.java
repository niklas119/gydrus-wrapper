package com.hawolt.dispatcher;

import java.util.concurrent.Executors;

public interface DispatchStatusCallback {
    void onCompletion(int code, String response, DispatchEvent event, Object... objects);

    void onException(Exception e, DispatchEvent event, Object... objects);
}
