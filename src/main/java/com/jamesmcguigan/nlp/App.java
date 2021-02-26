package com.jamesmcguigan.nlp;

import com.jamesmcguigan.nlp.v1.classifier.OpenNLPClassifierES;
import com.jamesmcguigan.nlp.v1.classifier.OpenNLPClassifierTweet;
import com.jamesmcguigan.nlp.v1.enricher.OpenNLPEnricher;

import java.io.IOException;

public class App {
    public static void main( String[] args ) throws IOException {
        OpenNLPClassifierTweet.main(args);
        OpenNLPClassifierES.main(args);
        OpenNLPEnricher.main(args);
    }
}
