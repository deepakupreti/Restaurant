package com.example.restaurant.converter;

import com.google.common.base.Joiner;
import io.swagger.models.auth.In;

import javax.persistence.AttributeConverter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntegerListConverter implements AttributeConverter<List<Integer>, String> {

    @Override
    public String convertToDatabaseColumn(List<Integer> list) {
        // Java 8
        StringBuilder strbul  = new StringBuilder();
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext())
        {
            strbul.append(iter.next());
            if(iter.hasNext()){
                strbul.append(",");
            }
        }
        return strbul.toString();
    }

    @Override
    public List<Integer> convertToEntityAttribute(String joined) {
        return Stream.of(joined.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}