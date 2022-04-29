package com.mx.brook.challenge.services.deck.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.brook.challenge.common.request.GetNextCardRequest;
import com.mx.brook.challenge.common.request.SkipNextCardRequest;
import com.mx.brook.challenge.common.response.GenerateDeckResponse;
import com.mx.brook.challenge.common.response.GetNextCardResponse;
import com.mx.brook.challenge.common.response.SkipNextCardResponse;
import com.mx.brook.challenge.common.vo.CardVo;
import com.mx.brook.challenge.common.vo.DeckVo;
import com.mx.brook.challenge.services.deck.DeckService;
import com.mx.brook.challenge.services.exceptions.CardIndexException;
import com.mx.brook.challenge.services.exceptions.DeckIdException;
import com.mx.brook.challenge.services.exceptions.EmptyDeckException;
import com.mx.brook.challenge.services.vo.ChallengeSingleton;

@Service
public class DeckServiceImpl implements DeckService{

	  private static final Logger log =LoggerFactory.getLogger(DeckServiceImpl.class);

	@Autowired
	ChallengeSingleton challengeSingleton;
	
	@Override
	public GenerateDeckResponse generateDeck() {
		GenerateDeckResponse response = new GenerateDeckResponse();
		try {		     
			DeckVo deckVo = challengeSingleton.createNewDeck();
			response.setDeckId(deckVo.getDeckId());			
		}catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return response;
	}

	@Override
	public GetNextCardResponse getNextCard(GetNextCardRequest request) {
		GetNextCardResponse response = new GetNextCardResponse();
		try {
			CardVo cardVo = challengeSingleton.getNextCard(request.getDeckId(),request.getCardIndex());
			response.setCard(cardVo.getCardName());
			response.setCardIndex(cardVo.getIndex());
			response.setDeckId(request.getDeckId());
			response.setDescription("OK");
		}catch (CardIndexException e) {
			response.setDescription(e.getMessage());
		}catch (DeckIdException e) {
			response.setDescription(e.getMessage());
		}catch (EmptyDeckException e) {
			response.setDescription(e.getMessage());
		}catch(Exception e) {
			response.setDescription("Error interno");
			log.error(e.getMessage(),e);
		}
		return response;
	}

	@Override
	public SkipNextCardResponse skipNextCard(SkipNextCardRequest request) {
		SkipNextCardResponse response = new SkipNextCardResponse();
		try {			
			CardVo cardVo = challengeSingleton.skipNextCard(request.getDeckId(),request.getCardIndex());
			response.setCardIndex(cardVo.getIndex());
			response.setDeckId(request.getDeckId());
			response.setDescription("OK");
		}catch (CardIndexException e) {
			response.setDescription(e.getMessage());
		}catch (DeckIdException e) {
			response.setDescription(e.getMessage());
		}catch (EmptyDeckException e) {
			response.setDescription(e.getMessage());
		}catch(Exception e) {
			response.setDescription("Error interno");
			log.error(e.getMessage(),e);
		}
		return response;
	}

}
