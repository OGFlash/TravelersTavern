package com.wildlab.travelerstavern.views;

import java.util.Random;

/**
 * Created by Cory Swaller on 9/30/2017.
 */

class RollingTheDiceView {
    private int generateRandomNumber(int topRoll){
        Random random = new Random();
        int randomNumber;
        randomNumber = random.nextInt(topRoll) + 1;
        return randomNumber;
    }


}
