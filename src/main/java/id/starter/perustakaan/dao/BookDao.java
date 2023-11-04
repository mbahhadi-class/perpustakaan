package id.starter.perustakaan.dao;

import id.starter.perustakaan.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author "Noverry Ambo"
 * @start 11/1/2023
 */

@Repository
public class BookDao extends BaseDao<Book> {

    @Autowired
    private EntityManager entityManager;

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


    @Transactional
    public Book saveBooks(Book entity) {

        if (!entity.getTitle().isEmpty() && !entity.getAuthor().isEmpty()){
            entityManager.persist(entity);
            return entity;
        }

        return null;
    }


}
