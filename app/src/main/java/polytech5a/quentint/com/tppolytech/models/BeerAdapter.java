package polytech5a.quentint.com.tppolytech.models;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import polytech5a.quentint.com.tppolytech.MainActivity;
import polytech5a.quentint.com.tppolytech.R;

/**
 * Created by Quentin on 05/12/2017.
 */

public class BeerAdapter extends ArrayAdapter<Beer> {

    List<Beer> beerList;

    public BeerAdapter(Context context, ArrayList<Beer> beers) {
        super(context, 0, beers);
        beerList = beers;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Beer beer = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.a_beer, parent, false);
        }

        // Lookup view for data population
        ImageView beerPicture = (ImageView) convertView.findViewById(R.id.beerPic) ;
        TextView beerName = (TextView) convertView.findViewById(R.id.beerName);
        TextView beerAlc = (TextView) convertView.findViewById(R.id.beerAlc);
        // Populate the data into the template view using the data object
        beerName.setText(beer.getName());
        beerAlc.setText(beerAlc.getText().toString().replace("x", Float.toString(beer.getAbv())));

        //change image
        Picasso.with(getContext())
                .load(beer.getImage_url())
                .into(beerPicture);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getContext();
                activity.goToDetails(beer.getId());
            }
        });

        //beerPicture.setImageURI(Uri.parse(beer.getImage_url()));
        // Return the completed view to render on screen
        return convertView;
    }
}
