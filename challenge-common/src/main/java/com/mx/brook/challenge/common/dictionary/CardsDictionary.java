package com.mx.brook.challenge.common.dictionary;

import java.util.ArrayList;
import java.util.List;

import com.mx.brook.challenge.common.vo.CardVo;

public class CardsDictionary {
	
	public static final String ACE = "A";
	public static final String TWO = "2";
	public static final String THREE = "3";
	public static final String FOUR = "4";
	public static final String FIVE = "5";
	public static final String SIX = "6";
	public static final String SEVEN = "7";
	public static final String EIGTH = "8";
	public static final String NINE = "9";
	public static final String TEN = "10";
	public static final String JACK = "J";
	public static final String QUEEN = "Q";
	public static final String KING = "K";

	public static final String CLUBS = "Clubs";
	public static final String DIAMONDS = "Diamonds";
	public static final String HEARTS = "Hearts";
	public static final String SPADES = "Spades";

	
	public List<CardVo> initDeck() {
		//CLUBS
		List<CardVo> cardsList = new ArrayList<CardVo>();
		cardsList.add(new CardVo(ACE,CLUBS));
		cardsList.add(new CardVo(TWO,CLUBS));
		cardsList.add(new CardVo(THREE,CLUBS));
		cardsList.add(new CardVo(FOUR,CLUBS));
		cardsList.add(new CardVo(FIVE,CLUBS));
		cardsList.add(new CardVo(SIX,CLUBS));
		cardsList.add(new CardVo(SEVEN,CLUBS));
		cardsList.add(new CardVo(EIGTH,CLUBS));
		cardsList.add(new CardVo(NINE,CLUBS));
		cardsList.add(new CardVo(TEN,CLUBS));
		cardsList.add(new CardVo(JACK,CLUBS));
		cardsList.add(new CardVo(QUEEN,CLUBS));
		cardsList.add(new CardVo(KING,CLUBS));

		//DIAMONDS
		cardsList.add(new CardVo(ACE,DIAMONDS));
		cardsList.add(new CardVo(TWO,DIAMONDS));
		cardsList.add(new CardVo(THREE,DIAMONDS));
		cardsList.add(new CardVo(FOUR,DIAMONDS));
		cardsList.add(new CardVo(FIVE,DIAMONDS));
		cardsList.add(new CardVo(SIX,DIAMONDS));
		cardsList.add(new CardVo(SEVEN,DIAMONDS));
		cardsList.add(new CardVo(EIGTH,DIAMONDS));
		cardsList.add(new CardVo(NINE,DIAMONDS));
		cardsList.add(new CardVo(TEN,DIAMONDS));
		cardsList.add(new CardVo(JACK,DIAMONDS));
		cardsList.add(new CardVo(QUEEN,DIAMONDS));
		cardsList.add(new CardVo(KING,DIAMONDS));
		
		//HEARTS
		cardsList.add(new CardVo(ACE,HEARTS));
		cardsList.add(new CardVo(TWO,HEARTS));
		cardsList.add(new CardVo(THREE,HEARTS));
		cardsList.add(new CardVo(FOUR,HEARTS));
		cardsList.add(new CardVo(FIVE,HEARTS));
		cardsList.add(new CardVo(SIX,HEARTS));
		cardsList.add(new CardVo(SEVEN,HEARTS));
		cardsList.add(new CardVo(EIGTH,HEARTS));
		cardsList.add(new CardVo(NINE,HEARTS));
		cardsList.add(new CardVo(TEN,HEARTS));
		cardsList.add(new CardVo(JACK,HEARTS));
		cardsList.add(new CardVo(QUEEN,HEARTS));
		cardsList.add(new CardVo(KING,HEARTS));
		
		//SPADES
		cardsList.add(new CardVo(ACE,SPADES));
		cardsList.add(new CardVo(TWO,SPADES));
		cardsList.add(new CardVo(THREE,SPADES));
		cardsList.add(new CardVo(FOUR,SPADES));
		cardsList.add(new CardVo(FIVE,SPADES));
		cardsList.add(new CardVo(SIX,SPADES));
		cardsList.add(new CardVo(SEVEN,SPADES));
		cardsList.add(new CardVo(EIGTH,SPADES));
		cardsList.add(new CardVo(NINE,SPADES));
		cardsList.add(new CardVo(TEN,SPADES));
		cardsList.add(new CardVo(JACK,SPADES));
		cardsList.add(new CardVo(QUEEN,SPADES));
		cardsList.add(new CardVo(KING,SPADES));
		return cardsList;
	}
		
}
