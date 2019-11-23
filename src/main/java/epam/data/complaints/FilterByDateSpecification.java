package epam.data.complaints;

import epam.data.complaints.filter.DateFilter;
import epam.data.complaints.model.FilterByDateResultModel;
import epam.data.complaints.model.FilterByDateResultModel_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class FilterByDateSpecification implements Specification<FilterByDateResultModel> {

    private DateFilter dateFilter;

    public FilterByDateSpecification(DateFilter dateFilter) {
        this.dateFilter = dateFilter;
    }

    @Override
    public Predicate toPredicate(Root<FilterByDateResultModel> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        final Path<String> productNamePath = root.get(FilterByDateResultModel_.productName);
        final Path<Integer> numberOfComplaints = root.get(FilterByDateResultModel_.numberOfComplaints);
//        final Path<LocalDate> received = root.get(FilterByDateResultModel_.received);

        final List<Predicate> predicates = new ArrayList<>();

//        if (dateFilter.getFromDate() != null) {
//            predicates.add(
//                    criteriaBuilder.and(
//                            criteriaBuilder.greaterThanOrEqualTo(received, dateFilter.getFromDate()),
//                            criteriaBuilder.lessThanOrEqualTo(received, dateFilter.getToDate())
//                    )
//            );
//        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
