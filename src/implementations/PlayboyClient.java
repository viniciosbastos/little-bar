/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementations;

import interfaces.Client;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alunoj8
 */
public class PlayboyClient extends Client{

    public PlayboyClient(int tb, int tc, String nome) {
        super(tb, tc, nome);
    }

    @Override
    public void IrBar() {        
//        System.out.println(this.nome + " está caçando as cocotinha.");
        for (int i = 0; i < this.tempoBar; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PlayboyClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void IrCasa() {
//        System.out.println(this.nome + " esqueceu de comprar a camisinha");
        for (int i = 0; i < this.tempoCasa; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PlayboyClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
