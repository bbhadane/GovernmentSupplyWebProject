package com.Service;
import java.util.ArrayList;
import java.util.List;
import com.al.dao.QuotationDao;
import com.al.dao.QuotationDaoImpl;
import com.al.dao.VendorDao;
import com.al.dao.VendorDaoImpl;
import com.al.model.Quotation;
import com.al.model.Vendor;

public class QuotationSelectionService
{
	public List<Quotation> quotationSelection(int orderId)
	{	
		List<Quotation> MatchingQuotationList=new ArrayList<Quotation>();
		QuotationDao quotationDao=new QuotationDaoImpl();
		List<Quotation> allQuotation = quotationDao.getAllQuotation();
		for(Quotation q:allQuotation)
		{
			if(orderId == q.getOrder().getOrderId())
			{
				MatchingQuotationList.add(q);
			}
		}
		QuotationService quotationService=new QuotationService();
		List<Quotation> lowestQuotedCostFisrt = quotationService.lowestQuotedCostFisrt(MatchingQuotationList);
		List<Quotation> earliestDelivery = quotationService.earliestDelivery(MatchingQuotationList);
		List<Vendor> MatchingVendorList = new ArrayList<Vendor>();
		for(Quotation Q:MatchingQuotationList)
		{
			MatchingVendorList.add(Q.getVendor());
		}
		VendorDao vendorDao= new VendorDaoImpl();
		List<Vendor> allVendors = vendorDao.getAllVendors();
		VendorService vendorService = new VendorService();
		List<Vendor> bestVendorFirst = vendorService.bestVendorFirst(MatchingVendorList);
		List<Vendor> oldestVendor = vendorService.oldestVendor(MatchingVendorList);
		List<Quotation> CombinedFilteredQuotation = new ArrayList<Quotation>();
		CombinedFilteredQuotation.add(lowestQuotedCostFisrt.get(0));//quote of lowest cost
		CombinedFilteredQuotation.add(earliestDelivery.get(0));//quote with earliest delivery date
		for(Quotation Q1:MatchingQuotationList)
		{
			if(Q1.getOrder().getOrderId() == bestVendorFirst.get(0).getVendorId())
				CombinedFilteredQuotation.add(Q1);//Quote with vendor having Highest ratings
			if(Q1.getOrder().getOrderId()==oldestVendor.get(0).getVendorId())
				CombinedFilteredQuotation.add(Q1);//Quote with oldest vendor 
		}
		return CombinedFilteredQuotation;
	}
}
