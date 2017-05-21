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
public class Bar {

    int cadeiras;
    int empty;
    boolean full;
    //private BarSemaphore semaforo;
    Semaphore semaforo;
    Semaphore mutex;

    public Bar(int c) {
        this.cadeiras = c;
        this.empty = c;
        this.full = false;
        //semaforo = new BarSemaphore(cadeiras);
        semaforo = new Semaphore(c);
        mutex = new Semaphore(1);
    }

    public void setCadeiras(int cadeiras) {
        this.cadeiras = cadeiras;
    }

    public void sitDown() throws InterruptedException {
        semaforo.acquire();
        mutex.acquire();
        this.empty -= 1;
        if (this.empty == 0) {
            Log.log("cheio");
            full = true;
        }
        mutex.release();
    }

    public void getUp() throws InterruptedException {
        mutex.acquire();
        if (full) {
            this.empty += 1;
            if (this.empty == this.cadeiras) {
                semaforo.release();
                semaforo.release();
                Log.log("vazio");
            }
        } else {
            this.empty += 1;
        }
        mutex.release();
//        if (full && this.empty == 0) {
//            full = false;
//            this.empty = this.cadeiras;
//            semaforo.release();
//            semaforo.release();
//            Log.log("vazio");
//        } else {
//            this.empty += 1;
//        }
//        mutex.release();
    }
}
