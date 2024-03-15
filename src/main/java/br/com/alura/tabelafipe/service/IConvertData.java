package br.com.alura.tabelafipe.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface IConvertData {
    <T> T getData(String json, Class<T> objectClass) throws JsonProcessingException;
    <T> List<T> getList(String json, Class<T> objectClass) throws JsonProcessingException;
}
