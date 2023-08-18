package poly.edu.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the SanPham database table.
 * 
 */
@Entity
@NamedQuery(name="SanPham.findAll", query="SELECT s FROM SanPham s")
public class SanPham implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ma_san_pham")
	private int maSanPham;

	private byte[] duongDanHinhAnh;

	private BigDecimal gia;

	@Column(name="mo_ta")
	private String moTa;

	@Column(name="ten_san_pham")
	private String tenSanPham;

	public SanPham() {
	}

	public int getMaSanPham() {
		return this.maSanPham;
	}

	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}

	public byte[] getDuongDanHinhAnh() {
		return this.duongDanHinhAnh;
	}

	public void setDuongDanHinhAnh(byte[] duongDanHinhAnh) {
		this.duongDanHinhAnh = duongDanHinhAnh;
	}

	public BigDecimal getGia() {
		return this.gia;
	}

	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}

	public String getMoTa() {
		return this.moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getTenSanPham() {
		return this.tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

}