/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdtwitterapp;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import twitter4j.DirectMessage;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 *Aqui estan los metodos que manejan las funciones de twitter
 * @author otorradomiguez
 */
public class ClaseTwitter {
    
    /**
     * Este metodo instancia un objeto de la clase twitter y lo devuelve para
     * que el resto de metodos puedan trabajar usandolo
     * @return el objeto de la clase Twitter con los token del archivo twitter4j.properties
     */
    public Twitter config(){
        Twitter twitter = new TwitterFactory().getInstance();
        return twitter;
    }
    
    /**
     * Envia Mensajes privados al usuario indicado
     * @param twitter instancia de la clase twitter que llama al metodo
     * @param destinatario destinatario del mensaje 
     * @param mensaje Contenido del mensaje
     */
    public void mensajeDirecto(Twitter twitter, String destinatario, String mensaje) {

        DirectMessage message;
        try {
            message = twitter.sendDirectMessage(destinatario, mensaje);
            System.out.println("Sent: " + message.getText() + " to @" + message.getRecipientScreenName());
        } catch (TwitterException ex) {
            Logger.getLogger(CDTwitterApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Muestra por consola tu timeline
     * @param twitter instancia de la clase twitter que llama al metodo
     */
    public void verTimeline(Twitter twitter) {

        try {
            List<Status> statuses = twitter.getHomeTimeline();
            System.out.println("Showing home timeline.");
            for (Status status : statuses) {
                System.out.println(status.getUser().getName() + ":"
                        + status.getText() + status.getCreatedAt());
            }
        } catch (TwitterException ex) {
            Logger.getLogger(CDTwitterApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Crea un tweet
     * @param twitter instancia de la clase twitter que llama al metodo
     */
    
    public void postearTweet(Twitter twitter) {

        try {
            twitter.updateStatus(JOptionPane.showInputDialog("Escribe tu tweet"));
        } catch (TwitterException ex) {
            Logger.getLogger(CDTwitterApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Busca tweets que contengan la palabra indicada
     * @param twitter instancia de la clase twitter que llama al metodo
     */
    public void buscar(Twitter twitter) {
        try {
            Query query = new Query(JOptionPane.showInputDialog("¿Que quieres buscar?"));
            QueryResult result = twitter.search(query);
            for (Status status : result.getTweets()) {
                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
            }
        } catch (TwitterException ex) {
            Logger.getLogger(CDTwitterApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
