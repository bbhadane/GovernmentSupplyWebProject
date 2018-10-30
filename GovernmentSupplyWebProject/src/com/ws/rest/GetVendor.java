package com.ws.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.Service.QuotationService;
import com.Service.VendorService;
import com.al.model.Quotation;
import com.al.model.Vendor;

@Path ("/Vendors")
public class GetVendor {

	VendorService vendorService=new VendorService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Vendor> getVendors()
	{
		 return vendorService.getAllVendors();
		 
	}
	
	
}
