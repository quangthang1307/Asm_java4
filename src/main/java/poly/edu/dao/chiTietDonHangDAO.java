package poly.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import poly.edu.entity.ChiTietDonHang;
import poly.edu.utils.JpaUtils;



public class chiTietDonHangDAO {
	public int insert(ChiTietDonHang ctdh) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			// bắt đầu transaction
			trans.begin();
			//lưu vào csdl
			em.persist(ctdh);
			//chấp nhận kết quả thao tác
			trans.commit();

		} catch (Exception e) {
			// TODO: handle exception
			//hủy thao tác khi có exception
			trans.rollback();
			System.out.println("Lỗi trùng ID");
			return -1;
		} finally {
			em.close();
		}
		return 1;
	}
	
	public int update(ChiTietDonHang ctdh ) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(ctdh);
			trans.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			trans.rollback();
			return -1;
		}finally {
			em.close();
		}
		return 1;
	}
	
	public int delete(String id) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
//			User user = findbyID(id);
			ChiTietDonHang ctdh = em.find(ChiTietDonHang.class, id);
			if(ctdh != null) {
				em.remove(ctdh);
				System.out.println("Xoa thanh cong => "+ctdh.toString());
			}
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			trans.rollback();
			return -1;
		}finally {
			em.close();
		}
		return 1;
	}
	
	public ChiTietDonHang findbyID(String id) {
		EntityManager em = JpaUtils.getEntityManager();
		ChiTietDonHang ctdh = em.find(ChiTietDonHang.class, id);
		return ctdh;
	}
	
	public List<ChiTietDonHang> findAll() {
		EntityManager em = JpaUtils.getEntityManager();
//		String sql = "Select u from User u";
//		TypedQuery<User> query = em.createNamedQuery(sql, User.class);
		TypedQuery<ChiTietDonHang> query = em.createNamedQuery("ChiTietDonHang.findAll", ChiTietDonHang.class);
		return query.getResultList();
	}
}
