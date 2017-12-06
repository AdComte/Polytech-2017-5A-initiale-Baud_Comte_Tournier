package polytech5a.quentint.com.tppolytech.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import polytech5a.quentint.com.tppolytech.HomeFragment;
import polytech5a.quentint.com.tppolytech.R;
import polytech5a.quentint.com.tppolytech.models.Beer;

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
        Beer beer = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_beer, parent, false);
        }
        // Lookup view for data population
        TextView beerName = (TextView) convertView.findViewById(R.id.beerName);
        TextView beerDesc = (TextView) convertView.findViewById(R.id.beerDesc);
        // Populate the data into the template view using the data object
        beerName.setText(beer.getName());
        beerDesc.setText(beer.getDescription());
        // Return the completed view to render on screen
        return convertView;
    }
}
