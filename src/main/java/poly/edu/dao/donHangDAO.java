package poly.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import poly.edu.entity.DonHang;
import poly.edu.utils.JpaUtils;



public class donHangDAO {
	
	public int insert(DonHang dh) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			// bắt đầu transaction
			trans.begin();
			//lưu vào csdl
			em.persist(dh);
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
	
	public int update(DonHang dh ) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(dh);
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
			DonHang dh = em.find(DonHang.class, id);
			if(dh != null) {
				em.remove(dh);
				System.out.println("Xoa thanh cong => "+dh.toString());
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
	
	public DonHang findbyID(int id) {
		EntityManager em = JpaUtils.getEntityManager();
		DonHang dh = em.find(DonHang.class, id);
		return dh;
	}
	
	public List<DonHang> findAll() {
		EntityManager em = JpaUtils.getEntityManager();
//		String sql = "Select u from User u";
//		TypedQuery<User> query = em.createNamedQuery(sql, User.class);
		TypedQuery<DonHang> query = em.createNamedQuery("DonHang.findAll", DonHang.class);
		return query.getResultList();
	}
}
