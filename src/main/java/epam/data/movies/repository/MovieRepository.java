package epam.data.movies.repository;

import epam.data.movies.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieModel, String> {

    @Transactional
    @Modifying
    @Query(value = "insert into movies (genres, main_actor, movie_title, imdb_score) "
            + "select string_to_array(genres, '|'), actor_1_name, movie_title, imdb_score from temp_movies",
            nativeQuery = true)
    void insertData();

    @Transactional
    @Modifying
    @Query(value = "TRUNCATE TABLE movies", nativeQuery = true)
    void truncateTable();

    @Query(value = "SELECT *, similarity(movie_title, :title) "
            + "FROM movies "
            + "WHERE movie_title % :title "
            + "ORDER BY imdb_score DESC",
            nativeQuery = true)
    List<MovieModel> searchByTitle(@Param("title") String title);

    @Query(value = "SELECT *, similarity(movie_title, $1) "
            + "FROM movies m "
            + "WHERE m.movie_title % :title AND :genres = ANY(genres) "
            + "ORDER BY imdb_score DESC",
            nativeQuery = true)
    List<MovieModel> searchByTitle(@Param("title") String title, @Param("genres") String genres);
}
