package com.santhosh;

import java.util.Random;

public class Joke {
    private String[] jokes = new String[]{"Why do Java developers wear glasses? Because they can't C#",
            "Why did the developer go broke? Because he used up all his cache",
            "There are 10 types of people in the world: those who understand binary, and those who don't.",
            "There's a band called 1023MB. They haven't had any gigs yet."};

    public String getJoke(){
        Random random = new Random(jokes.length);
        return jokes[random.nextInt(jokes.length)];
    }
}
