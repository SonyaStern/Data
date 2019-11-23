package epam.data.complaints.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "filter_by_date_view")
@AllArgsConstructor
@NoArgsConstructor
public class FilterByDateResultModel {

    @Id
    @Column(name = "product_name")
    private String productName;
    @Column(name = "number_of_complaints")
    private int numberOfComplaints;
//    private LocalDate received;
//    String numberOfComplaintsWithTimelyResponse;
//    String numberOfComplaintsDisputedByCustomer;
}
