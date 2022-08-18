package hu.progmatic.bmi_kalkulator_projekt.services;

import hu.progmatic.bmi_kalkulator_projekt.models.BmiModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.Name;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class BmiService {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public boolean modelmanager(BmiModel bmiModel) {
        entityManager.persist(bmiModel);
        return true;
    }

    public List<BmiModel> List() {
        return entityManager.createQuery("select p from BmiModel p", BmiModel.class).getResultList();
    }

    public double calculateBMI(BmiModel bmiModel) {

        double height = BmiModel.getHeight();
        double weight = BmiModel.getKgs();

        return Math.ceil((weight / (height * height)));
    }

    public String getBMIStatus(double BMI) {
        if (BMI < 18) {
            return ("\n  Az Ön BMI értéke ：" + String.format("%.2f", BMI) + ", Híznia kellene！Ajánlhatok kalóriadús recepteket?");
        } else if (BMI > 18 && BMI <= 25) {
            return ("\n  Az Ön BMI értéke ：" + String.format("%.2f", BMI) + ", Ön normál súllyal rendelkezik！");
        } else if (BMI > 25 && BMI <= 30) {
            return ("\n  Az Ön BMI értéke ：" + String.format("%.2f", BMI) + ", Enyhén túlsúlyos！:( Többet kellene edzeni, ajánljak edzéstervet? ");
        } else if (BMI > 30 && BMI <= 35) {
            return ("\n  Az Ön BMI értéke ：" + String.format("%.2f", BMI) + ", Ez már kicsit sok lesz a kilókból！");
        } else if (BMI > 35 && BMI <= 40) {
            return("\n  Az Ön BMI értéke ：" + String.format("%.2f", BMI) + ", Nagyon túlsúlyos, keressen fel egy orvost！Ajánlhatok orvost és recepteket?");
        } else  {
            return("\n  Az Ön BMI értéke ：" + String.format("%.2f", BMI) + ", Jajjjaj..fogyni kéne ！ Ajánlhatok orvost? ");


        }


} }