package com.utils;

import java.util.HashMap;
import java.util.Map;

public enum WaitTime {
	LOW(2),
	MEDIUM(5),
	HIGH(8);
	private int value;
    private static Map map = new HashMap();

    private WaitTime(int value) {
        this.value = value;
    }

    static {
        for (WaitTime waitType : WaitTime.values()) {
            map.put(waitType.value, waitType);
        }
    }

    public static WaitTime valueOf(int waitType) {
        return (WaitTime) map.get(waitType);
    }

    public int getValue() {
        return value;
    }
}
