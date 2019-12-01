package epam.data.movies;

import epam.data.movies.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.postgresql.PGConnection;
import org.postgresql.copy.CopyManager;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static epam.data.utils.DataConstants.URL;
import static epam.data.utils.DataConstants.USER_PASS;

@Component
@RequiredArgsConstructor
public class MovieFileLoader {

    private final MovieRepository movieRepository;

    @SuppressWarnings("Duplicates")
    public void loadData() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER_PASS, USER_PASS);
        CopyManager copyManager = connection.unwrap(PGConnection.class).getCopyAPI();

        String copyCommand = "COPY temp_movies "
                + "FROM STDIN "
                + "WITH (DELIMITER ',', FORMAT csv, HEADER)";

        try {
            copyManager.copyIn(copyCommand, getClass().getClassLoader().getResource("movie_metadata.csv").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        movieRepository.insertData();
    }
}
