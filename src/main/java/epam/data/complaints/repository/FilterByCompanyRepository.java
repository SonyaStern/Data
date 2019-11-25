package epam.data.complaints.repository;

import epam.data.complaints.model.FilterByCompanyResultModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FilterByCompanyRepository extends JpaRepository<FilterByCompanyResultModel, String> {

  //TODO: may do better
  @Query(value = "SELECT * FROM filter_by_company(:companyName)", nativeQuery = true)
  List<FilterByCompanyResultModel> getAllByCompany(@Param("companyName") String companyName);
}
