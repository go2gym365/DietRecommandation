package com.project.diet_rec.dto;

import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.diet_rec.entity.Member;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignupDto {
    
    @NotNull
    @Size(min = 3, max = 20)
    private String name;

    @NotNull
    @Size(min = 3, max = 20)
    private String nickname;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    @Size(min = 3, max = 20)
    private String username;

    @NotNull
    @Size(min = 3, max = 20)
    private String password;

    private Set<AuthorityDto> authorityDtoSet;

    public static SignupDto from(Member member) {
            if (member == null) return null;

            return SignupDto.builder()
                            .name(member.getName())
                            .nickname(member.getNickname())
                            .username(member.getUsername())
                            .authorityDtoSet(member.getAuthorities().stream()
                                            .map(authority -> AuthorityDto.builder()
                                                            .authorityName(authority.getAuthorityName()).build())
                                            .collect(Collectors.toSet()))
                            .build();
    }
}
