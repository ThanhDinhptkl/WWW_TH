package DAO;

import java.util.List;

import Entity.NhaCungCap;

public interface DAONhaCungCap {
	List<NhaCungCap> getAllNhaCungCap();
    NhaCungCap getNhaCungCapById(int maNCC);
    void saveNhaCungCap(NhaCungCap nhaCungCap);
    void deleteNhaCungCap(int maNCC);
    List<NhaCungCap> searchNhaCungCap(String keyword);
}
