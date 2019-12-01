package epam.data.movies;

import epam.data.configuration.DataIntegrationTest;
import epam.data.movies.repository.MovieRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

@DataIntegrationTest
class MovieFileLoaderTest {

    @Autowired
    private MovieFileLoader movieFileLoader;
    @Autowired
    private MovieRepository movieRepository;

    @AfterEach
    void tearDown() {
        movieRepository.truncateTable();
    }

    @Test
    void loadData() throws SQLException {
        movieFileLoader.loadData();
        Assertions.assertNotEquals(0, movieRepository.findAll().size());
    }
}