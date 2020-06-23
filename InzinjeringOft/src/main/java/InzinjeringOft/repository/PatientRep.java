package InzinjeringOft.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.Transactional;

import InzinjeringOft.model.Patient;

import java.util.List;
import InzinjeringOft.PersistenceJPAConfig;
@Transactional
public class PatientRep implements Repository<Long, Patient> {
    public static final String DEFAULT = "default";

    @PersistenceContext
    private EntityManager em;

    public PatientRep() {
        //em = Persistence.createEntityManagerFactory(DEFAULT).createEntityManager();
    }

    @Override
    @Transactional
    public Patient save(Patient patient) {
        em.getTransaction().begin();
        Patient savedPatient = em.merge(patient);
        em.getTransaction().commit();
        return savedPatient;
    }

    @Override
    @Transactional
    public Patient update(Patient patient) {
        em.getTransaction().begin();
        Patient updatedPatient = em.merge(patient);
        em.getTransaction().commit();
        return updatedPatient;
    }

    @Override
    @Transactional
    public List<Patient> findAll() {
    	System.out.println(em.createQuery("SELECT p FROM Patient p").getResultList() + "usao i pukao");
        return (List<Patient>) em.createQuery("SELECT p FROM Patient p").getResultList();
    }

    @Override
    @Transactional
    public Patient findById(Long id) {
        return (Patient) em.createQuery("SELECT p FROM Patient p WHERE p.id = :id").setParameter("id", id).getSingleResult();
    }

    @Override
    @Transactional
    public void delete(Patient patient) {
        em.getTransaction().begin();
        em.remove(patient);
        em.getTransaction().commit();
    }

    @Override
    @Transactional
    public boolean existsById(Long id) {
        Patient p = (Patient) em.createQuery("SELECT p FROM Patient p WHERE  p.id = :id").setParameter("id", id).getSingleResult();
        return p != null;
    }
}
