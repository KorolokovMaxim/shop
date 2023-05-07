package com.korolkov.shop.enums.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
public enum Role {
    USER("Пользователь"),
    MODERATOR("Модератор"),
    ADMIN("Администратор");
    String rusName;

    Role(String rusName) {
        this.rusName = rusName;
    }

}
