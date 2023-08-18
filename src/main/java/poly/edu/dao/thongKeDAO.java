package poly.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import poly.edu.entity.ThongKe;
import poly.edu.utils.JpaUtils;

public class thongKeDAO {
	public int insert(ThongKe tk) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			// bắt đầu transaction
			trans.begin();
			//lưu vào csdl
			em.persist(tk);
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
	
	public int update(ThongKe tk ) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(tk);
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
			ThongKe tk = em.find(ThongKe.class, id);
			if(tk != null) {
				em.remove(tk);
				System.out.println("Xoa thanh cong => "+tk.toString());
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
	
	public ThongKe findbyID(String id) {
		EntityManager em = JpaUtils.getEntityManager();
		ThongKe tk = em.find(ThongKe.class, id);
		return tk;
	}
	
	public List<ThongKe> findAll() {
		EntityManager em = JpaUtils.getEntityManager();
//		String sql = "Select u from User u";
//		TypedQuery<User> query = em.createNamedQuery(sql, User.class);
		TypedQuery<ThongKe> query = em.createNamedQuery("ThongKe.findAll", ThongKe.class);
		return query.getResultList();
	}
}
