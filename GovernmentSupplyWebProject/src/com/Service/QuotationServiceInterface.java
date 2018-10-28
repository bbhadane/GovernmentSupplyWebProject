package com.Service;

import java.util.List;

import com.al.dao.QuotationDao;
import com.al.dao.QuotationDaoImpl;
import com.al.dao.QuotationExistException;
import com.al.model.Quotation;

public interface QuotationServiceInterface {

	QuotationDao quotationDao=new QuotationDaoImpl();
	
	Quotation getQuotation(int quoteId);
	List<Quotation> getAllQuotation();
	void addQuotation(Quotation quote)throws QuotationExistException;
	void updateQuotation(Quotation quote);
	void deleteQuotation(Quotation quote);
}
