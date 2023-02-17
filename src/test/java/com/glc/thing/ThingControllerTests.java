package com.glc.thing;

// import static org.mockito.ArgumentMatchers.any;

// import org.aopalliance.intercept.Invocation;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.data.web.JsonPath;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.ResultActions;

// import static org.mockito.BDDMockito.*;


// import com.fasterxml.jackson.databind.ObjectMapper;

// import ch.qos.logback.core.status.Status;

// // ---------xxxxxxxxxxxxxxxx---------------

// import static org.hamcrest.CoreMatchers.is;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
// import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class ThingControllerTests {

    @Autowired
    private  MockMvc mockMvc;

    @MockBean
    private ThingService thingService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void postANewThing() throws Exception {

        Thing thing = Thing.builder().myName("Table").myDescription("tABLE DESCRIPTION").myQuantity("4").build();

        given(thingService.saveThing(any(Thing.class))).willAnswer((invocation) -> invocation.getArgument(0));
        ResultActions response = mockMvc.perform(post("/api/things").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(thing)));

        response.andDo(print())
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.myName",is(thing.getMyName())))
            .andExpect(jsonPath("$.myDescription", is(thing.getMyDescription())))
            .andExpect(jsonPath("$.myQuantity", is(thing.getMyQuantity())));

    }

    // @Test

    // public void getAllThings() throws Exception {

    //     Thing thing1 = Thing.builder().myName("tABLE").myDescription("DESC").myQuantity("4");
    //     given(thingService.GET) 

    // }

    // @Test
    // public void getOneThingById(){



    // }

    // @Test 
    // public void

    
}
