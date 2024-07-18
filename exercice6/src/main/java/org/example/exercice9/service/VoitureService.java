package org.example.exercice9.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import org.example.exercice9.model.Voiture;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// CDI
@ApplicationScoped
//@RequestScoped
public class VoitureService {
    private List<Voiture> voitures = new ArrayList<>();
    private long currentId = 1;

    public void create(Voiture voiture){
        voiture.setId(currentId++);
        voitures.add(voiture);
    }

    public List<Voiture> findAll() {
        return voitures;
    }

    public Voiture findById(Long id){
        return voitures.stream().filter(v -> v.getId().equals(id)).findFirst().orElse(null);
    }


    public Voiture update(Voiture voiture){
        Optional<Voiture> existVoiture = voitures.stream().filter(v -> v.getId().equals(voiture.getId())).findFirst();
        if(existVoiture.isPresent()){
            Voiture voiture1 = existVoiture.get();
            voiture1.setBrand(voiture.getBrand());
            voiture1.setYear(voiture.getYear());
            voiture1.setColor(voiture.getColor());
            return voiture1;
        }
        return null;
    }

    public void delete(Long id){
        voitures.removeIf(voiture -> voiture.getId().equals(id));
    }
}
