package com.michaelopoku.ipoquetest.dao;

import com.michaelopoku.ipoquetest.model.MovieInfo;
import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MovieDaoImpl implements MovieDao {

    @Autowired
    DB mongoDB;

    public boolean addMovie(MovieInfo movieInfo) {
        try {
            DBObject dbMovie = new BasicDBObject("title", movieInfo.getTitle())
                    .append("rating", movieInfo.getRating())
                    .append("episode_id", movieInfo.getEpisode_id())
                    .append("opening_crawl", movieInfo.getOpening_crawl())
                    .append("director", movieInfo.getRating())
                    .append("producer", movieInfo.getRating())
                    .append("release_date", movieInfo.getRating())
                    .append("characters", movieInfo.getRating());

            mongoDB.getCollection("starwars").insert(dbMovie);

            return true;
        } catch (DuplicateKeyException e) {
            return false;
        }
    }

    @Override
    public Optional<MovieInfo> findMovie(String title) {
        try {
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("title", title);
            DBCursor cursor = mongoDB.getCollection("starwars").find(whereQuery);

            if(!cursor.hasNext()) { return Optional.empty(); }
            DBObject obj = cursor.next();

            Optional<MovieInfo> movieInfo = Optional.of(new MovieInfo(
                    obj.get("title").toString(),
                    Integer.parseInt(obj.get("episode_id").toString()),
                    obj.get("opening_crawl").toString(),
                    obj.get("director").toString(),
                    obj.get("producer").toString(),
                    obj.get("release_date").toString(),
                    obj.get("characters").toString())
            );
            movieInfo.get().setRating(Integer.parseInt(obj.get("episode_id").toString()));

            return movieInfo;
        } catch (Exception e) {
            throw e;
        }
    }
}
