package com.korolkov.shop.enums.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
public enum Role {
    USER("USER"),
    MODERATOR("MODERATOR"),
    ADMIN("ADMIN");
    String name;

    Role(String rusName) {
        this.name = rusName;
    }

}
