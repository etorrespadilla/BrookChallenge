package com.mx.brook.challenge.services.vo;

import java.time.Instant;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mx.brook.challenge.common.dictionary.CardsDictionary;
import com.mx.brook.challenge.common.vo.CardVo;
import com.mx.brook.challenge.common.vo.DeckVo;
import com.mx.brook.challenge.services.exceptions.CardIndexException;
import com.mx.brook.challenge.services.exceptions.DeckIdException;
import com.mx.brook.challenge.services.exceptions.EmptyDeckException;
@Component
@Scope("singleton")
public class ChallengeSingleton {

	private static final Logger log =LoggerFactory.getLogger(ChallengeSingleton.class);

	private LinkedList<DeckVo> deckVoList= new LinkedList<DeckVo>();
	private String lastDeckId;
	
	
	public List<DeckVo> getDeckVoList() {
		return deckVoList;
	}
	public void setDeckVoList(LinkedList<DeckVo> deckVoList) {
		this.deckVoList = deckVoList;
	}
	public String getLastDeckId() {
		return lastDeckId;
	}
	public void setLastDeckId(String lastDeckId) {
		this.lastDeckId = lastDeckId;
	}
	
	public DeckVo createNewDeck() {
	    DeckVo deckVo = new DeckVo();
	    deckVo.setCardVoList(shuffleDeck());
		deckVo.setDeckId(generateDeckId());
		deckVoList.add(deckVo);
		return deckVo;
	}
	
	public CardVo getNextCard(String deckId,Integer cardIndex) throws CardIndexException,DeckIdException,EmptyDeckException{
		CardVo cardVo = null;
		DeckVo deckVo = getDeckVo(deckId);
		if(deckVo != null) {
			cardVo = new CardVo();
			int index = cardIndex != null ? cardIndex : deckVo.getCardVoList().size()-1;
			if(index == deckVo.getCardVoList().size()-1){
				if(deckVo.getCardVoList().size()>0){
					try {
					cardVo = deckVo.getCardVoList().get(index);
					}catch (Exception e) {
						log.error(e.getMessage(),e);
						throw new CardIndexException("Invalid cardIndex");
					}
					cardVo.setIndex(index);
					deckVo.getCardVoList().remove(index);
				}else {
					throw new EmptyDeckException("Deck is empty");
				}
			}else 
				throw new CardIndexException("Invalid cardIndex");
		}else {
			throw new DeckIdException("Invalid DeckId");
		}
		return cardVo;
	}
	
