package epam.data.complaints.repository;

import epam.data.complaints.model.ComplaintModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ComplaintRepository extends JpaRepository<ComplaintModel, Long> {

  @Transactional
  @Modifying
  @Query(value = "TRUNCATE TABLE complaints", nativeQuery = true)
  void truncateTable();
}
