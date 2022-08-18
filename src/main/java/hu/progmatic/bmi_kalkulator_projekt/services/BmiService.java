package hu.progmatic.bmi_kalkulator_projekt.services;

import hu.progmatic.bmi_kalkulator_projekt.models.BmiModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class BmiService {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public boolean modelmanager (BmiModel bmiModel) {
        entityManager.persist(bmiModel);
        return true;
    }
    public List<BmiModel> List() {
        return entityManager.createQuery("select p from BmiModel p", BmiModel.class).getResultList();
    }
}