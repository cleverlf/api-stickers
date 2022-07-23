package com.imersaojava;

import java.io.IOException;
import java.net.MalformedURLException;

public interface Extractor {

    public void extract(String json) throws IOException, MalformedURLException, Exception;

}
