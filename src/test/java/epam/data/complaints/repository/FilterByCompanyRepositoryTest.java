package epam.data.complaints.repository;

import epam.data.complaints.FileLoader;
import epam.data.complaints.model.FilterByCompanyResultModel;
import epam.data.configuration.DataIntegrationTest;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DataIntegrationTest
class FilterByCompanyRepositoryTest {

  @Autowired
  private FilterByCompanyRepository filterByCompanyRepository;
  @Autowired
  private FileLoader fileLoader;
  @Autowired
  private ComplaintRepository complaintRepository;

  @BeforeEach
  void setUp() throws SQLException {
    fileLoader.loadData();
  }

  @AfterEach
  void tearDown() {
    complaintRepository.truncateTable();
  }

  @Test
  void getAllByCompany() {
    List<FilterByCompanyResultModel> allByCompany = filterByCompanyRepository.getAllByCompany("Wells Fargo & Company");
    for (FilterByCompanyResultModel result : allByCompany) {
      System.out.println(result.getStateName() + " | "
          + result.getNumberOfComplaints());
    }

  }
}