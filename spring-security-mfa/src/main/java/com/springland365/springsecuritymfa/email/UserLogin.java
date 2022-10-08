package com.springland365.springsecuritymfa.email;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserLogin {

    String username ;

    String password ;

    String code ;
}
