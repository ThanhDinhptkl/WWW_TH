package Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="nhacungcap")
public class NhaCungCap {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int MaNCC;
	private String TenNCC;
	private String DiaChi;
	private String SoDienThoai;
	
	public int getMaNCC() {
		return MaNCC;
	}
	public void setMaNCC(int maNCC) {
		MaNCC = maNCC;
	}
	public String getTenNCC() {
		return TenNCC;
	}
	public void setTenNCC(String tenNCC) {
		TenNCC = tenNCC;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}
	
	public NhaCungCap(int maNCC, String tenNCC, String diaChi, String soDienThoai) {
		super();
		MaNCC = maNCC;
		TenNCC = tenNCC;
		DiaChi = diaChi;
		SoDienThoai = soDienThoai;
		
	}
	public NhaCungCap() {
		super();
	}
	@Override
	public String toString() {
		return "NhaCungCap [MaNCC=" + MaNCC + ", TenNCC=" + TenNCC + ", DiaChi=" + DiaChi + ", SoDienThoai="
				+ SoDienThoai + "]";
	}
	
}
