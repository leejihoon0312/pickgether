package com.capstone.pick.controller.form;

import com.capstone.pick.dto.UserDto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddMoreInfoForm {

    private String gender;
    private String age_range;
    private String job;
    private String address;
}
