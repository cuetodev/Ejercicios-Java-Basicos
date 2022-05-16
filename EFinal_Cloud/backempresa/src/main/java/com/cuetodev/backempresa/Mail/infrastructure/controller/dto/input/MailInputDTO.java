package com.cuetodev.backempresa.Mail.infrastructure.controller.dto.input;

import com.cuetodev.backempresa.Mail.domain.Mail;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MailInputDTO {

    public Mail convertToEntity() {
        return new Mail();
    }
}
