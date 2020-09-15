package com.hawolt.dispatcher;

public abstract class Patch implements Runnable {

    protected DispatchStatusCallback callback;

    public Patch(DispatchStatusCallback callback){
        this.callback=callback;
    }

}
