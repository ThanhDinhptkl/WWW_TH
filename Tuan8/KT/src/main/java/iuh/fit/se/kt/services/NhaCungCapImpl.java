package iuh.fit.se.kt.services;

import iuh.fit.se.kt.entities.NhaCungCap;
import iuh.fit.se.kt.repositories.NhaCungCapDao;
import jakarta.persistence.*;

import java.util.List;

public class NhaCungCapImpl implements NhaCungCapDao {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public NhaCungCapImpl(){
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
        try {
            return entityManager.createQuery(
                            "SELECT n FROM NhaCungCap n WHERE " +
                                    "LOWER(n.tenNCC) LIKE LOWER(:kw) OR " +
                                    "LOWER(n.diaChi) LIKE LOWER(:kw) OR " +
                                    "LOWER(n.soDienThoai) LIKE LOWER(:kw) OR " +
                                    "CAST(n.maNCC AS string) LIKE :kw",
                            NhaCungCap.class)
                    .setParameter("kw", "%" + keyword + "%")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
