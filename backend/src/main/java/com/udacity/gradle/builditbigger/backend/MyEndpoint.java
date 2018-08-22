package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.learning.sami.joketeller.Jokes;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** An endpoint method that tells a joke */
    @ApiMethod(name = "tellAJoke")
    public MyBean tellAJoke() {
        MyBean response = new MyBean();
        Jokes joke = new Jokes();
        response.setData(joke.getJoke());

        return response;
    }

}
