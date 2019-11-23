package epam.data.complaints.repository;

import epam.data.complaints.model.ComplaintModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<ComplaintModel, Long> {

//  @Query(value = "COPY complaint(received, product_name, sub_product, issue, sub_issue, "
//      + "narrative, public_response, company, state_name, zip_code, tags, consent_provided, submitted_via, "
//      + "sent, response_to_consumer, timely_response, consumer_disputed, id) "
//      + "FROM STDIN "
//      + "WITH (DELIMITER ',', FORMAT csv, HEADER)"
//      + ":file", nativeQuery = true)
//  void copyCsv(@Param("file") String file);

//    @Query(value = "select product_name, count(*) from complaints "
////            + "where received > :fromDate and received < :toDate "
//            + "group by product_name ", nativeQuery = true)
//    List<FilterByDateResultModel> filterByDate(@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);
}
