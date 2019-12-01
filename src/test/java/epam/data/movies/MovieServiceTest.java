package epam.data.movies;

import epam.data.configuration.DataIntegrationTest;
import epam.data.movies.model.MovieModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

@DataIntegrationTest
class MovieServiceTest {

    @Autowired
    private MovieFileLoader movieFileLoader;

    @Autowired
    private MovieService movieService;

    @BeforeEach
    void setUp() throws SQLException {
        movieFileLoader.loadData();
    }

    @Test
    void getMoviesByGenres() {
        List<MovieModel> byTitle = movieService.getMoviesByGenres("big heroes", "Action", "Sci-Fi");
        for (MovieModel result : byTitle) {

            System.out.print(result.getImdbScore() + " | "
                    + result.getTitle() + " | "
                    + result.getMainActor() + " | ");
            for (int i = 0; i < result.getGenres().length; i++) {
                System.out.print(result.getGenres()[i] + " ");
            }
            System.out.println("");
        }
        Assertions.assertNotEquals(0, byTitle.size());
    }
}