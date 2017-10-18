package polytech5a.quentint.com.tppolytech.service;

import android.app.IntentService;
import android.content.Intent;

import polytech5a.quentint.com.tppolytech.models.TextQuestion;


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
        //Hard coded just for dev purpose
        TextQuestion q = new TextQuestion("Quel est le muscle ?", new String[]{"Cubitus", "Oreille", "Un Canard", "La reponse D"},"La reponse D", 10);
        
        /**
         * TODO
         * Intent action = "Question" -> retrieve a question
         * Intent action = "Answer" -> check question answer
         */
    }

}
