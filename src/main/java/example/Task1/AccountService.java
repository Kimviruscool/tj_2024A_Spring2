package example.Task1;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2

public class AccountService {
    @Autowired AccountDao accountDao;

    public int put(AccountDto accountDto){
        log.info("C info success");
        return accountDao.put(accountDto);
    }

    public List<AccountDto> find(){
        return accountDao.find();
    }

    public int update(AccountDto accountDto){
        log.info("U info success");
        return accountDao.update(accountDto);
    }

    public int delete(int id){
        log.info("D info success");
        return accountDao.delete(id);
    }
}
