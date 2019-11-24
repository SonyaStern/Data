package epam.data.complaints.repository;

import epam.data.complaints.model.FilterByDateResultModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FilterByDateRepository extends JpaRepository<FilterByDateResultModel, String> {

    @Query(value = "SELECT * FROM filter_by_date(:to, :from, 'Yes', 'Yes')", nativeQuery = true)
    List<FilterByDateResultModel> getAllByDate(@Param("to") LocalDate from, @Param("from") LocalDate to);
}
