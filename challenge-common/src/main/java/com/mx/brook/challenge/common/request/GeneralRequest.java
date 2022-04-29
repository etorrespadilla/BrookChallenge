package com.mx.brook.challenge.common.request;

public class GeneralRequest {
	
	private String deckId;
	private Integer cardIndex;
	
	public String getDeckId() {
		return deckId;
	}

	public void setDeckId(String deckId) {
		this.deckId = deckId;
	}

	public Integer getCardIndex() {
		return cardIndex;
	}

	public void setCardIndex(Integer cardIndex) {
		this.cardIndex = cardIndex;
	}
}
