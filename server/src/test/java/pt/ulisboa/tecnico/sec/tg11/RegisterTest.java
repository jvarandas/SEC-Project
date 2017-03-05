package pt.ulisboa.tecnico.sec.tg11;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pt.tecnico.ulisboa.sec.tg11.PWInterface.exceptions.UserAlreadyExistsException;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

import static org.junit.Assert.assertArrayEquals;

public class RegisterTest extends AbstractTest{

	@Test
	public void registerUser() throws RemoteException, UserAlreadyExistsException {
		server.register(keypair.getPublic());

	}

	@Test (expected = UserAlreadyExistsException.class)
	public void registerDuplicateUser() throws RemoteException, UserAlreadyExistsException {
		server.register(keypair.getPublic());
		server.register(keypair.getPublic());
	}

}
