package example.log;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2

public class Logservice {

    public void log(){
        log.debug("LogController debug log");
        log.info("LogController info log");
        log.warn("LogController warn log");
        log.error("LogController error log");
        log.fatal("LogController fatal log");
    }

}
