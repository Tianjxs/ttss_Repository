package org.tts.config;

import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * @Description : 动态配置路由
 * @Auther : Tianjx
 * @CreateTime : 2022/11/17 16:07
 */
@Component
public class DynamicRouteDefinitionRepository implements RouteDefinitionRepository {

    @Resource
    private DynamicRouteConfig dynamicRouteConfig;

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        return Flux.fromIterable(dynamicRouteConfig.getRouteDefintions());
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return null;
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return null;
    }
}
