package id.starter.perustakaan.dao;

import id.starter.perustakaan.entity.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @Author "Noverry Ambo"
 * @start 11/1/2023
 */

@Repository
public class BookDao extends BaseDao<Book> {

    @Override
    public List<Predicate> predicates(Book param, CriteriaBuilder builder, Root<Book> root, boolean isCount) {
        List<Predicate> predicates =  super.predicates(param, builder, root, isCount);

        if (param != null) {
            if (param.getTitle() != null) {
                predicates.add(builder.like(root.get("title"), "%" + param.getTitle() + "%"));
            }

            if (param.getPublisher() != null) {
                predicates.add(builder.like(root.get("publisher"), "%" + param.getPublisher() + "%"));
            }

        }

        return predicates;
    }
}
