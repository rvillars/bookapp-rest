package ch.bfh.swos.bookapp.rest.common;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: rovi
 * Date: 30.08.13
 * Time: 15:42
 * To change this template use File | Settings | File Templates.
 */
public class SerializableResourceBundleMessageSource extends ReloadableResourceBundleMessageSource {

    public Properties getAllProperties(Locale locale) {
        clearCacheIncludingAncestors();
        PropertiesHolder propertiesHolder = getMergedProperties(locale);
        Properties properties = propertiesHolder.getProperties();

        return properties;
    }
}
