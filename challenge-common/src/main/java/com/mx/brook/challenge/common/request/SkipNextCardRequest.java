package com.mx.brook.challenge.common.request;

public class SkipNextCardRequest extends GeneralRequest{

	public SkipNextCardRequest(String deckId,Integer cardIndex){
		super();
		this.setDeckId(deckId);
		this.setCardIndex(cardIndex);
	}
	
}
