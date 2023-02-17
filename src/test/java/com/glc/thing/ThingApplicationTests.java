package com.glc.thing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ThingApplicationTests {

	@Mock
	private ThingRepository thingRepository;

	@InjectMocks
	private ThingServiceImpl thingServiceImpl ;

	@Test
	void contextLoads() {
	}

	@Test
	void getAndSetThingID(){
		Thing cut = new Thing();
		Long myId = 1L;
		cut.setId(myId);
		assertEquals(myId, cut.getId());
	}

	@Test 
	void getAndSetThingName(){
		Thing cut = new Thing();
		String myName = "table";
		cut.setMyName(myName);
		assertEquals(myName, cut.getMyName());
	}

	@Test
	void getAndSetThingDescription(){
		Thing cut = new Thing();
		String myDescription = "This is a table";
		cut.setMyDescription(myDescription);
		assertEquals(myDescription, cut.getMyDescription());

	}

	@Test
	void getAndSetThingQuantity(){
		Thing cut = new Thing();
		String myQuantity = "table";
		cut.setMyQuantity(myQuantity);
		assertEquals(myQuantity, cut.getMyQuantity());

	}

	@Test
	void allArgsConstructorThing(){
		Long myId = 1L;
		String myName = "table";
		String myDescription = "This is a table";
		String myQuantity = "table";

		Thing cut = new Thing(myId, myName, myDescription, myQuantity );
		assertEquals(myId, cut.getId());
		assertEquals(myName, cut.getMyName());
		assertEquals(myDescription, cut.getMyDescription());
		assertEquals(myQuantity, cut.getMyQuantity());
	}

	@Test
	void builderThing(){
		Long myId = 1L;
		String myName = "table";
		String myDescription = "This is a table";
		String myQuantity = "table";

		Thing cut = Thing.builder().Id(myId).myName(myName).myDescription(myDescription).myQuantity(myQuantity).build();

		assertEquals(myId, cut.getId());
		assertEquals(myName, cut.getMyName());
		assertEquals(myDescription, cut.getMyDescription());
		assertEquals(myQuantity, cut.getMyQuantity());
	}

	// @Test
	// void canSaveThing(){

	// 	Long myId = 1L;
	// 	String myName = "table";
	// 	String myDescription = "This is a table";
	// 	String myQuantity = "table";

	// 	Thing cut = Thing.builder().Id(myId).myName(myName).myDescription(myDescription).myQuantity(myQuantity).build();

	// 	assertEquals(myId, cut.getId());
	// 	assertEquals(myName, cut.getMyName());
	// 	assertEquals(myDescription, cut.getMyDescription());
	// 	assertEquals(myQuantity, cut.getMyQuantity());
		
	// 	given(thingRepository.findByName(myName)).willReturn(Optional.empty());
    //     given(thingRepository.save(cut)).willReturn(cut);
	// 	Thing savedThing = thingServiceImpl.saveThing(cut);
	// 	assertNotNull(savedThing);
	// }
}
