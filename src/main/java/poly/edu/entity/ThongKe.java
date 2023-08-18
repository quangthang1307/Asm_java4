package poly.edu.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ThongKe database table.
 * 
 */
@Entity
@NamedQuery(name="ThongKe.findAll", query="SELECT t FROM ThongKe t")
public class ThongKe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ma_thong_ke")
	private int maThongKe;

	@Column(name="diem_danh_gia_trung_binh")
	private BigDecimal diemDanhGiaTrungBinh;

	@Column(name="doanh_thu")
	private BigDecimal doanhThu;

	@Column(name="ngay_thong_ke")
	private Date ngayThongKe;

	@Column(name="tong_don_hang")
	private int tongDonHang;

	@Column(name="tong_khach_hang")
	private int tongKhachHang;

	@Column(name="tong_san_pham")
	private int tongSanPham;

	public ThongKe() {
	}

	public int getMaThongKe() {
		return this.maThongKe;
	}

	public void setMaThongKe(int maThongKe) {
		this.maThongKe = maThongKe;
	}

	public BigDecimal getDiemDanhGiaTrungBinh() {
		return this.diemDanhGiaTrungBinh;
	}

	public void setDiemDanhGiaTrungBinh(BigDecimal diemDanhGiaTrungBinh) {
		this.diemDanhGiaTrungBinh = diemDanhGiaTrungBinh;
	}

	public BigDecimal getDoanhThu() {
		return this.doanhThu;
	}

	public void setDoanhThu(BigDecimal doanhThu) {
		this.doanhThu = doanhThu;
	}

	public Date getNgayThongKe() {
		return this.ngayThongKe;
	}

	public void setNgayThongKe(Date ngayThongKe) {
		this.ngayThongKe = ngayThongKe;
	}

	public int getTongDonHang() {
		return this.tongDonHang;
	}

	public void setTongDonHang(int tongDonHang) {
		this.tongDonHang = tongDonHang;
	}

	public int getTongKhachHang() {
		return this.tongKhachHang;
	}

	public void setTongKhachHang(int tongKhachHang) {
		this.tongKhachHang = tongKhachHang;
	}

	public int getTongSanPham() {
		return this.tongSanPham;
	}

	public void setTongSanPham(int tongSanPham) {
		this.tongSanPham = tongSanPham;
	}

}