package epam.data.movies.repository;

import epam.data.configuration.DataIntegrationTest;
import epam.data.movies.MovieFileLoader;
import epam.data.movies.model.MovieModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

@DataIntegrationTest
class MovieRepositoryTest {

    @Autowired
    private MovieFileLoader movieFileLoader;

    @Autowired
    private MovieRepository movieRepository;

    @BeforeEach
    void setUp() throws SQLException {
        movieFileLoader.loadData();
    }

    @AfterEach
    void tearDown() {
        movieRepository.truncateTable();
    }

    @Test
    void searchByTitle() {
        List<MovieModel> byTitle = movieRepository.searchByTitle("big heroes");
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

    @Test
    void searchByTitleWithGenres() {
//        String[] array = {"Sci-Fi"};
        List<MovieModel> byTitle = movieRepository.searchByTitle("big heroes", "Action Adventure");
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