package org.smlee;

import org.auction.AuctionSniperDriver;
import org.auction.FakeAuctionServer;


public class ApplicationRunner {
	
	public static final String SNIPER_ID = "sniper";
	public static final String SNIPER_PASSWORD = "sniper";
	protected static final String XMPP_HOSTNAME = "127.0.0.1";
	
//	private static final String STATUS_JOINING = "STATUS_JOINING";
//	private static final String STATUS_LOST = "STATUS_LOST";
	private AuctionSniperDriver driver;
	
	
	public ApplicationRunner() {
	}
	
	public void startBiddingIn( final FakeAuctionServer auction) {
		Thread thread = new Thread("Test Application") {
			@Override
			public void run() {
				try {
					Main.main( new String[]{XMPP_HOSTNAME, SNIPER_ID, SNIPER_PASSWORD , auction.getItemId()} );
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		};
		
		thread.setDaemon( true );
		thread.start();
		driver = new AuctionSniperDriver(1000);
		driver.showsSniperStatus( Status.STATUS_JOINING );
	}
	
	
	public void showsSniperHasLostAuction() {
		driver.showsSniperStatus(Status.STATUS_LOST );
	}
	
	public void stop(){
		if( null != driver ) {
			driver.dispose ();
		}
	}
}
