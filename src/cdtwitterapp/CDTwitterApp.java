/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdtwitterapp;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.DirectMessage;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author otorradomiguez
 */
public class CDTwitterApp {

    /**
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
        
        ClaseTwitter mt=new ClaseTwitter();
        //mt.postearTweet(twitter);
        //mt.verTimeline(twitter);
       //mt.mensajeDirecto(twitter);
       mt.buscar(twitter);
    }
}
