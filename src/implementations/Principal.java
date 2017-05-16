package implementations;


import implementations.Bar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alunoj8
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    
    public static Bar bar;
    
    public static void main(String[] args) {
        // TODO code application logic here
        bar = new Bar(2);
        
        PlayboyClient client1 = new PlayboyClient(10, 5, "Carlin");
        NerdClient client2 = new NerdClient(5, 10, "Franciscleidson");
        PlayboyClient client3 = new PlayboyClient(10, 5, "BoyMagia");
        NerdClient client4 = new NerdClient(5, 10, "Tyrion");
        
        client1.start();
        client2.start();
        client3.start();
        client4.start();
        
    }
    
}
