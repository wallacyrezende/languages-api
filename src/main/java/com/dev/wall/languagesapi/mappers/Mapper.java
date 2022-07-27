package com.dev.wall.languagesapi.mappers;

import java.util.Optional;

public class Mapper {
    public static <T> boolean isNull(T object){
        return Optional.ofNullable(object).isEmpty();
    }
}
