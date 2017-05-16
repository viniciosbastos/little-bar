/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementations;

import java.util.concurrent.Semaphore;

/**
 *
 * @author alunoj8
 */
public class BarSemaphore extends Semaphore{

    boolean full;
    int available;
    int empty;
    
    public BarSemaphore(int permits) {
        super(permits);
        this.available = permits;
        this.empty = permits;
    }
    
    @Override
    public void acquire() throws InterruptedException {
        super.acquire();     
        this.empty--;
        if (availablePermits() == 0) {
            full = true;
        }
    }
    
    @Override
    public void release() {
        this.empty++;
        if (full && this.empty == this.available) {
            super.release(this.available);
            full = false;
        }
    }
    
}
