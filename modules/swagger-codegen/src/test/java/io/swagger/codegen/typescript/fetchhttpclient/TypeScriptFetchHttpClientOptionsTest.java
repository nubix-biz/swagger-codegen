package io.swagger.codegen.typescript.fetchhttpclient;

import io.swagger.codegen.AbstractOptionsTest;
import io.swagger.codegen.CodegenConfig;
import io.swagger.codegen.languages.TypeScriptFetchHttpClientCodegen;
import io.swagger.codegen.options.TypeScriptFetchHttpClientOptionsProvider;
import mockit.Expectations;
import mockit.Tested;

public class TypeScriptFetchHttpClientOptionsTest extends AbstractOptionsTest {

    @Tested
    private TypeScriptFetchHttpClientCodegen clientCodegen;

    public TypeScriptFetchHttpClientOptionsTest() {
        super(new TypeScriptFetchHttpClientOptionsProvider());
    }

    @Override
    protected CodegenConfig getCodegenConfig() {
        return clientCodegen;
    }

    @SuppressWarnings("unused")
    @Override
    protected void setExpectations() {
        new Expectations(clientCodegen) {{
            clientCodegen.setSortParamsByRequiredFlag(Boolean.valueOf(TypeScriptFetchHttpClientOptionsProvider.SORT_PARAMS_VALUE));
            times = 1;
            clientCodegen.setModelPropertyNaming(TypeScriptFetchHttpClientOptionsProvider.MODEL_PROPERTY_NAMING_VALUE);
            times = 1;
            clientCodegen.setSupportsES6(TypeScriptFetchHttpClientOptionsProvider.SUPPORTS_ES6_VALUE);
            times = 1;
        }};
    }
}
