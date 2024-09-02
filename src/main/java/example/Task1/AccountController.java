package example.Task1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired private AccountService accountService;

    //c
    @PutMapping("/put")
    public int put(AccountDto accountDto){
        return accountService.put(accountDto);
    }
    //r
    @GetMapping("/get")
    public List<AccountDto> find(){
        return accountService.find();
    }
    //u
    @PostMapping("/update")
    public int update(AccountDto accountDto){
        return accountService.update(accountDto);
    }
    //d
    @DeleteMapping("/delete")
    public int delete(int id){
    return accountService.delete(id);
    }
}
