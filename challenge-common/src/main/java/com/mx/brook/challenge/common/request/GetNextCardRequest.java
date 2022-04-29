package com.mx.brook.challenge.common.request;


public class GetNextCardRequest extends GeneralRequest{
	
	public GetNextCardRequest(String deckId,Integer cardIndex){
		super();
		this.setDeckId(deckId);
		this.setCardIndex(cardIndex);
	}

}
