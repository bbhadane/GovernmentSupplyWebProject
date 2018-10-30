package com.Service;

import java.util.List;

import com.al.dao.AcceptedQuotesDao;
import com.al.dao.QuoteExistException;
import com.al.model.AcceptedQuotes;

public class AcceptedQuotesService implements AcceptedQuotesServiceInterface {

	@Override
	public List<AcceptedQuotes> getAllAcceptedQuotes() {
		
		return acceptedQuotesDao.getAllAcceptedQuotes();
	}

	@Override
	public void addAcceptedQuote(AcceptedQuotes acceptedQuote) throws QuoteExistException {
		acceptedQuotesDao.addAcceptedQuote(acceptedQuote);
		
	}

	
}
