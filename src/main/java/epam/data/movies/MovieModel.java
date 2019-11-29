package epam.data.movies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "movies")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieModel {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String mainActor;
    private Float imdbScore;
    private String[] genres;
}
