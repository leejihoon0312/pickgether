package com.capstone.pick.security;

import com.capstone.pick.config.OAuthAttributes;
import com.capstone.pick.dto.UserDto;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VotePrincipal implements OAuth2User,UserDetails {

    private String username;
    private String password;
    private final String authority ="ROLE_USER";
    private String email;
    private String nickname;
    private String birthday;
    private String memo;
    private String provider;
    private String gender;
    private String age_range;

    private OAuthAttributes oAuthAttributes;

    public static VotePrincipal from(UserDto dto) {
        return VotePrincipal.builder()
                .username(dto.getUserId())
                .password(dto.getUserPassword())
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .birthday(dto.getBirthday())
                .memo(dto.getMemo())
                .gender(dto.getGender())
                .age_range(dto.getAge_range())
                .provider(dto.getProvider())
                .build();
    }

    public UserDto toDto() {
        return UserDto.builder()
                .userId(username)
                .userPassword(password)
                .email(email)
                .nickname(nickname)
                .birthday(birthday)
                .memo(memo)
                .gender(gender)
                .age_range(age_range)
                .provider(provider)
                .build();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return oAuthAttributes.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton((GrantedAuthority) () -> authority);
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

    @Override
    public String getName() {
        return oAuthAttributes.getUsername();
    }
}
