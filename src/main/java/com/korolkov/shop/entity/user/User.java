package com.korolkov.shop.entity.user;

import com.korolkov.shop.entity.base.AuditEntity;
import com.korolkov.shop.enums.user.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name = "user")
@Table(name = "user", schema = "shop")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "user_id")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "user_created_by")),
        @AttributeOverride(name = "createdAt", column = @Column(name = "user_created_at")),
        @AttributeOverride(name = "updatedBy", column = @Column(name = "user_updated_by")),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "user_updated_at")),
        @AttributeOverride(name = "deletedBy", column = @Column(name = "user_deleted_by")),
        @AttributeOverride(name = "deletedAt", column = @Column(name = "user_deleted_at"))
})
@SequenceGenerator(name = "SEQ_ID", sequenceName = "user_user_id_seq", schema = "shop")
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Getter
@Setter
@Where(clause = " user_deleted_by IS NULL ")
@AllArgsConstructor
@NoArgsConstructor
public class User extends AuditEntity implements UserDetails {
    @Column(name = "user_firstname")
    String firstname;
    @Column(name = "user_surname")
    String surname;
    @Column(name = "user_lastname")
    String lastname;
    @Column(name = "user_email", unique = true, nullable = false)
    String email;
    @Column(name = "user_phone", unique = true, nullable = false)
    String phone;
    @Column(name = "user_password")
    String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
