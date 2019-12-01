package epam.data.movies;

import epam.data.movies.model.MovieModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static epam.data.utils.DataConstants.URL;
import static epam.data.utils.DataConstants.USER_PASS;

@Slf4j
@Component
public class MovieService {

    public List<MovieModel> getMoviesByGenres(String title, String... genres) {

        List<MovieModel> result = new ArrayList<>();

        String sql = "SELECT *, similarity(movie_title, ?) "
                + "FROM movies "
                + "WHERE movie_title % ? AND genres @> ? "
                + "ORDER BY imdb_score DESC";

        try (Connection connection = DriverManager.getConnection(URL, USER_PASS, USER_PASS);
             PreparedStatement ps = connection.prepareStatement(sql)) {

            Array genresArray = connection.createArrayOf("varchar", genres);
            ps.setString(1, title);
            ps.setString(2, title);
            ps.setArray(3, genresArray);

            try (ResultSet rs = ps.executeQuery()) {
                System.out.println(ps.toString());
                while (rs.next()) {
                    result.add(new MovieModel((String[]) rs.getArray("genres").getArray(),
                            rs.getString("main_actor"),
                            rs.getString("movie_title"),
                            rs.getFloat("imdb_score")));
                }
            }

        } catch (SQLException e) {
            log.error("Unknown error : {}", e.getMessage());
        }
        return result;

    }
}
