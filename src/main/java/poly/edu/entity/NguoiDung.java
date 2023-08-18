package poly.edu.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the NguoiDung database table.
 * 
 */
@Entity
@NamedQuery(name = "NguoiDung.findNameEmailGmailIdMatKhauQuyenHan",
query = "SELECT n.hoTen, n.email, n.gmailId, n.matKhau, n.quyenHan FROM NguoiDung n")
public class NguoiDung implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String email;

	@Column(name = "gmail_id")
	private String gmailId;

	@Column(name = "ho_ten")
	private String hoTen;

	@Column(name = "mat_khau")
	private String matKhau;

	@Column(name = "quyen_han")
	private String quyenHan;

	// bi-directional many-to-one association to DonHang
	@OneToMany(mappedBy = "nguoiDung")
	private List<DonHang> donHangs;

	public NguoiDung() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGmailId() {
		return this.gmailId;
	}

	public void setGmailId(String gmailId) {
		this.gmailId = gmailId;
	}

	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getMatKhau() {
		return this.matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getQuyenHan() {
		return this.quyenHan;
	}

	public void setQuyenHan(String quyenHan) {
		this.quyenHan = quyenHan;
	}

	public List<DonHang> getDonHangs() {
		return this.donHangs;
	}

	public void setDonHangs(List<DonHang> donHangs) {
		this.donHangs = donHangs;
	}

	public DonHang addDonHang(DonHang donHang) {
		getDonHangs().add(donHang);
		donHang.setNguoiDung(this);

		return donHang;
	}

	public DonHang removeDonHang(DonHang donHang) {
		getDonHangs().remove(donHang);
		donHang.setNguoiDung(null);

		return donHang;
	}

}