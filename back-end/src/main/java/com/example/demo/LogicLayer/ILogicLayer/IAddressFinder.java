package com.example.demo.LogicLayer.ILogicLayer;

import java.io.IOException;

public interface IAddressFinder {
    String FindAddress(String lat, String lon) throws IOException;
}
