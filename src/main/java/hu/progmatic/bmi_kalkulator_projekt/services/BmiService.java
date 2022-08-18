package hu.progmatic.bmi_kalkulator_projekt.services;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class BmiService {
    @PersistenceContext
    EntityManager entityManager;


}
