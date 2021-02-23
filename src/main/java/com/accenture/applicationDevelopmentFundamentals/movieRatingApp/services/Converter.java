package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
class Converter {

    Scanner scanner = new Scanner(System.in);

    public String getReviewTitle(String movieTitle){
        System.out.printf("What is the title your review for %s?", movieTitle);
        return scanner.nextLine();
    }

    public String getReviewText() {
        System.out.println("Please, write your review for movie.");
        return scanner.nextLine();

    }

    //TODO: is there a way to limit this in scope 0-10?
    public int getMovieRating() {
        System.out.println("How many stars would you give movie? 0 is the lowest rating you can give," +
                "10 - the highest.");
        return scanner.nextInt();
    }

    public String getAuthor(){
        System.out.println("Please, enter your name:");
        return scanner.nextLine();
    }

}
