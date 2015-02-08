package org.auction;
import static org.hamcrest.Matchers.*;

import java.awt.Component;

import javax.swing.JFrame;

import org.hamcrest.Matcher;
import org.smlee.Main;

import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.driver.ComponentDriver;
import com.objogate.wl.swing.driver.JFrameDriver;
import com.objogate.wl.swing.driver.JLabelDriver;
import com.objogate.wl.swing.gesture.GesturePerformer;


public class AuctionSniperDriver extends JFrameDriver {
	
	
	public AuctionSniperDriver(	ComponentDriver<? extends Component> parentOrOwner,	Class<JFrame> componentType, Matcher<? super JFrame>[] matchers) {
		super(parentOrOwner, componentType, matchers);
		
	}
	
	public AuctionSniperDriver(int timeoutMillis) {
		super( new GesturePerformer(),
				JFrameDriver.topLevelFrame( named(Main.MAIN_WINDOW_NAME),
						showingOnScreen()),
						new AWTEventQueueProber(timeoutMillis, 100));
	}

	public void showsSniperStatus(String statusText) {
		new JLabelDriver( this, named(Main.SNIPER_STATUS_NAME)).hasText( equalTo(statusText ));
	}

	public void dispose() {
		
	}

}
