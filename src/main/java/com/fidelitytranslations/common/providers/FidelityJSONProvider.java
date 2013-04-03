package com.fidelitytranslations.common.providers;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;

@Provider
@Consumes({ MediaType.APPLICATION_JSON, "text/json" })
@Produces({ MediaType.APPLICATION_JSON, "text/json" })
public class FidelityJSONProvider extends JacksonJaxbJsonProvider {

    public FidelityJSONProvider(ObjectMapper mapper) {
        super(mapper, DEFAULT_ANNOTATIONS);
    }
}
