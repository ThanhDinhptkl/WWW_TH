package iuh.fit.se.kt.repositories;

import iuh.fit.se.kt.entities.NhaCungCap;

import java.util.List;

public interface NhaCungCapDao {
    List<NhaCungCap> getAllNhaCungCap();
    NhaCungCap getNhaCungCapById(int maNCC);
    void saveNhaCungCap(NhaCungCap nhaCungCap);
    void deleteNhaCungCap(int maNCC);
    List<NhaCungCap> searchNhaCungCap(String keyword);
}
