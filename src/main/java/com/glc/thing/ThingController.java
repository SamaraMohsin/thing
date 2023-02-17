package com.glc.thing;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/things")
public class ThingController {
    
    private ThingService thingService;

    public ThingController (ThingService thingService){
        this.thingService = thingService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Thing createThing (@RequestBody Thing thing){
        return thingService.saveThing(thing);
    }

    // @GetMapping
    // public List<Thing> getAllThings(){
    //     return thingService
    // }

    // @GetMapping("{id}")
    // public ResponseEntity<Thing> getThingById(@PathVariable("id") Long thingId){
    //     Thing thing = thingService.getThing(thingId);

    //     if(thing.getId() != null){
    //         return ResponseEntity.status(HttpStatus.OK).body(thing);
    //     }
    //     else {
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND)(new Thing());
    //     }

    // }

    

}
