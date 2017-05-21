/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 *
 * @author alunoj8
 */
public class Bar {

    int cadeiras;
    int empty;
    boolean full;
    List<Semaphore> filaDeEspera;
    //private BarSemaphore semaforo;
//    Semaphore semaforo;
    Semaphore mutex;

    public Bar(int c) {
        this.cadeiras = c;
        this.empty = c;
        this.full = false;
        //semaforo = new BarSemaphore(cadeiras);
  //      semaforo = new Semaphore(c);
        mutex = new Semaphore(1);
        filaDeEspera = new ArrayList();
    }

    public void setCadeiras(int cadeiras) {
        this.cadeiras = cadeiras;
    }

    public void sitDown() throws InterruptedException {
        mutex.acquire();
        if (!full) {
            this.empty -= 1;
            if (this.empty == 0) {
                full = true;
                Log.log("cheio");
            }
            mutex.release();
        } else {
            mutex.release();
            entrarFilaDeEspera();
        }        
    }

    public void getUp() throws InterruptedException {
        mutex.acquire();
        if (full) {
            this.empty += 1;
            if (this.empty == this.cadeiras) {
                full = false;
                Log.log("vazio");
                if (!filaDeEspera.isEmpty()) {
                    mutex.release();
                    for (int i = 0; i < this.cadeiras; i++) {
                        chamarFilaDeEspera();
                    }
                    return;
                }
            }
            mutex.release();
        } else {
            this.empty += 1;
            if (this.empty > this.cadeiras)
                this.empty = this.cadeiras;
            mutex.release();
        }
    }

    private void entrarFilaDeEspera() throws InterruptedException {
        Semaphore s = new Semaphore(0);
        filaDeEspera.add(s);
        s.acquire();
    }
    
    private void chamarFilaDeEspera() {
        if (!filaDeEspera.isEmpty()) {
            Semaphore s = filaDeEspera.remove(0);
            s.release();
        }
    }
}
