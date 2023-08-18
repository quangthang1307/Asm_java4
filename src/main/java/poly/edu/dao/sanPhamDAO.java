package poly.edu.dao;

import java.util.Base64;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import poly.edu.entity.SanPham;
import poly.edu.utils.JpaUtils;

public class sanPhamDAO {
	
	public int insert(SanPham sp) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			// bắt đầu transaction
			trans.begin();
			//lưu vào csdl
			em.persist(sp);
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
	
	public SanPham findbyID(int id) {
		EntityManager em = JpaUtils.getEntityManager();
		SanPham sp = em.find(SanPham.class, id);
		return sp;
	}
	
	public int update(SanPham sp ) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(sp);
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
	
	public int delete(int id) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
//			User user = findbyID(id);
			SanPham sp = em.find(SanPham.class, id);
			if(sp != null) {
				em.remove(sp);
				System.out.println("Xoa thanh cong => "+sp.toString());
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
	
	public List<SanPham> findAll() {
		EntityManager em = JpaUtils.getEntityManager();
//		String sql = "Select u from User u";
//		TypedQuery<User> query = em.createNamedQuery(sql, User.class);
		TypedQuery<SanPham> query = em.createNamedQuery("SanPham.findAll", SanPham.class);
		return query.getResultList();
	}

}
