package polytech5a.quentint.com.tppolytech;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import polytech5a.quentint.com.tppolytech.models.Beer;
import polytech5a.quentint.com.tppolytech.models.BeerApiManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Beer[] beers = new Beer[0];
        try {
            ExecutorService pool = Executors.newSingleThreadExecutor();
            Future<Beer[]> future = pool.submit(new BeerApiManager(BeerApiManager.ALL_BEERS));
            beers = future.get();

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(Beer b:beers){
            System.out.println(b.getName());
        }
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
