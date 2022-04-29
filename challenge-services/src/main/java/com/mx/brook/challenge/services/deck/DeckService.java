package com.mx.brook.challenge.services.deck;

import com.mx.brook.challenge.common.request.GetNextCardRequest;
import com.mx.brook.challenge.common.request.SkipNextCardRequest;
import com.mx.brook.challenge.common.response.GenerateDeckResponse;
import com.mx.brook.challenge.common.response.GetNextCardResponse;
import com.mx.brook.challenge.common.response.SkipNextCardResponse;

public interface DeckService {
	GenerateDeckResponse generateDeck();
	GetNextCardResponse getNextCard(GetNextCardRequest request);
	SkipNextCardResponse skipNextCard(SkipNextCardRequest request);
}
