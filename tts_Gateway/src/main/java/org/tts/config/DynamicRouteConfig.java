package org.tts.config;

import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.*;

/**
 * @Description : 冬天配置路由
 * @Auther : Tianjx
 * @CreateTime : 2022/11/17 16:08
 */
@Component
public class DynamicRouteConfig {

    public List<RouteDefinition> getRouteDefintions(){
        RouteDefinition routeDefinition =new RouteDefinition();
        routeDefinition.setId("springboot-base-service");
        routeDefinition.setUri(URI.create("lb://tts-manage"));

        PredicateDefinition predicateDefinition =new PredicateDefinition();
        predicateDefinition.setName("Path");
        Map<String,String> argsMap =new HashMap<>();
        argsMap.put("pattern","/springboot/**");
        predicateDefinition.setArgs(argsMap);

        FilterDefinition filterDefinition =new FilterDefinition("StripPrefix=1");

        routeDefinition.setPredicates(Arrays.asList(predicateDefinition));
        routeDefinition.setFilters(Arrays.asList(filterDefinition));
        List<RouteDefinition> list = new ArrayList<>(4);
        list.add(routeDefinition);
        return list;
    }
}
