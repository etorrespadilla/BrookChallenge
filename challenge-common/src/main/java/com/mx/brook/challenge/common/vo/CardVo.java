package com.mx.brook.challenge.common.vo;

public class CardVo {
	
	public CardVo() {
		super();
	};
	public CardVo(String number, String type) {
		super();
		this.number = number;
		this.type = type;
	}

	private String number;
	private String type;
	private int index;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public String getCardName() {
		return number.concat(" of ").concat(type);
	}
	
}