	public CardVo skipNextCard(String deckId,Integer cardIndex) throws CardIndexException,DeckIdException,EmptyDeckException{
		CardVo cardVo = null;
		DeckVo deckVo = getDeckVo(deckId);
		if(deckVo != null) {
			int index = cardIndex != null ? cardIndex : deckVo.getCardVoList().size()-1;
			if(index == deckVo.getCardVoList().size()-1){
				if(deckVo.getCardVoList().size()>0){
					cardVo = new CardVo();
					cardVo.setIndex(index);
					deckVo.getCardVoList().addFirst(deckVo.getCardVoList().remove(index));
				}else {
					throw new EmptyDeckException("Deck is empty");
				}
			}else {
				throw new DeckIdException("Invalid cardIndex");
			}
		}else {
			throw new DeckIdException("Invalid DeckId");
		}
		return cardVo;	
	}
	
	
	
	
	private DeckVo getDeckVo(String deckId) {
		return deckVoList.stream().filter(deckVo -> deckId.equals(deckVo.getDeckId())).findFirst().orElse(null);
	}
	private LinkedList<CardVo> initDeck() {
		LinkedList<CardVo> cardsList = new LinkedList<CardVo>();
		//CLUBS
		cardsList.add(new CardVo(CardsDictionary.ACE,CardsDictionary.CLUBS));
		cardsList.add(new CardVo(CardsDictionary.TWO,CardsDictionary.CLUBS));
		cardsList.add(new CardVo(CardsDictionary.THREE,CardsDictionary.CLUBS));
		cardsList.add(new CardVo(CardsDictionary.FOUR,CardsDictionary.CLUBS));
		cardsList.add(new CardVo(CardsDictionary.FIVE,CardsDictionary.CLUBS));
		cardsList.add(new CardVo(CardsDictionary.SIX,CardsDictionary.CLUBS));
		cardsList.add(new CardVo(CardsDictionary.SEVEN,CardsDictionary.CLUBS));
		cardsList.add(new CardVo(CardsDictionary.EIGTH,CardsDictionary.CLUBS));
		cardsList.add(new CardVo(CardsDictionary.NINE,CardsDictionary.CLUBS));
		cardsList.add(new CardVo(CardsDictionary.TEN,CardsDictionary.CLUBS));
		cardsList.add(new CardVo(CardsDictionary.JACK,CardsDictionary.CLUBS));
		cardsList.add(new CardVo(CardsDictionary.QUEEN,CardsDictionary.CLUBS));
		cardsList.add(new CardVo(CardsDictionary.KING,CardsDictionary.CLUBS));

		//CardsDictionary.DIAMONDS
		cardsList.add(new CardVo(CardsDictionary.ACE,CardsDictionary.DIAMONDS));
		cardsList.add(new CardVo(CardsDictionary.TWO,CardsDictionary.DIAMONDS));
		cardsList.add(new CardVo(CardsDictionary.THREE,CardsDictionary.DIAMONDS));
		cardsList.add(new CardVo(CardsDictionary.FOUR,CardsDictionary.DIAMONDS));
		cardsList.add(new CardVo(CardsDictionary.FIVE,CardsDictionary.DIAMONDS));
		cardsList.add(new CardVo(CardsDictionary.SIX,CardsDictionary.DIAMONDS));
		cardsList.add(new CardVo(CardsDictionary.SEVEN,CardsDictionary.DIAMONDS));
		cardsList.add(new CardVo(CardsDictionary.EIGTH,CardsDictionary.DIAMONDS));
		cardsList.add(new CardVo(CardsDictionary.NINE,CardsDictionary.DIAMONDS));
		cardsList.add(new CardVo(CardsDictionary.TEN,CardsDictionary.DIAMONDS));
		cardsList.add(new CardVo(CardsDictionary.JACK,CardsDictionary.DIAMONDS));
		cardsList.add(new CardVo(CardsDictionary.QUEEN,CardsDictionary.DIAMONDS));
		cardsList.add(new CardVo(CardsDictionary.KING,CardsDictionary.DIAMONDS));
		
		//CardsDictionary.HEARTS
		cardsList.add(new CardVo(CardsDictionary.ACE,CardsDictionary.HEARTS));
		cardsList.add(new CardVo(CardsDictionary.TWO,CardsDictionary.HEARTS));
		cardsList.add(new CardVo(CardsDictionary.THREE,CardsDictionary.HEARTS));
		cardsList.add(new CardVo(CardsDictionary.FOUR,CardsDictionary.HEARTS));
		cardsList.add(new CardVo(CardsDictionary.FIVE,CardsDictionary.HEARTS));
		cardsList.add(new CardVo(CardsDictionary.SIX,CardsDictionary.HEARTS));
		cardsList.add(new CardVo(CardsDictionary.SEVEN,CardsDictionary.HEARTS));
		cardsList.add(new CardVo(CardsDictionary.EIGTH,CardsDictionary.HEARTS));
		cardsList.add(new CardVo(CardsDictionary.NINE,CardsDictionary.HEARTS));
		cardsList.add(new CardVo(CardsDictionary.TEN,CardsDictionary.HEARTS));
		cardsList.add(new CardVo(CardsDictionary.JACK,CardsDictionary.HEARTS));
		cardsList.add(new CardVo(CardsDictionary.QUEEN,CardsDictionary.HEARTS));
		cardsList.add(new CardVo(CardsDictionary.KING,CardsDictionary.HEARTS));
		
		//CardsDictionary.SPADES
		cardsList.add(new CardVo(CardsDictionary.ACE,CardsDictionary.SPADES));
		cardsList.add(new CardVo(CardsDictionary.TWO,CardsDictionary.SPADES));
		cardsList.add(new CardVo(CardsDictionary.THREE,CardsDictionary.SPADES));
		cardsList.add(new CardVo(CardsDictionary.FOUR,CardsDictionary.SPADES));
		cardsList.add(new CardVo(CardsDictionary.FIVE,CardsDictionary.SPADES));
		cardsList.add(new CardVo(CardsDictionary.SIX,CardsDictionary.SPADES));
		cardsList.add(new CardVo(CardsDictionary.SEVEN,CardsDictionary.SPADES));
		cardsList.add(new CardVo(CardsDictionary.EIGTH,CardsDictionary.SPADES));
		cardsList.add(new CardVo(CardsDictionary.NINE,CardsDictionary.SPADES));
		cardsList.add(new CardVo(CardsDictionary.TEN,CardsDictionary.SPADES));
		cardsList.add(new CardVo(CardsDictionary.JACK,CardsDictionary.SPADES));
		cardsList.add(new CardVo(CardsDictionary.QUEEN,CardsDictionary.SPADES));
		cardsList.add(new CardVo(CardsDictionary.KING,CardsDictionary.SPADES));
		return cardsList;
	}
	
	private LinkedList<CardVo> shuffleDeck() {
		LinkedList<CardVo> cardsList = initDeck();
        Collections.shuffle(cardsList);
		return cardsList;
	}		
	private String generateDeckId() {
		String epoch = Long.toString(Instant.now().toEpochMilli());
	    String random_number = Integer.toString(new Random().nextInt(1000)); 
	    return epoch.concat(random_number);
	}
	
	
	
}
