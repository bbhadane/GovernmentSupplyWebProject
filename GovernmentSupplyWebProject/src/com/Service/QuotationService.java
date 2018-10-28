package com.Service;

import java.util.List;

import com.al.dao.QuotationExistException;
import com.al.model.Quotation;

public class QuotationService implements QuotationServiceInterface {

	@Override
	public Quotation getQuotation(int quoteId) {
		// TODO Auto-generated method stub
		return quotationDao.getQuotation(quoteId);
	}

	@Override
	public List<Quotation> getAllQuotation() {
		// TODO Auto-generated method stub
		return quotationDao.getAllQuotation();
	}

	@Override
	public void addQuotation(Quotation quote) throws QuotationExistException {
		// TODO Auto-generated method stub
		quotationDao.addQuotation(quote);
	}

	@Override
	public void updateQuotation(Quotation quote) {
		// TODO Auto-generated method stub
		quotationDao.updateQuotation(quote);
	}

	@Override
	public void deleteQuotation(Quotation quote) {
		// TODO Auto-generated method stub
		quotationDao.deleteQuotation(quote);
	}

}
