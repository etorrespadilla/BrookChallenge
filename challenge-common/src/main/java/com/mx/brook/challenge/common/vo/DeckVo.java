package com.mx.brook.challenge.common.vo;

import java.util.LinkedList;

public class DeckVo {
	
	private String deckId;
	private LinkedList<CardVo> cardVoList;
	public String getDeckId() {
		return deckId;
	}
	public void setDeckId(String deckId) {
		this.deckId = deckId;
	}
	public LinkedList<CardVo> getCardVoList() {
		return cardVoList;
	}
	public void setCardVoList(LinkedList<CardVo> cardVoList) {
		this.cardVoList = cardVoList;
	}
	
	
}
