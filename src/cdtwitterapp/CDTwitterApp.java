/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdtwitterapp;

import javax.swing.JOptionPane;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

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

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("SWA7c8iZgWMdjpJ5IhBMEYjZF")
                .setOAuthConsumerSecret("mfT4rgMZtUadmGIz9Duel3I3u1LUxuWBiGC2zSGcVScBEBhUj7")
                .setOAuthAccessToken("843738764589654017-2kMkqJDH6oEua3bMtvDExHbKJfTYQlt")
                .setOAuthAccessTokenSecret("XNnDG5wk8cHFQwmax2feq7oQexnNiFVrOyqSotZZxVasv");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        ClaseTwitter mt = new ClaseTwitter();

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
