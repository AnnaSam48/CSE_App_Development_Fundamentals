package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class UsersInputService {

    Logger serviceLogger = LoggerFactory.getLogger(UsersInputService.class);
    Scanner scanner = new Scanner(System.in);

    public String getMovieTitle(){
        serviceLogger.info("Please enter movie you want to search for: ");
        return scanner.nextLine();
    }

    public String getReviewTitle(){
        serviceLogger.info("What is the title your review for %s? The limit is from 3 to 160 characters.");
        return scanner.nextLine();

    }

    public int getUsersRatingForMovie() {
        serviceLogger.info("How many stars would you give movie? 0 is the lowest rating you can give," +
                "10 - the highest.");
        return scanner.nextInt();

    }

    public String getReviewText(){
        serviceLogger.info("Please, write your review for movie. Min. char. count 2, max 65 535.");
        return scanner.nextLine();

    }

    public String getAuthor(){
        serviceLogger.info("Please, enter your name:");
        return scanner.nextLine();
    }

}
