package com.jlc;

import java.util.Random;

public class RandomNoGenerator {
public static int random(int minimum,int maximum)
{
Random rn = new Random();
int range = maximum - minimum + 1;
int randomNum =  rn.nextInt(range) + minimum;
return randomNum;
}



}
