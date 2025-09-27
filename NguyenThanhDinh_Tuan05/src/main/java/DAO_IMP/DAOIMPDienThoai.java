package DAO_IMP;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import DAO.DAODienThoai;
import Entity.DienThoai;

public class DAOIMPDienThoai implements DAODienThoai {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public DAOIMPDienThoai() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("shopdt");
        this.entityManager = emf.createEntityManager();
    }

    @Override
    public List<DienThoai> getAllDienThoai() {
        return entityManager.createQuery("FROM DienThoai", DienThoai.class).getResultList();
    }

    @Override
    public DienThoai getDienThoaiById(int maDT) {
        return entityManager.find(DienThoai.class, maDT);
    }

    @Override
    public void saveDienThoai(DienThoai dienThoai) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            if (dienThoai.getMaDT() == 0) {
                entityManager.persist(dienThoai);
            } else {
                entityManager.merge(dienThoai);
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
    public void deleteDienThoai(int maDT) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            DienThoai dienThoai = entityManager.find(DienThoai.class, maDT);
            if (dienThoai != null) {
                entityManager.remove(dienThoai);
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
    public List<DienThoai> searchDienThoai(String keyword) {
        return entityManager.createQuery("FROM DienThoai WHERE tenDT LIKE :keyword", DienThoai.class)
                .setParameter("keyword", "%" + keyword + "%")
                .getResultList();
    }
    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
