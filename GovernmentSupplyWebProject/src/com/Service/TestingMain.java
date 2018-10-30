package com.Service;

import java.util.List;

import com.al.model.Quotation;
import com.al.model.Vendor;

public class TestingMain {

	public static void main(String[] args)
	{
//		QuotationService quotationService = new QuotationService();
//		List<Quotation> allQuotationList = quotationService.getAllQuotation();
//	//	List<Quotation> lowestQuotedCostFisrtList = quotationService.lowestQuotedCostFisrt(allQuotationList);
//		List<Quotation> earliestDeliveryList = quotationService.earliestDelivery(allQuotationList);
//		for(Quotation q : earliestDeliveryList)
//		{
//			System.out.println(q);
//		}
		
		VendorService vendorService = new VendorService();
		List<Vendor> allVendorsList = vendorService.getAllVendors();
		List<Vendor> bestVendorFirst = vendorService.bestVendorFirst(allVendorsList);
		for(Vendor v : bestVendorFirst)
		{
			System.out.println(v);
		}
	}

}
