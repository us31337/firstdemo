package z.firstdemo.dao.impl;

import org.springframework.stereotype.Repository;
import z.firstdemo.dao.EmailDao;
import z.firstdemo.entity.EmailAddress;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmailDaoImpl implements EmailDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<EmailAddress> getByFullName(String emailFullName) {
        Query query = em.createQuery("select e from EmailAddress e where lower(e.email) = :emailFullName");
        query.setParameter("emailFullName", emailFullName);
        List<EmailAddress> list = query.getResultList();
        return list;
    }

    @Override
    @Transactional
    public void save(EmailAddress emailAddress) {
        em.persist(emailAddress);
    }
}
