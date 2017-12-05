package polytech5a.quentint.com.tppolytech.models;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by Quentin on 04/12/2017.
 */

public class BeerApiManager implements Callable<Beer[]>{



    public static final String API_URL = "https://api.punkapi.com/v2/";
    public static final String ALL_BEERS = "beers";
    public static final String ONE_BEERS = "beers/";

    public String url ;

    public BeerApiManager(String url) {
        this.url = url;
    }

    public Beer[] getAllBeers() {
        Beer[] beers = null;
        try {
            URL url = new URL(API_URL+"beers");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                String json = readStream(in);

                Gson gson = new Gson();
                beers = gson.fromJson(json, Beer[].class);
            } finally {
                urlConnection.disconnect();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return beers;
    }

    private String readStream(InputStream is) throws IOException {

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        int i = is.read();
        while(i != -1) {
            bo.write(i);
            i = is.read();
        }
        return bo.toString();

    }

    @Override
    public Beer[] call() throws Exception {
        if(url.equals("beers")){
            return getAllBeers();
        }
        else{
            return getOneBeer(url);
        }
    }

    private Beer[] getOneBeer(String url) {
        Beer[] beer = null;
        try {
            URL finalUrl = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) finalUrl.openConnection();
            try {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                String json = readStream(in);

                Gson gson = new Gson();
                beer = gson.fromJson(json, Beer[].class);
            } finally {
                urlConnection.disconnect();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return beer;
    }
}
