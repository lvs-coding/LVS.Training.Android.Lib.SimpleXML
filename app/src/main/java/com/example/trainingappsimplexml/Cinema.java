package com.example.trainingappsimplexml;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by laurent on 4/28/17.
 */
@Root
public class Cinema {
    @Attribute
    public String name;

    @ElementList(entry="movie", inline = true)
    public List<Movie> movies;
}
