package poly.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import poly.edu.entity.NguoiDung;
import poly.edu.utils.JpaUtils;
import javax.persistence.Query;

public class nguoiDungDAO {
	
	public NguoiDung findByEmail(String email) {
        EntityManager em = JpaUtils.getEntityManager();
        try {
            Query query = em.createQuery("SELECT n FROM NguoiDung n WHERE n.email = :email");
            query.setParameter("email", email);
            return (NguoiDung) query.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
	
	public int insert(NguoiDung nd) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			// bắt đầu transaction
			trans.begin();
			//lưu vào csdl
			em.persist(nd);
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
	
	public int update(NguoiDung nd ) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(nd);
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
			NguoiDung nd = em.find(NguoiDung.class, id);
			if(nd != null) {
				em.remove(nd);
				System.out.println("Xoa thanh cong => "+nd.toString());
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
	
	public NguoiDung findbyID(String id) {
		EntityManager em = JpaUtils.getEntityManager();
		NguoiDung nd = em.find(NguoiDung.class, id);
		return nd;
	}
	
	public List<NguoiDung> findAll() {
		EntityManager em = JpaUtils.getEntityManager();
//		String sql = "Select u from User u";
//		TypedQuery<User> query = em.createNamedQuery(sql, User.class);
		TypedQuery<NguoiDung> query = em.createNamedQuery("NguoiDung.findAll", NguoiDung.class);
		return query.getResultList();
	}
}
