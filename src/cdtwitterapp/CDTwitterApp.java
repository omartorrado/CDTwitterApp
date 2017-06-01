/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdtwitterapp;

import javax.swing.JOptionPane;
import twitter4j.Twitter;

/**
 *Clase main. Aqui se cargan las credenciales de twitter y se instancia la clase twitter
 * y el menu
 * @author otorradomiguez
 */
public class CDTwitterApp {

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ClaseTwitter mt = new ClaseTwitter();
        
        Twitter twitter = mt.config();
        
        int option = -1;
        do {
            try {
                option = Integer.parseInt(JOptionPane.showInputDialog("1.Mostrar Linea De Tiempo \n2.Postear Tweet \n3.Buscar \n4.Enviar Mensaje Directo \n0.Salir"));
            } catch (Exception ex) {
                System.out.println("Ha ocurrido un error");
            }
            switch (option) {
                case 1:
                    mt.verTimeline(twitter);
                    break;

                case 2:
                    mt.postearTweet(twitter);
                    break;

                case 3:
                    mt.buscar(twitter);
                    break;

                case 4:
                    mt.mensajeDirecto(twitter, JOptionPane.showInputDialog("Destinatario: "), JOptionPane.showInputDialog("Mensaje:"));
                    break;

                case 0:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error");
                    
            }

        } while (option != 0);
    }

}
