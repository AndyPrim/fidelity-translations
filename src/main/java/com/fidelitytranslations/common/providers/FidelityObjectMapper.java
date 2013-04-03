package com.fidelitytranslations.common.providers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

public class FidelityObjectMapper extends ObjectMapper {

    public static String dateFormat = "yyyy-MM-dd'T'HH:mm:ss"; //ISO 8601

    public FidelityObjectMapper() {
        super();
        super.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
        super.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        super.configure(SerializationConfig.Feature.USE_ANNOTATIONS, true);
        super.configure(DeserializationConfig.Feature.USE_ANNOTATIONS, true);
        super.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        DateFormat df = new SimpleDateFormat(dateFormat);
        this.setDateFormat(df);
        AnnotationIntrospector primary = new JacksonAnnotationIntrospector();
        AnnotationIntrospector secondary = new JaxbAnnotationIntrospector();
        AnnotationIntrospector pair = new AnnotationIntrospector.Pair(primary, secondary);
        super.getSerializationConfig().withAnnotationIntrospector(pair);
        super.getDeserializationConfig().withAnnotationIntrospector(pair);
        super.setVisibilityChecker(super.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
    }
}
