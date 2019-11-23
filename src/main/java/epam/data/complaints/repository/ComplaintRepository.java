package epam.data.complaints.repository;

import epam.data.complaints.model.ComplaintModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<ComplaintModel, Long> {
}
