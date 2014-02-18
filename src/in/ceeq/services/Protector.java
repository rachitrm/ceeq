package in.ceeq.services;

import in.ceeq.actions.Receiver;
import in.ceeq.actions.Receiver.ReceiverType;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class Protector extends Service {

	public static final String ACTION = "action";

	public enum ProtectorType {
		START;
	}

	private ProtectorType protectorType;

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		protectorType = (ProtectorType) intent.getExtras().get(ACTION);
		switch (protectorType) {

		case START:
			Receiver.getInstance(this).register(ReceiverType.POWER_BUTTON);
			break;
		}

		return START_REDELIVER_INTENT;
	}

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

}
