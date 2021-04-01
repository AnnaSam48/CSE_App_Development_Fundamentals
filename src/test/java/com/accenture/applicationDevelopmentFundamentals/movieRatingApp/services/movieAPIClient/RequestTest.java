package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services.movieAPIClient;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Movie;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.TestDataModels;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.repositories.MovieRepository;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.repositories.ReviewRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { Request.class })
public class RequestTest {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private MockRestServiceServer mockRestServiceServer;

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    Request movieRequestService;

    @MockBean
    MovieRepository movieRepository;

    @MockBean
    ReviewRepository reviewRepository;

    @BeforeEach
    public void setUp(){
        mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void getPreparedSearchKeywordTest(){
        String preparedSearchKeyword = movieRequestService.getPreparedSearchKeyword("Miss Peregrine's Home for Peculiar Children");
        assertEquals("Miss%20Peregrine's%20Home%20for%20Peculiar%20Children",preparedSearchKeyword);
    }


    @Test
    public void getJSONResponseTest() throws Exception {
        Request movieRequest = new Request();
        mockRestServiceServer.expect(ExpectedCount.once(), requestTo(new URI(getBaseURL() + getMoviesByTitleRequestURL())))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(objectMapper.writeValueAsString(movieRequest))
                );

        String requestToExternalAPI = movieRequestService.getJsonResponse(new URL(getBaseURL() + getMoviesByTitleRequestURL()));
        assertEquals(requestToExternalAPI, getJSONResponseStringSearchByTitle());
    }

    @Test
    public void getMovieByIdTest() throws Exception {
        String movieId = "tt0033870";
        URL request = new URL(getBaseURL() + getMovieByIdRequestURL() + movieId);
        String response = getJSONResponseStringSearchById();
        Movie malteseFalconMovie = getTestMovieObject();
        when(movieRequestService.getJsonResponse(request)).thenReturn(response);
       assertEquals(malteseFalconMovie.getImdbID(), movieRequestService.getMovieById(movieId).getImdbID());
        assertEquals(malteseFalconMovie.getTitle(), movieRequestService.getMovieById(movieId).getTitle());
        assertEquals(malteseFalconMovie.getYear(), movieRequestService.getMovieById(movieId).getYear());

    }

    @Test
    public void getMovieByTitleSearchResultsTest() throws Exception {
        String searchedMovie = "Maltese Falcon";
        String modifiedSearch = "Maltese+Falcon";
        when(movieRequestService.getPreparedSearchKeyword(searchedMovie)).thenReturn(modifiedSearch);
        URL url = new URL(getBaseURL() + getMoviesByTitleRequestURL() + modifiedSearch);

        String movieSearchJSONResponse = getJSONResponseStringSearchByTitle();
        when(movieRequestService.getJsonResponse(url)).thenReturn(movieSearchJSONResponse);

     //   assertEquals(4, movieRequestService.getMoviesByTitle(searchedMovie).size());
    }

    public String getBaseURL(){
        return TestDataModels.baseURL;
    }

    public String getMoviesByTitleRequestURL(){
        return TestDataModels.searchMovieByTitle;
    }

    public String getMovieByIdRequestURL(){
        return TestDataModels.getSearchMovieByIMDBId;
    }

    public Movie getTestMovieObject(){
       return TestDataModels.getMalteseFalconMovie;
    }

    public String getJSONResponseStringSearchByTitle(){
        return TestDataModels.movieSearchResultByTitleSample;
    }

    public String getJSONResponseStringSearchById(){ return TestDataModels.movieSearchResultByIdSample;}
}
