/*
 * Created on 22-abr-2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package utils;

/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Semaphore {

	/* 
	 * Se implmenta un semaforo de conteo, siempre
	 * su valor debe ser iniciado en uno.
	 */

	    public Semaphore(int count) {
		
		this.count = count;
	    }

	    private int count = 0;

	    public Semaphore() {
	    }

	    public synchronized void semWait() {
		count--;
		
		while (count < 0) {
		    try {
			wait();
		    } catch (InterruptedException ie) { }
		}
	    }

	    public synchronized void semSignal() {
		
		count++;
		
		if (count >= 0) {
		    notifyAll();
		}
	    }
}
