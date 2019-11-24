package epam.data.complaints.repository;

import epam.data.complaints.model.FilterByCompanyResultModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilterByCompanyRepository extends JpaRepository<FilterByCompanyResultModel, String> {
}
