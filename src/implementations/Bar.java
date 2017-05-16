/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementations;

/**
 *
 * @author alunoj8
 */
public class Bar {
    int cadeiras;
    private BarSemaphore semaforo;
        
    public Bar(int c){        
        this.cadeiras = c;
        semaforo = new BarSemaphore(cadeiras);
    }           
        
    public void setCadeiras(int cadeiras) {
        this.cadeiras = cadeiras;
    }
    
    public void sitDown() throws InterruptedException {
        semaforo.acquire();
    }
    
    public void getUp() {
        semaforo.release();
    }
}




