package edu.htl3r.schoolplanner.gui.basti;

import java.util.concurrent.LinkedBlockingQueue;

public class BlockingDownloadQueue extends LinkedBlockingQueue<TransferObject> {

	
	private boolean isInterrupted = false;

	public void interrupt() {
		if (!isInterrupted) {
			add(new InterruptTranferObject());
			isInterrupted = true;
		}
	}

	public boolean isInterrupted() {
		return isInterrupted;
	}

	
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return super.contains(o);
	}
}
