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
        
        PlayboyClient client1 = new PlayboyClient(1, 1, "A");
        NerdClient client2 = new NerdClient(1,1, "B");
        PlayboyClient client3 = new PlayboyClient(1, 1, "C");
        NerdClient client4 = new NerdClient(1, 1, "D");
        
        client1.start();
        client2.start();
        client3.start();
        client4.start();
        
    }
    
}
