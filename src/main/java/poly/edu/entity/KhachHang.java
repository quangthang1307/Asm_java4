package poly.edu.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the KhachHang database table.
 * 
 */
@Entity
@NamedQuery(name="KhachHang.findAll", query="SELECT k FROM KhachHang k")
public class KhachHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ma_khach_hang")
	private int maKhachHang;

	@Column(name="dia_chi")
	private String diaChi;

	private String email;

	@Column(name="so_dien_thoai")
	private String soDienThoai;

	@Column(name="ten_khach_hang")
	private String tenKhachHang;

	//bi-directional many-to-one association to DanhGia
	@OneToMany(mappedBy="khachHang")
	private List<DanhGia> danhGias;

	//bi-directional many-to-one association to DonHang
	@OneToMany(mappedBy="khachHang")
	private List<DonHang> donHangs;

	public KhachHang() {
	}

	public int getMaKhachHang() {
		return this.maKhachHang;
	}

	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getDiaChi() {
		return this.diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return this.soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getTenKhachHang() {
		return this.tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public List<DanhGia> getDanhGias() {
		return this.danhGias;
	}

	public void setDanhGias(List<DanhGia> danhGias) {
		this.danhGias = danhGias;
	}

	public DanhGia addDanhGia(DanhGia danhGia) {
		getDanhGias().add(danhGia);
		danhGia.setKhachHang(this);

		return danhGia;
	}

	public DanhGia removeDanhGia(DanhGia danhGia) {
		getDanhGias().remove(danhGia);
		danhGia.setKhachHang(null);

		return danhGia;
	}

	public List<DonHang> getDonHangs() {
		return this.donHangs;
	}

	public void setDonHangs(List<DonHang> donHangs) {
		this.donHangs = donHangs;
	}

	public DonHang addDonHang(DonHang donHang) {
		getDonHangs().add(donHang);
		donHang.setKhachHang(this);

		return donHang;
	}

	public DonHang removeDonHang(DonHang donHang) {
		getDonHangs().remove(donHang);
		donHang.setKhachHang(null);

		return donHang;
	}

}