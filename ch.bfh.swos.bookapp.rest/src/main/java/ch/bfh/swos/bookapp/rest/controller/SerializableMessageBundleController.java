package ch.bfh.swos.bookapp.rest.controller;

import ch.bfh.swos.bookapp.rest.common.SerializableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.Locale;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: rovi
 * Date: 30.08.13
 * Time: 15:57
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/messageBundle")
public class SerializableMessageBundleController {

    @Inject
    SerializableResourceBundleMessageSource messageBundle;

    /**
     * ReadAll
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Properties list(@RequestParam String lang) {
        return messageBundle.getAllProperties(new Locale(lang));
    }
}
