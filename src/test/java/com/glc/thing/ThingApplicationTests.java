package com.glc.thing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
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

	@Test
	void canSaveThing(){

		Long myId = 1L;
		String myName = "table";
		String myDescription = "This is a table";
		String myQuantity = "table";

		Thing cut = Thing.builder().Id(myId).myName(myName).myDescription(myDescription).myQuantity(myQuantity).build();

		assertEquals(myId, cut.getId());
		assertEquals(myName, cut.getMyName());
		assertEquals(myDescription, cut.getMyDescription());
		assertEquals(myQuantity, cut.getMyQuantity());
		
		given(thingRepository.findByMyName(myName)).willReturn(Optional.empty());
        given(thingRepository.save(cut)).willReturn(cut);
		Thing savedThing = thingServiceImpl.saveThing(cut);
		assertNotNull(savedThing);
	}

	@Test
	void canGetAThing(){

		Long myId = 1L;
		String myName = "table";
		String myDescription = "This is a table";
		String myQuantity = "table";

		Thing cut = Thing.builder().Id(myId).myName(myName).myDescription(myDescription).myQuantity(myQuantity).build();

		given(thingRepository.getReferenceById(cut.getId())).willReturn(cut);

		Thing gottenThing = thingServiceImpl.getThing(cut.getId());

		assertEquals(cut.getMyName(), gottenThing.getMyName());
		assertEquals(cut.getMyDescription(), gottenThing.getMyDescription());
		// assertNotNull(gottenThing);

	}

	@Test
	void canUpdateAThing(){

		Long myId = 1L;
		String myName = "table";
		String myDescription = "This is a table";
		String myQuantity = "table";

		Thing cut = Thing.builder().Id(myId).myName(myName).myDescription(myDescription).myQuantity(myQuantity).build();

		given(thingRepository.findByMyName(myName)).willReturn(Optional.of(cut));
		given(thingRepository.save(cut)).willReturn(cut);

		Thing updatedThing = thingServiceImpl.updateThing(cut);
		assertEquals(cut.getMyName(), updatedThing.getMyName());
		assertEquals(cut.getMyDescription(), updatedThing.getMyDescription());

	}

	@Test
	void canDeleteAThing(){
		Long myId = 1L;
		willDoNothing().given(thingRepository).deleteById(myId);
		thingServiceImpl.deleteThing(myId);
		verify(thingRepository , times(1)).deleteById(myId);
	}

	@Test
	void canGetAllThings(){
		Long myId = 1L;
		String myName = "table";
		String myDescription = "This is a table";
		String myQuantity = "table";

		Thing cut1 = Thing.builder().Id(1L).myName("CHAIR").myDescription("myDescription").myQuantity("4").build();
		Thing cut2 = Thing.builder().Id(2L).myName("TABLE").myDescription("myDescription").myQuantity("4").build();

		given(thingRepository.findAll()).willReturn(List.of(cut1,cut2));

		List<Thing> thingList = thingServiceImpl.getAllThings();
		assertNotNull(thingList);
		assertEquals(2, thingList.size());


	}

}
