package poly.edu.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the DonHang database table.
 * 
 */
@Entity
@NamedQuery(name="DonHang.findAll", query="SELECT d FROM DonHang d")
public class DonHang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ma_don_hang")
	private int maDonHang;

	@Column(name="ngay_don_hang")
	private Timestamp ngayDonHang;

	@Column(name="trang_thai")
	private String trangThai;

	//bi-directional many-to-one association to ChiTietDonHang
	@OneToMany(mappedBy="donHang")
	private List<ChiTietDonHang> chiTietDonHangs;

	//bi-directional many-to-one association to KhachHang
	@ManyToOne
	@JoinColumn(name="ma_khach_hang")
	private KhachHang khachHang;

	//bi-directional many-to-one association to NguoiDung
	@ManyToOne
	@JoinColumn(name="ma_nguoi_dung")
	private NguoiDung nguoiDung;

	public DonHang() {
	}

	public int getMaDonHang() {
		return this.maDonHang;
	}

	public void setMaDonHang(int maDonHang) {
		this.maDonHang = maDonHang;
	}

	public Timestamp getNgayDonHang() {
		return this.ngayDonHang;
	}

	public void setNgayDonHang(Timestamp ngayDonHang) {
		this.ngayDonHang = ngayDonHang;
	}

	public String getTrangThai() {
		return this.trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public List<ChiTietDonHang> getChiTietDonHangs() {
		return this.chiTietDonHangs;
	}

	public void setChiTietDonHangs(List<ChiTietDonHang> chiTietDonHangs) {
		this.chiTietDonHangs = chiTietDonHangs;
	}

	public ChiTietDonHang addChiTietDonHang(ChiTietDonHang chiTietDonHang) {
		getChiTietDonHangs().add(chiTietDonHang);
		chiTietDonHang.setDonHang(this);

		return chiTietDonHang;
	}

	public ChiTietDonHang removeChiTietDonHang(ChiTietDonHang chiTietDonHang) {
		getChiTietDonHangs().remove(chiTietDonHang);
		chiTietDonHang.setDonHang(null);

		return chiTietDonHang;
	}

	public KhachHang getKhachHang() {
		return this.khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public NguoiDung getNguoiDung() {
		return this.nguoiDung;
	}

	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

}