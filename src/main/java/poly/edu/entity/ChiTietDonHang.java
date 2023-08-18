package poly.edu.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ChiTietDonHang database table.
 * 
 */
@Entity
@NamedQuery(name="ChiTietDonHang.findAll", query="SELECT c FROM ChiTietDonHang c")
public class ChiTietDonHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ma_chi_tiet_don_hang")
	private int maChiTietDonHang;

	@Column(name="so_luong_da_dat")
	private int soLuongDaDat;

	@Column(name="so_luong_da_giao")
	private int soLuongDaGiao;

	//bi-directional many-to-one association to DonHang
	@ManyToOne
	@JoinColumn(name="ma_don_hang")
	private DonHang donHang;

	//bi-directional many-to-one association to SanPham
	@ManyToOne
	@JoinColumn(name="ma_san_pham")
	private SanPham sanPham;

	public ChiTietDonHang() {
	}

	public int getMaChiTietDonHang() {
		return this.maChiTietDonHang;
	}

	public void setMaChiTietDonHang(int maChiTietDonHang) {
		this.maChiTietDonHang = maChiTietDonHang;
	}

	public int getSoLuongDaDat() {
		return this.soLuongDaDat;
	}

	public void setSoLuongDaDat(int soLuongDaDat) {
		this.soLuongDaDat = soLuongDaDat;
	}

	public int getSoLuongDaGiao() {
		return this.soLuongDaGiao;
	}

	public void setSoLuongDaGiao(int soLuongDaGiao) {
		this.soLuongDaGiao = soLuongDaGiao;
	}

	public DonHang getDonHang() {
		return this.donHang;
	}

	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}

	public SanPham getSanPham() {
		return this.sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

}