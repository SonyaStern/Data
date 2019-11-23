package epam.data.complaints.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(FilterByDateResultModel.class)
public class FilterByDateResultModel_ {
    public static volatile SingularAttribute<FilterByDateResultModel, String> productName;
    public static volatile SingularAttribute<FilterByDateResultModel, Integer> numberOfComplaints;
//    public static volatile SingularAttribute<FilterByDateResultModel, LocalDate> received;
}
