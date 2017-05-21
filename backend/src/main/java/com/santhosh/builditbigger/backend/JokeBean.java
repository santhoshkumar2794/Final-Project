package com.santhosh.builditbigger.backend;

import com.santhosh.Joke;

/**
 * The object model for the data we are sending through endpoints
 */
public class JokeBean {

    private Joke joke;

    public JokeBean(Joke joke) {
        this.joke = joke;
    }

    public JokeBean(){
        joke = new Joke();
    }

    public String getJoke(){
        return joke.getJoke();
    }
}