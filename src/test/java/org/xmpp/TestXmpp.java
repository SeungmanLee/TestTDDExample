package org.xmpp;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.junit.Test;



public class TestXmpp {

	@Test
	public void testLoginSniper() throws Exception {
		String username = "sniper";
		String password = "sniper";
		         		
		XmppConnect(username, password);
		
		
		
	}

	@Test
	public void testLoginAuction() throws Exception {
		String username = "auction";
		String password = "auction";
		
		XmppConnect(username, password);
	}

	private XMPPConnection XmppConnect(String username, String password)
			throws XMPPException {
		XMPPConnection connection = new XMPPConnection("127.0.0.1");
		connection.connect();
		connection.login(username, password);
		return connection;
	}
	
	@Test
	public void testChat() throws Exception {
		XMPPConnection sniper = XmppConnect( "sniper", "sniper");
		XMPPConnection auction = XmppConnect( "auction", "auction");
		
//		auction.getChatManager().createChat("auction", listener)
		
	}
	
	
}
