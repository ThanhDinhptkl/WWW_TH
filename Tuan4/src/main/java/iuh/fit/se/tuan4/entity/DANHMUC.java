package iuh.fit.se.tuan4.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DANHMUC")
public class DANHMUC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int madm;
    @Column(nullable = false, length = 100)
    private String tendanhmuc;
    private String nguoiquanly;
    private String ghichu;

    public int getMadm() {
        return madm;
    }

    public void setMadm(int madm) {
        this.madm = madm;
    }

    public String getTendanhmuc() {
        return tendanhmuc;
    }

    public void setTendanhmuc(String tendanhmuc) {
        this.tendanhmuc = tendanhmuc;
    }

    public String getNguoiquanly() {
        return nguoiquanly;
    }

    public void setNguoiquanly(String nguoiquanly) {
        this.nguoiquanly = nguoiquanly;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public DANHMUC() {
    }

    public DANHMUC(int madm, String tendanhmuc, String nguoiquanly, String ghichu) {
        this.madm = madm;
        this.tendanhmuc = tendanhmuc;
        this.nguoiquanly = nguoiquanly;
        this.ghichu = ghichu;
    }

    @Override
    public String toString() {
        return "DANHMUC{" +
                "madm=" + madm +
                ", tendanhmuc='" + tendanhmuc + '\'' +
                ", nguoiquanly='" + nguoiquanly + '\'' +
                ", ghichu='" + ghichu + '\'' +
                '}';
    }
}
