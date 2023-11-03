package id.starter.perustakaan.service;

import id.starter.perustakaan.dao.BaseDao;
import id.starter.perustakaan.entity.BaseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * @Author "Noverry Ambo"
 * @start 11/1/2023
 */

public abstract class BaseService<T extends BaseEntity<T>> {

    protected abstract BaseDao<T> getDAO();

    @Transactional(readOnly = true)
    public T findOne(T param){
        return getDAO().findOne(param);
    }

    @Transactional(readOnly = true)
    public Collection<T> find(T param, int offset, int limit){
        return getDAO().find(param, offset, limit);
    }

    public long count(T param) {
        return getDAO().count(param);
    }

    @Transactional
    public T save(T entity){
        return getDAO().save(entity);
    }

    @Transactional
    public T update(T entity){
        if (entity.getId() != null){
            return getDAO().update(entity);
        }
        return null;
    }

    @Transactional
    public boolean delete(Long id){
        return getDAO().delete(getDAO().findReference(id)) != null;
    }

}
