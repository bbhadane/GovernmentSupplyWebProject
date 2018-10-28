package com.Service;

import java.util.List;

import com.al.dao.VendorExistsException;
import com.al.model.Vendor;

public class VendorService implements VendorServiceInterface {

	@Override
	public Vendor getVendor(int vendorId) {
		// TODO Auto-generated method stub
		return vendorDao.getVendor(vendorId);
	}

	@Override
	public List<Vendor> getAllVendors() {
		// TODO Auto-generated method stub
		return vendorDao.getAllVendors();
	}

	@Override
	public void addVendor(Vendor vendor) throws VendorExistsException {
		// TODO Auto-generated method stub
		vendorDao.addVendor(vendor);
	}

	@Override
	public void updateVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		vendorDao.updateVendor(vendor);
	}

	@Override
	public void deleteVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		vendorDao.deleteVendor(vendor);
	}

}
