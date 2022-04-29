package com.mx.brook.challenge.services;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mx.brook.challenge.common.request.GetNextCardRequest;
import com.mx.brook.challenge.common.request.SkipNextCardRequest;
import com.mx.brook.challenge.common.response.GenerateDeckResponse;
import com.mx.brook.challenge.common.response.GetNextCardResponse;
import com.mx.brook.challenge.common.response.SkipNextCardResponse;
import com.mx.brook.challenge.services.deck.DeckService;

@SpringBootTest
class ChallengeServicesApplicationTests {

	private static final Logger log =LoggerFactory.getLogger(ChallengeServicesApplicationTests.class);
	
	@Autowired
	DeckService deckService;
	
	//@Test
	void contextLoads() {
	}
	
	@Test
	void generateDeck(){
		log.info("Started generateDeck TEST");
		GenerateDeckResponse generateDeckResponse = deckService.generateDeck();
		log.info("DeckId [{}]",generateDeckResponse.getDeckId());
		getNextCard(generateDeckResponse.getDeckId());
		getNextCard(generateDeckResponse.getDeckId());
		getNextCard(generateDeckResponse.getDeckId());
		getNextCard(generateDeckResponse.getDeckId());
		getNextCard(generateDeckResponse.getDeckId());
		skipNextCard(generateDeckResponse.getDeckId());
		skipNextCard(generateDeckResponse.getDeckId());
		skipNextCard(generateDeckResponse.getDeckId());
		skipNextCard(generateDeckResponse.getDeckId());
		skipNextCard(generateDeckResponse.getDeckId());
		getNextCard(generateDeckResponse.getDeckId());
		getNextCard(generateDeckResponse.getDeckId());

	}
	
	//@Test
	void getNextCard(String deckId){
		log.info("Started generateDeck TEST");
//		String deckId="1651218444592466";
		Integer cardIndex = null; 
		
		GetNextCardRequest request = new GetNextCardRequest(deckId,cardIndex);
		GetNextCardResponse getNextCardResponse= deckService.getNextCard(request);
		log.info("Card [{}], CardIndex : {}",getNextCardResponse.getCard(),getNextCardResponse.getCardIndex());

	}
	
	//@Test
	void skipNextCard(String deckId){
		log.info("Started generateDeck TEST");
//		String deckId="1651218444592466";
		Integer cardIndex = null; 
		
		SkipNextCardRequest request = new SkipNextCardRequest(deckId,cardIndex);
		SkipNextCardResponse skipNextCardResponse = deckService.skipNextCard(request);
		log.info("CardIndex : {}",skipNextCardResponse.getCardIndex());

	}

}
