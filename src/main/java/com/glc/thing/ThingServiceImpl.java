package com.glc.thing;

import java.util.Optional;


import org.springframework.stereotype.Service;

@Service
public class ThingServiceImpl implements ThingService {

    private ThingRepository thingRepository;

    public void thingServiceImpl( ThingRepository thingRepository ){
        this.thingRepository = thingRepository;
    }

    public Thing saveThing(Thing thing){
        Optional<Thing> saveThing =thingRepository.findByName(thing.getMyName());
        if(saveThing.isPresent()){
            return null;
            // throw new InvalidConfigurationPropertyNameException("name", thing.getName(), "Athing name "+thing.getName()+" already exists");
        }
        return thingRepository.save(thing);
    }
    
}
