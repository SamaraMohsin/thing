package com.glc.thing;

public interface ThingService {
    Thing saveThing(Thing thing);

    Thing getThing();

    Thing updateThing();

    Thing deleteThing();

    Thing getAllThings();


}
