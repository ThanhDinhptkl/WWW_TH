package iuh.fit.se.kt.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="nhacungcap")
public class NhaCungCap {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int maNCC;
    private String tenNCC;
    private String diaChi;
    private String soDienThoai;

    @OneToMany(mappedBy = "nhaCungCap", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DienThoai> danhSachDienThoai;

    public NhaCungCap() {
    }

    public NhaCungCap(int maNCC, String tenNCC, String diaChi, String soDienThoai, List<DienThoai> danhSachDienThoai) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.danhSachDienThoai = danhSachDienThoai;
    }

    public int getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(int maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public List<DienThoai> getDanhSachDienThoai() {
        return danhSachDienThoai;
    }

    public void setDanhSachDienThoai(List<DienThoai> danhSachDienThoai) {
        this.danhSachDienThoai = danhSachDienThoai;
    }

    @Override
    public String toString() {
        return "NhaCungCap{" +
                "maNCC=" + maNCC +
                ", tenNCC='" + tenNCC + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", danhSachDienThoai=" + danhSachDienThoai +
                '}';
    }
}
