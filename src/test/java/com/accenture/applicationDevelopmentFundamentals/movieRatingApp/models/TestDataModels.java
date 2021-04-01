package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models;

public interface TestDataModels {
    String baseURL = "http://www.omdbapi.com/?apikey=38982f53";
    String searchMovieByTitle = "&s=Maltese%20Falcon";

    String getSearchMovieByIMDBId = "&i=";

    String movieSearchResultByTitleSample = "{\"Search\":[{\"Title\":\"The Maltese Falcon\"," +
            "\"Year\":\"1941\",\"imdbID\":\"tt0033870\",\"Type\":\"movie\"," +
            "\"Poster\":\"https://m.media-amazon.com/images/M/MV5BZjIwNGM1ZTUtOThjYS00NDdiLTk2ZDYtNGY5YjJkNzliM2JjL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMDI2NDg0NQ@@._V1_SX300.jpg\"}," +
            "{\"Title\":\"The Maltese Falcon\",\"Year\":\"1931\",\"imdbID\":\"tt0022111\"," +
            "\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BY2U3ODNkMTAtOGQ3MS00NTU0LWJiZTQtNzMxZDM3NmFmYjhkXkEyXkFqcGdeQXVyMjUxODE0MDY@._V1_SX300.jpg\"}," +
            "{\"Title\":\"The Maltese Falcon: One Magnificent Bird\",\"Year\":\"2006\"," +
            "\"imdbID\":\"tt0892079\",\"Type\":\"movie\"," +
            "\"Poster\":\"https://m.media-amazon.com/images/M/MV5BOWQyNTdlYjEtYWM5Zi00YzM0LTk3ZTAtNjUwNTQzOTZiYmE1XkEyXkFqcGdeQXVyOTc0ODU3NzA@._V1_SX300.jpg\"}," +
            "{\"Title\":\"Joe Camilleri: Australia's Maltese Falcon\",\"Year\":\"2011\"," +
            "\"imdbID\":\"tt1950213\",\"Type\":\"movie\"," +
            "\"Poster\":\"https://m.media-amazon.com/images/M/MV5BYTAwZjg3ZjctZjUzMy00YTIwLThhYTAtN2U1MjgyMmY3MzE1XkEyXkFqcGdeQXVyNzcxMzE5Nw@@._V1_SX300.jpg\"}]," +
            "\"totalResults\":\"4\",\"Response\":\"True\"}\n";

    String movieSearchResultByIdSample = "{\n" +
            "    \"Title\": \"The Maltese Falcon\",\n" +
            "    \"Year\": \"1941\",\n" +
            "    \"Rated\": \"Passed\",\n" +
            "    \"Released\": \"18 Oct 1941\",\n" +
            "    \"Runtime\": \"100 min\",\n" +
            "    \"Genre\": \"Crime, Film-Noir, Mystery, Romance\",\n" +
            "    \"Director\": \"John Huston\",\n" +
            "    \"Writer\": \"John Huston (screen play by), Dashiell Hammett (based upon the novel by)\",\n" +
            "    \"Actors\": \"Humphrey Bogart, Mary Astor, Gladys George, Peter Lorre\",\n" +
            "    \"Plot\": \"A private detective takes on a case that involves him with three eccentric criminals, a gorgeous liar, and their quest for a priceless statuette.\",\n" +
            "    \"Language\": \"English\",\n" +
            "    \"Country\": \"USA\",\n" +
            "    \"Awards\": \"Nominated for 3 Oscars. Another 5 wins.\",\n" +
            "    \"Poster\": \"https://m.media-amazon.com/images/M/MV5BZjIwNGM1ZTUtOThjYS00NDdiLTk2ZDYtNGY5YjJkNzliM2JjL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMDI2NDg0NQ@@._V1_SX300.jpg\",\n" +
            "    \"Ratings\": [\n" +
            "        {\n" +
            "            \"Source\": \"Internet Movie Database\",\n" +
            "            \"Value\": \"8.0/10\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"Source\": \"Rotten Tomatoes\",\n" +
            "            \"Value\": \"100%\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"Source\": \"Metacritic\",\n" +
            "            \"Value\": \"96/100\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"Metascore\": \"96\",\n" +
            "    \"imdbRating\": \"8.0\",\n" +
            "    \"imdbVotes\": \"149,697\",\n" +
            "    \"imdbID\": \"tt0033870\",\n" +
            "    \"Type\": \"movie\",\n" +
            "    \"DVD\": \"N/A\",\n" +
            "    \"BoxOffice\": \"N/A\",\n" +
            "    \"Production\": \"Warner Brothers, First National Pictures\",\n" +
            "    \"Website\": \"N/A\",\n" +
            "    \"Response\": \"True\"\n" +
            "}";

    String reviewSample = "{\"movieId\":\"tt0033870\"," +
            "\"movieRating\":10,\"titleForReview\":\"Classics\"," +
            "\"reviewText\":\"Maltese Falcon.Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum et " +
            "semper quam. Fusce lorem mi, bibendum eu justo vitae, bibendum facilisis nibh.Ut a mollis justo. Curabitur " +
            "elit diam, laoreet eu ultrices vel,feugiat in neque. Morbi neque elit, ultricies viverra mi eu, accumsan " +
            "ornare orci.Maecenas congue mauris sed nisi pulvinar ultrices. Quisque consequat, enim tincidunt malesuada" +
            " semper,orci nibh tempus nisi, eu volutpat ex risus ac massa. Nam semper eleifend nisi vel iaculis. Donec" +
            " ullamcorper rhoncus massa et iaculis. Mauris consectetur nunc vitae leo venenatis blandit. In tincidunt " +
            "mauris nibh, vitae rhoncus metus posuere rutrum. Suspendisse ultrices pulvinar hendrerit. Quisque commodo " +
            "volutpat tempor. Proin iaculis mollis odio non facilisis.Praesent accumsan sed libero quis condimentum." +
            " Integer ut tellus fermentum, congue magna id, iaculis tellus. Nullam eu lacus interdum, euismod mauris a," +
            " congue ante. Duis sit amet erat id turpis tincidunt blandit. Nulla facilisi. Ut risus risus, consequat eu " +
            "orci in, tincidunt finibus odio. Phasellus sit amet mi nec dolor venenatis malesuada rutrum ac augue. Nunc " +
            "ligula lacus, bibendum eu interdum eu, aliquam sodales elit. Maecenas imperdiet ac augue nec lobortis." +
            " Donec aliquet massa nec lectus iaculis, sed pharetra neque bibendum. Nullam finibus, nunc in pulvinar fringilla," +
            " dolor ipsum viverra sem, vel ullamcorper lacus enim et ante.\"," +
            "\"reviewAuthor\":\"FirstReviewer\"}";

    Movie getMalteseFalconMovie = new Movie("tt0033870","Maltese Falcon","1941");
}
