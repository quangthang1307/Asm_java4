package poly.edu.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DanhGia database table.
 * 
 */
@Entity
@NamedQuery(name="DanhGia.findAll", query="SELECT d FROM DanhGia d")
public class DanhGia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ma_danh_gia")
	private int maDanhGia;

	@Column(name="binh_luan")
	private String binhLuan;

	@Column(name="diem_danh_gia")
	private int diemDanhGia;

	//bi-directional many-to-one association to KhachHang
	@ManyToOne
	@JoinColumn(name="ma_khach_hang")
	private KhachHang khachHang;

	//bi-directional many-to-one association to SanPham
	@ManyToOne
	@JoinColumn(name="ma_san_pham")
	private SanPham sanPham;

	public DanhGia() {
	}

	public int getMaDanhGia() {
		return this.maDanhGia;
	}

	public void setMaDanhGia(int maDanhGia) {
		this.maDanhGia = maDanhGia;
	}

	public String getBinhLuan() {
		return this.binhLuan;
	}

	public void setBinhLuan(String binhLuan) {
		this.binhLuan = binhLuan;
	}

	public int getDiemDanhGia() {
		return this.diemDanhGia;
	}

	public void setDiemDanhGia(int diemDanhGia) {
		this.diemDanhGia = diemDanhGia;
	}

	public KhachHang getKhachHang() {
		return this.khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public SanPham getSanPham() {
		return this.sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

}