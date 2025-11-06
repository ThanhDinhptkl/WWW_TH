package iuh.fit.se.kt.repositories;

import iuh.fit.se.kt.entities.DienThoai;
import jakarta.persistence.EntityManager;

import java.util.List;

public interface DienThoaiDao {
    List<DienThoai> getAllDienThoai();
    DienThoai getDienThoaiById(int maDT);
    void saveDienThoai(DienThoai dienThoai);
    void deleteDienThoai(int maDT);
    List<DienThoai> searchDienThoai(String keyword);

    // ✅ Dùng đúng kiểu EntityManager
    EntityManager getEntityManager();
}
