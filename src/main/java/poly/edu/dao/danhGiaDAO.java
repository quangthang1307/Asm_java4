package poly.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import poly.edu.entity.DanhGia;
import poly.edu.utils.JpaUtils;


public class danhGiaDAO {
	public int insert(DanhGia dg) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			// bắt đầu transaction
			trans.begin();
			//lưu vào csdl
			em.persist(dg);
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
	
	public int update(DanhGia dg ) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(dg);
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
			DanhGia dg = em.find(DanhGia.class, id);
			if(dg != null) {
				em.remove(dg);
				System.out.println("Xoa thanh cong => "+dg.toString());
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
	
	public DanhGia findbyID(String id) {
		EntityManager em = JpaUtils.getEntityManager();
		DanhGia dg = em.find(DanhGia.class, id);
		return dg;
	}
	
	public List<DanhGia> findAll() {
		EntityManager em = JpaUtils.getEntityManager();
//		String sql = "Select u from User u";
//		TypedQuery<User> query = em.createNamedQuery(sql, User.class);
		TypedQuery<DanhGia> query = em.createNamedQuery("DanhGia.findAll", DanhGia.class);
		return query.getResultList();
	}
}
