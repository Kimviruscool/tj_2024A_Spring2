package example.Task1;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class AccountDto {
    int id ;
    String tmi;
    int price;
    String timer;
}
