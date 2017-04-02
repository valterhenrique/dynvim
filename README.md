# Vimeo Views

## Summary:

> The aim for this task is to understand your technical skill-set, problem solving and thought process.
> Your task is to come up with a small application demonstrating your design and implementation
> skills using Java. You can do as little or as much as you like, and you may use whatever online
> resources you like to extend your knowledge about the technologies used.


## Task:

> Your client wants to track Vimeo views on the trailers of a number of movies at an hourly
> frequency. Your client would like you to collect the data from the Vimeo API and save it in an
> analyzable format.
> The list of 100 movies will be made available to you inside a table within a MySQL database. The
> table will hold a movie names and a collection of search terms for that movie.
> Your task is to extract the relevant data from Vimeo’s API and save it into. The minimum schema to
> use is: 1.

## Decisions made

* Java 8
* Vimeo views are summed based into the search term provided. The sum can be seen in the log file, but it wont be saved on DynamoDB.
* Future development, save the sum of views with timestamp and build a chart representing the timeline of this data.
* CompletableFutures were used to ease the management of threads.
* Spring Framework stack chosen as the most popular one.
* AWS DynamoDB database used as very easy to use, managed, and extremely cheap NoSQL database.

## To run the application locally

0. Install Java 8

1. Configure [AWS CLI](https://aws.amazon.com/cli/)

* Install the package `awscli` using `python-pip` (for the latest version)
* Create `~/.aws/credentials` and `~/.aws/config` properly

2. After cloning current repository run the app


    mvn spring-boot:run

The application will fetch the data from VimeoAPI and save it on AWS DynamoDB assigned to this task.
You can view the results being saved [accessing dynamo aws console](https://console.aws.amazon.com/dynamodb/home?region=us-east-1#tables:selected=ddb-table-sst67gy).

### To run unit/integration tests

    mvn clean package

## Author

Valter Henrique (valterhenrique85@gmail.com)
