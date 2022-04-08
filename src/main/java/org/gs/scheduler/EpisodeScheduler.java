package org.gs.scheduler;

import io.quarkus.scheduler.Scheduled;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.gs.model.Episode;
import org.gs.proxy.EpisodeProxy;
import org.gs.service.TvSeriesService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.function.Predicate;

@ApplicationScoped
public class EpisodeScheduler {

    @Inject
    TvSeriesService tvSeriesService;

    @RestClient
    @Inject
    EpisodeProxy episodeProxy;

    @Scheduled(every = "15s")
    void fetchEpisodes() {
        tvSeriesService
                .getTvSeriesList()
                .stream()
                .filter(tvSeries -> tvSeries.getEpisodes().isEmpty())
                .forEach(tvSeries ->
                        tvSeries.setEpisodes(episodeProxy.get(tvSeries.getId()))
                );
        System.out.println("Fetch Episodes completed!");
    }
}
