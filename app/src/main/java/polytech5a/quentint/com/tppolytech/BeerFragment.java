package polytech5a.quentint.com.tppolytech;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import polytech5a.quentint.com.tppolytech.models.Beer;
import polytech5a.quentint.com.tppolytech.models.BeerAdapter;
import polytech5a.quentint.com.tppolytech.models.BeerApiManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class BeerFragment extends Fragment {

    private  BroadcastReceiver receiver;
    private int numBeer;

    public BeerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        Beer[] beers = new Beer[0];
        try {
            Bundle args = getArguments();
            String idBeer = (String)args.get("idBeer");
            ExecutorService pool = Executors.newSingleThreadExecutor();
            Future<Beer[]> future = pool.submit(new BeerApiManager(BeerApiManager.ONE_BEERS + idBeer));
            beers = future.get();


        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Beer> arrayBeer = new ArrayList<>(Arrays.asList(beers));

        View view = inflater.inflate(R.layout.beer_details, container, false);
        Beer beer = arrayBeer.get(0);

        ImageView beerPicture = (ImageView) view.findViewById(R.id.beerPic) ;
        TextView beerName = (TextView) view.findViewById(R.id.beerName);
        TextView beerAlc = (TextView) view.findViewById(R.id.beerAlc);
        TextView beerDesc = (TextView) view.findViewById(R.id.beerDesc);

        // Populate the data into the template view using the data object
        beerDesc.setText(beer.getDescription());
        beerName.setText(beer.getName());
        beerAlc.setText(beerAlc.getText().toString().replace("x", Float.toString(beer.getAbv())));

        //change image
        Picasso.with(getContext())
                .load(beer.getImage_url())
                .into(beerPicture);


        return view;

    }

}
