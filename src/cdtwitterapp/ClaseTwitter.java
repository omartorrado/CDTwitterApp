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

/**
 *
 * @author otorradomiguez
 */
public class ClaseTwitter {

    public void mensajeDirecto(Twitter twitter) {

        DirectMessage message;
        try {
            message = twitter.sendDirectMessage("@DelioMirland", "Puta mierda de twitter");
            System.out.println("Sent: " + message.getText() + " to @" + message.getRecipientScreenName());
        } catch (TwitterException ex) {
            Logger.getLogger(CDTwitterApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

    public void postearTweet(Twitter twitter) {

        try {
            twitter.updateStatus(JOptionPane.showInputDialog("Escribe tu tweet"));
        } catch (TwitterException ex) {
            Logger.getLogger(CDTwitterApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscar(Twitter twitter) {
        try {
            Query query = new Query("#Galifornia");
            QueryResult result = twitter.search(query);
            for (Status status : result.getTweets()) {
                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
            }
        } catch (TwitterException ex) {
            Logger.getLogger(CDTwitterApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
