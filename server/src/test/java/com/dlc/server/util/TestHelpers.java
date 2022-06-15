package com.dlc.server.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestHelpers {
    public static String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
