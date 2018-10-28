package com.Service;

import java.util.List;

import com.al.dao.ClientExistException;
import com.al.model.Client;

public class ClientService implements ClientServiceInterface {

	@Override
	public Client getClient(int clientId) {
		
		return clientDao.getClient(clientId);
	}

	@Override
	public List<Client> getAllClient() {
		// TODO Auto-generated method stub
		return clientDao.getAllClient();
	}

	@Override
	public void addClient(Client client) throws ClientExistException {
		
		clientDao.addClient(client);
		
	}

	@Override
	public void updateClient(Client client) {
		clientDao.updateClient(client);
		
	}

	@Override
	public void deleteClient(Client client) {
		clientDao.deleteClient(client);
		
	}

	
}
