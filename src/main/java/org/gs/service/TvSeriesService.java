package org.gs.service;

import org.gs.model.TvSeries;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class TvSeriesService {

    private List<TvSeries> tvSeriesList = new ArrayList<>();

    public List<TvSeries> getTvSeriesList() {
        return tvSeriesList;
    }

    public void addTvSeries(TvSeries tvSeries) {
        this.tvSeriesList.add(tvSeries);
    }
}
