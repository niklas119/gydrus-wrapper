package com.hawolt.dispatcher;

import com.hawolt.InitializationException;
import com.hawolt.TokenManager;
import com.hawolt.endpoint.impl.credentials.Credentials;
import com.hawolt.endpoint.impl.dashboard.Dashboard;
import org.json.JSONObject;
import org.pmw.tinylog.Logger;

import java.io.IOException;

public abstract class AbstractCallback implements DispatchStatusCallback {

    @Override
    public void onCompletion(int code, String response, DispatchEvent event, Object... objects) {
        switch (code) {
            case 200:
            case 201:
                switch (event) {
                    case REQUEST_FULL_ACCOUNT:
                        onFullAccountRequest(objects);
                        break;
                    case ADD_ACCOUNT:
                        onAccountAddition(objects);
                        break;
                    case UPDATE_ACCOUNT:
                        onAccountUpdate(objects);
                        break;
                    case DELETE_ACCOUNT:
                        onAccountDeletion(objects);
                        break;
                    case RESTART_VM:
                        onVMRestart(objects);
                        break;
                }
                break;
            default:
                resend(event, objects);
        }
    }

    @Override
    public void onException(Exception e, DispatchEvent event, Object... objects) {
        Logger.error(e);
        resend(event, objects);
    }

    private void update() {
        try {
            TokenManager.update();
        } catch (IOException | InitializationException e) {
            Logger.error(e);
        }
    }

    private void resend(DispatchEvent event, Object... objects) {
        update();
        switch (event) {
            case REQUEST_FULL_ACCOUNT:
                Dashboard.request(this, objects[0].toString());
                break;
            case ADD_ACCOUNT:
                Dashboard.add(this, (JSONObject) objects[0]);
                break;
            case UPDATE_ACCOUNT:
                Dashboard.update(this, (JSONObject) objects[0]);
                break;
            case DELETE_ACCOUNT:
                Credentials.delete(this, objects[0].toString());
                break;
            case RESTART_VM:
                Dashboard.restart(this, objects[0].toString());
                break;
        }
    }

    protected abstract void onAccountAddition(Object... objects);

    protected abstract void onAccountUpdate(Object... objects);

    protected abstract void onAccountDeletion(Object... objects);

    protected abstract void onVMRestart(Object... objects);

    protected abstract void onFullAccountRequest(Object... objects);

}
