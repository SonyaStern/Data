package epam.data.complaints.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "filter_by_company")
@AllArgsConstructor
@NoArgsConstructor
public class FilterByCompanyResultModel {

  @Id
  @Column(name = "state_name")
  private String stateName;
  @Column(name = "number_of_complaints")
  private int numberOfComplaints;
}
