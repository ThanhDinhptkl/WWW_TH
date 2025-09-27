package DAO;

import java.util.List;

import Entity.DienThoai;
import Entity.NhaCungCap;

public interface DAODienThoai {
	List<DienThoai> getAllDienThoai();
    DienThoai getDienThoaiById(int maDT);
    void saveDienThoai(DienThoai dienThoai);
    void deleteDienThoai(int maDT);
    List<DienThoai> searchDienThoai(String keyword);
}
