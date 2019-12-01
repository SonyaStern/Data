package epam.data.movies.model;

import epam.data.movies.StringListType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "movies")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeDefs({
        @TypeDef(name = "arrayType", typeClass = StringListType.class),
})
public class MovieModel {

    @Type(type = "arrayType")
    private String[] genres;
    @Column(name = "main_actor")
    private String mainActor;
    @Id
    @Column(name = "movie_title")
    private String title;
    @Column(name = "imdb_score")
    private Float imdbScore;
}
