package com.valterhenrique.code.movie;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import javax.validation.constraints.NotNull;

@DynamoDBTable(tableName = "ddb-table-sst67gy")
public class Movie {

    private String title;
    private String timeStamp;

    @DynamoDBHashKey(attributeName = "title")
    @NotNull(message = "Title must not be empty")
    public String getTitle() {
        return title;
    }

    public Movie withTitle(String name) {

        setTitle(name);
        return this;
    }

    @DynamoDBRangeKey(attributeName = "timestamp")
    public String getTimeStamp() {
        return timeStamp;
    }

    public Movie withTimeStamp(String address) {
        setTimeStamp(address);
        return this;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        return timeStamp != null ? timeStamp.equals(movie.timeStamp) : movie.timeStamp == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}