/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import implementations.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alunoj8
 */
public class Client extends Thread implements BarClient{
    protected int tempoBar;
    protected int tempoCasa;
    protected String nome;
    
    public Client(int tb, int tc, String nome) {
        this.tempoBar = tb;
        this.tempoCasa = tc;
        this.nome = nome;
    }

    @Override
    public void IrBar() {}

    @Override
    public void IrCasa() {}

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println(nome + " está na fila do bar.");
                Principal.bar.sitDown();
                System.out.println(nome + " sentou no bar.");
                IrBar();
                Principal.bar.getUp();
                System.out.println(nome + " saiu do bar.");                
                IrCasa();
            } catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
