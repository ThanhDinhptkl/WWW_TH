package iuh.fit.se.tuan4.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TINTUC")
public class TINTUC {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int matt;

    @Column(nullable = false, length = 200)
    private String tieude;

    @Column(nullable = false, length = 255)
    private String noidungtt;

    @Column(nullable = false)
    private String lienket;

    @ManyToOne
    @JoinColumn(name = "madm")
    private DANHMUC danhmuc;

    public int getMatt() {
        return matt;
    }

    public void setMatt(int matt) {
        this.matt = matt;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getNoidungtt() {
        return noidungtt;
    }

    public void setNoidungtt(String noidungtt) {
        this.noidungtt = noidungtt;
    }

    public String getLienket() {
        return lienket;
    }

    public void setLienket(String lienket) {
        this.lienket = lienket;
    }

    public DANHMUC getDanhmuc() {
        return danhmuc;
    }

    public void setDanhmuc(DANHMUC danhmuc) {
        this.danhmuc = danhmuc;
    }

    public TINTUC() {
    }

    public TINTUC(int matt, String tieude, String noidungtt, String lienket, DANHMUC danhmuc) {
        this.matt = matt;
        this.tieude = tieude;
        this.noidungtt = noidungtt;
        this.lienket = lienket;
        this.danhmuc = danhmuc;
    }

    @Override
    public String toString() {
        return "TINTUC{" +
                "matt=" + matt +
                ", tieude='" + tieude + '\'' +
                ", noidungtt='" + noidungtt + '\'' +
                ", lienket='" + lienket + '\'' +
                ", danhmuc=" + danhmuc +
                '}';
    }
}
