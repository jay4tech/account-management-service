package com.example.account.utils;

import com.example.account.entity.AccountDetails;
import com.example.account.model.AuditEvent;
import com.example.account.model.TransactionEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


public class UtilityMapper {

    public static <T> Object responseToModel(String json, Class<T> tClass) {

        try {
            return getMapper().readValue(json, tClass);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static String getJsonString(Object order) {
        try {
            return getMapper().writeValueAsString(order);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static ObjectMapper getMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }

    public static AuditEvent getPrepareAuditEvent(Object accountDetails) {
        AuditEvent auditEvent = new AuditEvent<>();
        if (accountDetails instanceof AccountDetails)
            auditEvent.setAuditType("Account");
        if (accountDetails instanceof TransactionEvent)
            auditEvent.setAuditType("Transaction");
        auditEvent.setEventData(accountDetails);
        return auditEvent;
    }
}
