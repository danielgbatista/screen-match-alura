package br.com.alura.tabelafipe.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class ConvertData implements IConvertData {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> objectClass) {
        try{
            return mapper.readValue(json, objectClass);
        } catch (JsonProcessingException ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public <T> List<T> getList(String json, Class<T> objectClass) {
        CollectionType list = mapper.getTypeFactory().constructCollectionType(List.class, objectClass);

        try{
            return mapper.readValue(json, list);
        } catch (JsonProcessingException ex){
            throw new RuntimeException(ex);
        }
    }
}
