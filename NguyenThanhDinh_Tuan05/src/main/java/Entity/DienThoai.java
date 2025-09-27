package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="dienthoai")
public class DienThoai {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int MaDT;
	private String TenDT;
	private int MaNCC;
	private int NamSX;
	private String CauHinh;
	private String HinhAnh;
	
	
	
	public DienThoai(int maDT, String tenDT, int maNCC, int namSX, String cauHinh, String hinhAnh) {
		super();
		MaDT = maDT;
		TenDT = tenDT;
		MaNCC = maNCC;
		NamSX = namSX;
		CauHinh = cauHinh;
		HinhAnh = hinhAnh;
	}
	public DienThoai() {
		super();
	}
	public int getMaDT() {
		return MaDT;
	}
	public void setMaDT(int maDT) {
		MaDT = maDT;
	}
	public String getTenDT() {
		return TenDT;
	}
	public void setTenDT(String tenDT) {
		TenDT = tenDT;
	}
	public int getMaNCC() {
		return MaNCC;
	}
	public void setMaNCC(int maNCC) {
		MaNCC = maNCC;
	}
	public int getNamSX() {
		return NamSX;
	}
	public void setNamSX(int namSX) {
		NamSX = namSX;
	}
	public String getCauHinh() {
		return CauHinh;
	}
	public void setCauHinh(String cauHinh) {
		CauHinh = cauHinh;
	}
	public String getHinhAnh() {
		return HinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		HinhAnh = hinhAnh;
	}
	@Override
	public String toString() {
		return "DienThoai [MaDT=" + MaDT + ", TenDT=" + TenDT + ", MaNCC=" + MaNCC + ", NamSX=" + NamSX + ", CauHinh="
				+ CauHinh + ", HinhAnh=" + HinhAnh + "]";
	}
}
