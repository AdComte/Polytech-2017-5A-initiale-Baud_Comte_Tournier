package polytech5a.quentint.com.tppolytech;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {

    private  BroadcastReceiver receiver;

    public GameFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        IntentFilter filter = new IntentFilter();
        filter.addAction("Question");


        receiver = new BroadcastReceiver() {


            @Override
            public void onReceive(Context context, Intent intent) {
                if(intent.getAction().equals("Question")){
                    TextQuestion tq = intent.getParcelableExtra("Question");
                }
            }
        };

        Intent intent = new Intent();
        intent.setAction("Question");
        getActivity().sendBroadcast(intent);

        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(receiver,
                filter);
        return inflater.inflate(R.layout.fragment_game, container, false);

    }

}
