package pl.corp.kkf.commons.openapi.codegen.extension;

import com.google.common.annotations.VisibleForTesting;
import io.swagger.codegen.v3.generators.typescript.TypeScriptAngularClientCodegen;
import io.swagger.v3.oas.models.Operation;
import org.codehaus.plexus.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TypeScriptAngularClientCodegenExtension extends TypeScriptAngularClientCodegen {

    private static final Pattern operationIdPattern = Pattern.compile("^(?<baseOperationId>.*)_\\d+$");

    @Override
    public String getName() {
        return "typescript-angular-extension";
    }

    @Override
    protected String getOrGenerateOperationId(Operation operation, String path, String httpMethod) {
        return fixOperationIdName(super.getOrGenerateOperationId(operation, path, httpMethod));
    }

    @Override
    public String toApiName(String name) {
        return fixApiName(super.toApiName(name));
    }

    @VisibleForTesting
    String fixOperationIdName(String operationId) {
        Matcher matcher = operationIdPattern.matcher(operationId);
        return matcher.matches() ? matcher.group("baseOperationId") : operationId;
    }

    @VisibleForTesting
    String fixApiName(String apiName) {
        if (StringUtils.isEmpty(apiName)) {
            return apiName;
        }
        return apiName.replaceAll("ServiceService$", "Service");
    }
}
