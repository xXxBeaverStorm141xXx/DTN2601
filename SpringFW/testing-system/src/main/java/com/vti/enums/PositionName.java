package com.vti.enums;

import java.util.Arrays;

public enum PositionName {
    DEV("D"), TEST("T"), SCRUM_MASTER("SM"), PM("PM");

    private String name;

    PositionName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static PositionName toEnum(String sqlValue)
    {
//        for(PositionName name : PositionName.values())
//        {
//            if(name.getName().equals(sqlValue))
//            {
//                return name;
//            }
//        }
//        return null;
        return Arrays.stream(PositionName.values())
                .filter(i -> i.getName().equals(sqlValue)).findFirst().orElse(null);

    }
}
