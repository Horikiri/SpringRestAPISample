package jp.co.foxbit.horikiri.spring.rest.sample.controller.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.foxbit.horikiri.spring.rest.sample.model.result.InformationResult;

@RestController
public class InformationRestController {

    private final List<InformationResult> informationResult = new ArrayList<InformationResult>();

    public InformationRestController() {

        this.informationResult.add(new InformationResult("a.@foxbit.co.jp", "‚ ", "A", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), true));
        this.informationResult.add(new InformationResult("b.@foxbit.co.jp", "‚¢", "B", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), true));
        this.informationResult.add(new InformationResult("c.@foxbit.co.jp", "‚¤", "C", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), true));
    }

    @RequestMapping(value = "/information/api/fetch/top", method = RequestMethod.GET)
    public InformationResult fetchTopInformation() {

        return informationResult.get(0);
    }

    @RequestMapping(value = "/information/api/fetch/all", method = RequestMethod.GET)
    public List<InformationResult> fetchAllInformation() {

        return informationResult;
    }

}
