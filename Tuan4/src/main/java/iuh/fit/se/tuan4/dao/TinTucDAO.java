package iuh.fit.se.tuan4.dao;

import iuh.fit.se.tuan4.entity.TINTUC;
import jakarta.persistence.EntityManager;

import java.util.List;

public class TinTucDAO {
    private EntityManager em;
    public TinTucDAO(EntityManager em) {
        this.em = em;
    }
    public List<TINTUC> getByDanhMuc(int madm) {
        return em.createQuery("SELECT t FROM TINTUC t WHERE t.danhmuc.madm = :madm", TINTUC.class)
                .setParameter("madm", madm)
                .getResultList();
    }

    public void addTinTuc(TINTUC tintuc) {
        em.getTransaction().begin();
        em.persist(tintuc);
        em.getTransaction().commit();
    }

    public void deleteTinTuc(int matt) {
        em.getTransaction().begin();
        TINTUC tintuc = em.find(TINTUC.class, matt);
        if (tintuc != null) {
            em.remove(tintuc);
        }
        em.getTransaction().commit();
    }
}
