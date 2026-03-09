package com.accenture.service.dto;

import com.accenture.utils.Messages;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.aspectj.bridge.Message;

public record AdminRequestDto(

        @NotBlank(message = Messages.ADMIN_FIRSTNAME_NULLORBLANK)
        @Valid
        String firstName,

        @NotBlank(message = Messages.ADMIN_LASTNAME_NULLORBLANK)
        @Valid
        String lastName,

        @NotBlank(message = Messages.ADMIN_FUNCTION_NULLORBLANK)
        @Valid
        String function,

        @NotBlank(message = Messages.ADMIN_MAIL_NULLORBLANK)
        @Email(message = Messages.ADMIN_MAIL_WRONGFORMAT)
        @Schema(example = "mail@mail.com")
        @Valid
        String mail,

        @NotBlank(message = Messages.ADMIN_PASSWORD_NULLORBLANK)
        @Pattern(regexp = "^(?=.*\\p{Nd})(?=.*\\p{Lu})(?=.*\\p{Ll})(?=.*[&#@_§-])[\\p{L}\\p{Nd}&#@_§-]{8,16}$", message = Messages.ADMIN_PASSWORD_WRONGFORMAT)
        @Schema(example = "Abcdef1&")
        @Valid
        String password
) {
}
