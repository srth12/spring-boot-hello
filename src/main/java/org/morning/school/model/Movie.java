package org.morning.school.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Movie {

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    private String title;
    private LocalDate releaseDate;
    private String leadActor;
    private String leadActress;
    private float collectionInCrore;
    private String genre;
    private String imdbID;

    public Movie(String csvLineItem) {
        String[] fields = csvLineItem.split(",");
        title = fields[0];
        releaseDate = LocalDate.parse(fields[1], DATE_FORMATTER);
        leadActor = fields[2];
        leadActress = fields[3];
        collectionInCrore = Float.parseFloat(fields[4]);
        genre = fields[5];
        imdbID =fields[6];
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getLeadActor() {
        return leadActor;
    }

    public String getLeadActress() {
        return leadActress;
    }

    public Float getCollectionInCrore() {
        return collectionInCrore;
    }

    public String getGenre() {
        return genre;
    }

    public String getImdbID() {
        return imdbID;
    }

    public Integer getReleaseYear() {
        return releaseDate.getYear();
    }
}
