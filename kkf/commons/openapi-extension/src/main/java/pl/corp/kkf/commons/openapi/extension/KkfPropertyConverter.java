package pl.corp.kkf.commons.openapi.extension;

import com.fasterxml.jackson.databind.JavaType;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverter;
import io.swagger.v3.core.converter.ModelConverterContext;
import io.swagger.v3.core.util.Json;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Map;

public class KkfPropertyConverter implements ModelConverter {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public Schema resolve(AnnotatedType type, ModelConverterContext context, Iterator<ModelConverter> chain) {
        JavaType javaType = Json.mapper().constructType(type.getType());
        if (javaType != null) {
            Class<?> cls = javaType.getRawClass();
            if (LocalDateTime.class.isAssignableFrom(cls)) {
                Schema result = process(type, context, chain);
                if (result == null) {
                    result = new StringSchema();
                }

                return result
                        .format("date-time-local")
                        .extensions(Map.of("x-java-type", cls.getName()));
            }
        }
        return process(type, context, chain);
    }

    private Schema<?> process(AnnotatedType type, ModelConverterContext context, Iterator<ModelConverter> chain) {
        if (chain.hasNext()) {
            return chain.next().resolve(type, context, chain);
        }
        return null;
    }
}
