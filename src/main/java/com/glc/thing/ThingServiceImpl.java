package com.glc.thing;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;

@Service
public class ThingServiceImpl implements ThingService {

    private ThingRepository thingRepository;

    public void thingServiceImpl( ThingRepository thingRepository ){
        this.thingRepository = thingRepository;
    }

    public Thing saveThing(Thing thing){
        Optional<Thing> saveThing =thingRepository.findByMyName(thing.getMyName());
        if(saveThing.isPresent()){
            return null;
            // throw new InvalidConfigurationPropertyNameException("name", thing.getName(), "Athing name "+thing.getName()+" already exists");
        }
        return thingRepository.save(thing);
    }

    public Thing getThing(Long id){
        return thingRepository.getReferenceById(id);
    } 
    
    public Thing updateThing(Thing thing){

        Optional <Thing> savedThing = thingRepository.findByMyName(thing.getMyName());
        if(savedThing.isEmpty()){
            throw new InvalidConfigurationPropertyValueException("Name",thing.getMyName(),"A Thing named"+thing.getMyName()+"does not already exist in the database");
        }
        return thingRepository.save(thing);

    }

    public void deleteThing(Long Id){
        thingRepository.deleteById(Id);
    }

    public List<Thing> getAllThings(){
        return thingRepository.findAll();
    }
}
