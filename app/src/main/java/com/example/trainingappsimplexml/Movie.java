package com.example.trainingappsimplexml;

import org.simpleframework.xml.Element;

/**
 * Created by laurent on 4/28/17.
 */

@Element(name="movie")
public class Movie {
    @Element
    public String title;

    @Element
    public int year;

}
