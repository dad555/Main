package com.artur.chat;

// типы сообщений пересылаемых между клиентом и сервером
public enum  MessageType {
    NAME_REQUEST,
    USER_NAME,
    NAME_ACCEPTED,
    TEXT,
    USER_ADDED,
    USER_REMOVED
}
