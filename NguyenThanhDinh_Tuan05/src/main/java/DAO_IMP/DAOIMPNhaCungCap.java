package DAO_IMP;

import java.util.List;

import DAO.DAONhaCungCap;
import Entity.NhaCungCap;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class DAOIMPNhaCungCap implements DAONhaCungCap {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public DAOIMPNhaCungCap() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("shopdt");
        this.entityManager = emf.createEntityManager();
    }

    @Override
    public List<NhaCungCap> getAllNhaCungCap() {
        return entityManager.createQuery("FROM NhaCungCap", NhaCungCap.class).getResultList();
    }

    @Override
    public NhaCungCap getNhaCungCapById(int maNCC) {
        return entityManager.find(NhaCungCap.class, maNCC);
    }

    @Override
    public void saveNhaCungCap(NhaCungCap nhaCungCap) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            if (nhaCungCap.getMaNCC() == 0) {
                entityManager.persist(nhaCungCap);
            } else {
                entityManager.merge(nhaCungCap);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void deleteNhaCungCap(int maNCC) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            NhaCungCap nhaCungCap = entityManager.find(NhaCungCap.class, maNCC);
            if (nhaCungCap != null) {
                entityManager.remove(nhaCungCap);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<NhaCungCap> searchNhaCungCap(String keyword) {
        String jpql = "SELECT n FROM NhaCungCap n WHERE "
                + "CAST(n.maNCC AS string) LIKE :keyword OR "
                + "n.tenNCC LIKE :keyword OR "
                + "n.diaChi LIKE :keyword OR "
                + "n.soDienThoai LIKE :keyword";

        TypedQuery<NhaCungCap> query = entityManager.createQuery(jpql, NhaCungCap.class);
        query.setParameter("keyword", "%" + keyword + "%");
        
        return query.getResultList();
    }
    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
