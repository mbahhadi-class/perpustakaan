package id.starter.perustakaan.service;

import id.starter.perustakaan.PerustakaanApplication;
import id.starter.perustakaan.dao.BaseDao;
import id.starter.perustakaan.dao.LoanDao;
import id.starter.perustakaan.entity.Loan;
import id.starter.perustakaan.entity.StatusLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @Author "Noverry Ambo"
 * @start 11/1/2023
 */
@Service
public class LoanService extends BaseService<Loan> {
    @Autowired
    private LoanDao dao;

    @Override
    protected BaseDao<Loan> getDAO() {
        return dao;
    }

    @Transactional
    public Loan save(Loan entity){
        entity.setLoanDate(new Date());
        entity.setUser(PerustakaanApplication.getCurrentUser());

        return dao.save(entity);
    }


    @Transactional
    public Loan update(Loan entity) {
        if (entity.getId() != null) {
            Loan reference = getDAO().findReference(entity.getId());

            reference.setReturnDate(entity.getReturnDate() != null
                    ? entity.getReturnDate()
                    : new Date());

            reference.setStatus(reference.getStatus().equals(StatusLoan.BORROWED)
                    ? StatusLoan.RETURNED
                    : reference.getStatus());

            entity.setLoanDate(reference.getLoanDate());
            entity.setReturnDate(reference.getReturnDate());
            entity.setStatus(reference.getStatus());

            return entity;
        }
        return null;
    }

    @Transactional
    public Collection<Loan> findByDate(Loan entity, Date startDate, Date endDate) {
        Collection<Loan> result = dao.findByDate(entity, startDate, endDate);

        return result.size() > 0 ? result : new ArrayList<>();
    }

}
