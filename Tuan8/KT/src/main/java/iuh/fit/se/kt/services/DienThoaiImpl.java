package iuh.fit.se.kt.services;

import iuh.fit.se.kt.entities.DienThoai;
import iuh.fit.se.kt.repositories.DienThoaiDao;
import jakarta.persistence.*;

import java.util.List;

public class DienThoaiImpl implements DienThoaiDao {
    private final EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public DienThoaiImpl() {
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

            // ✅ KHÔNG merge NhaCungCap ở đây nữa
            if (dienThoai.getMaDT() == 0) {
                entityManager.persist(dienThoai);
            } else {
                entityManager.merge(dienThoai);
            }

            transaction.commit();
            System.out.println("✅ Đã lưu sản phẩm: " + dienThoai.getTenDT());
        } catch (Exception e) {
            System.err.println("❌ Lỗi khi lưu sản phẩm: " + e.getMessage());
            if (transaction.isActive()) transaction.rollback();
        }
    }

    @Override
    public void deleteDienThoai(int maDT) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            DienThoai dt = entityManager.find(DienThoai.class, maDT);
            if (dt != null) entityManager.remove(dt);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
        }
    }

    @Override
    public List<DienThoai> searchDienThoai(String keyword) {
        return entityManager.createQuery(
                        "SELECT d FROM DienThoai d WHERE LOWER(d.tenDT) LIKE LOWER(:kw)", DienThoai.class)
                .setParameter("kw", "%" + keyword + "%")
                .getResultList();
    }
}
