package de.htwberlin.webtech2.service;

import de.htwberlin.webtech2.persistence.AufgabeEntity;
import de.htwberlin.webtech2.persistence.AufgabeRepository;
import de.htwberlin.webtech2.web.api.Aufgabe;
import de.htwberlin.webtech2.web.api.AufgabeManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AufgabeService {

    private final AufgabeRepository aufgabeRepository;

    public AufgabeService (AufgabeRepository aufgabeRepository){
        this.aufgabeRepository = aufgabeRepository;
    }

    public List<Aufgabe> findAll(){
        List<AufgabeEntity> task = aufgabeRepository.findAll();
        return task.stream().map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Aufgabe findById(Long id){
        var toDoEntity = aufgabeRepository.findById(id);
        return toDoEntity.map(this::transformEntity).orElse(null);
    }

    public Aufgabe create(AufgabeManipulationRequest request){
        var aufgabeEntity = new AufgabeEntity(request.getTask(), request.getDueTo(), request.isCompleted());
        aufgabeEntity = aufgabeRepository.save(aufgabeEntity);
        return transformEntity(aufgabeEntity);
    }

    public Aufgabe update(Long id, AufgabeManipulationRequest request){
        var aufgabeEntityOptional = aufgabeRepository.findById(id);
        if (aufgabeEntityOptional.isEmpty()){
            return null;
        }

        var aufgabeEntity = aufgabeEntityOptional.get();
        aufgabeEntity.setTask(request.getTask());
        aufgabeEntity.setDueTo(request.getDueTo());
        aufgabeEntity.setCompleted(request.isCompleted());
        aufgabeRepository.save(aufgabeEntity);

        return transformEntity(aufgabeEntity);
    }

    public boolean deleteById(Long id){
        if (!aufgabeRepository.existsById(id)){
            return false;
        }
        aufgabeRepository.deleteById(id);
        return true;
    }

    private Aufgabe transformEntity (AufgabeEntity aufgabeEntity){
        return new Aufgabe(
                aufgabeEntity.getId(),
                aufgabeEntity.getTask(),
                aufgabeEntity.getDueTo(),
                aufgabeEntity.getCompleted()
        );
    }
}
