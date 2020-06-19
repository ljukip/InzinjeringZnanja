package InzinjeringOft.repository;



import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import InzinjeringOft.enums.Diseases;
import InzinjeringOft.model.Disease;
import java.util.List;

public class DiseasesRep implements Repository<Long, Disease> {
    public static final String DEFAULT_UNIT = "default-unit";

    private EntityManager em;

    public DiseasesRep() {
        em = Persistence.createEntityManagerFactory(DEFAULT_UNIT).createEntityManager();
    }

    public Disease findByName(Diseases name) {
        return (Disease) em.createQuery("SELECT d FROM Diseases d WHERE d.name = :name").setParameter("name", name).getSingleResult();
    }

	@Override
	public Disease save(Disease entity) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
        Disease savedDisease = em.merge(entity);
        em.getTransaction().commit();
        return savedDisease;
	}

	@Override
	public Disease update(Disease entity) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
        Disease updateDisease = em.merge(entity);
        em.getTransaction().commit();
        return updateDisease;
	}

	@Override
	public List<Disease> findAll() {
		// TODO Auto-generated method stub
		return (List<Disease>) em.createQuery("SELECT d FROM Diseases d").getResultList();
	}

	@Override
	public Disease findById(Long id) {
		// TODO Auto-generated method stub
		return (Disease) em.createQuery("SELECT d FROM Diseases d WHERE d.id = :id").setParameter("id", id).getSingleResult();
	}

	@Override
	public void delete(Disease entity) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		Disease d = (Disease) em.createQuery("SELECT d FROM Diseases d WHERE d.id = :id").setParameter("id", id).getSingleResult();
        return d != null;
	}

    
}

