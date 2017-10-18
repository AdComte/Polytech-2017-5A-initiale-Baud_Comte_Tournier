package polytech5a.quentint.com.tppolytech.service;

import android.app.IntentService;
import android.content.Intent;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class QuestionIntentService extends IntentService {
    public QuestionIntentService() {
        super("QuestionIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        /**
         * TODO
         * Intent action = "Question" -> retrieve a question
         * Intent action = "Answer" -> check question answer
         */
    }

}
