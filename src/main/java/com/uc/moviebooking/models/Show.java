package com.uc.moviebooking.models;

import com.uc.moviebooking.service.PricingStrategy;

public class Show {
    private String id;
    private Movie movie;
    private Long startTime;
    private Long endTime;
    private Screen screen;
    private PricingStrategy pricingStrategy;

    public Show(String id, Movie movie, Long startTime, Long endTime, Screen screen, PricingStrategy pricingStrategy) {
        this.id = id;
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = endTime;
        this.screen = screen;
        this.pricingStrategy = pricingStrategy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    @Override
    public String toString() {
        return "Show{" +
                "id='" + id + '\'' +
                ", movie=" + movie +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", screen=" + screen +
                ", pricingStrategy=" + pricingStrategy +
                '}';
    }
}
