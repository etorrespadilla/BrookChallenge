package com.mx.brook.challenge.common.dictionary;

public class EndpointsDictionary {

	public static final String CHALLENGE = "/challenge";
	public static final String GENERATE_DECK = "/generateDeck";
	public static final String GET_NEXT_CARD = "/getNextCard/{deckId}";
	public static final String GET_NEXT_CARD_OPTIONAL = "/getNextCard/{deckId}/{cardIndex}";
	public static final String SKIP_NEXT_CARD = "/skipNextCard/{deckId}";
	public static final String SKIP_NEXT_CARD_OPTIONAL = "/skipNextCard/{deckId}/{cardIndex}";


}
