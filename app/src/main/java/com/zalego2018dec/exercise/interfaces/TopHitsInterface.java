package com.zalego2018dec.exercise.interfaces;

import com.zalego2018dec.exercise.objects.TopHits;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by folio on 12/14/2018.
 */

public interface TopHitsInterface {

    @GET("/get-top-hits.php")
    public Call<List<TopHits>> getTopHits();
}
