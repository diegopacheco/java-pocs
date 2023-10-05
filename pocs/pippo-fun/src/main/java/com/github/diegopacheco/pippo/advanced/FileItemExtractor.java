package com.github.diegopacheco.pippo.advanced;

import org.kohsuke.MetaInfServices;
import ro.pippo.controller.MethodParameter;
import ro.pippo.controller.extractor.MethodParameterExtractor;
import ro.pippo.core.FileItem;
import ro.pippo.core.route.RouteContext;

@MetaInfServices
public class FileItemExtractor implements MethodParameterExtractor {

    @Override
    public boolean isApplicable(MethodParameter parameter) {
        return FileItem.class == parameter.getParameterType();
    }

    @Override
    public Object extract(MethodParameter parameter, RouteContext routeContext) {
        String name = parameter.getParameterName();

        return routeContext.getRequest().getFile(name);
    }

}