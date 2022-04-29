package com.mx.brook.challenge.services.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.brook.challenge.common.dictionary.EndpointsDictionary;
import com.mx.brook.challenge.common.request.GetNextCardRequest;
import com.mx.brook.challenge.common.request.SkipNextCardRequest;
import com.mx.brook.challenge.common.response.GenerateDeckResponse;
import com.mx.brook.challenge.common.response.GetNextCardResponse;
import com.mx.brook.challenge.common.response.SkipNextCardResponse;
import com.mx.brook.challenge.services.deck.DeckService;



@RestController
@RequestMapping(EndpointsDictionary.CHALLENGE)
public class DeckController {
	
	  private static final Logger log =LoggerFactory.getLogger(DeckController.class);
@Autowired
DeckService deckService;

	
	@GetMapping(EndpointsDictionary.GENERATE_DECK)
	GenerateDeckResponse generateDeck() {
		log.info("Started generateDeck WS");
		return deckService.generateDeck();
	}
	
	
	@GetMapping(value= {EndpointsDictionary.GET_NEXT_CARD,EndpointsDictionary.GET_NEXT_CARD_OPTIONAL})
	GetNextCardResponse getNextCard(@PathVariable String deckId,@PathVariable Optional<Integer> cardIndex) {
		log.info("Started getNextCard WS");
		GetNextCardRequest request = new GetNextCardRequest(deckId,cardIndex.isPresent() ?  cardIndex.get() : null );
		return deckService.getNextCard(request);
	}
	
	
	@GetMapping(value= {EndpointsDictionary.SKIP_NEXT_CARD,EndpointsDictionary.SKIP_NEXT_CARD_OPTIONAL})
	SkipNextCardResponse skipNextCard(@PathVariable String deckId,@PathVariable Optional<Integer> cardIndex) {
		log.info("Started skipNextCard WS");
		SkipNextCardRequest request = new SkipNextCardRequest(deckId,cardIndex.isPresent() ? cardIndex.get() : null );
		return deckService.skipNextCard(request);
	}
}
