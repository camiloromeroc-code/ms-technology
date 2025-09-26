package com.bootcamps.ms_technologies.infrastructure.adapter.in.web;

import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class TechnologyRouter {

    @Bean
    @RouterOperations({
            @RouterOperation(
                    path = "/api/technologies",
                    beanClass = TechnologyHandler.class,
                    beanMethod = "getAll",
                    operation = @Operation(
                            summary = "Obtener todas las tecnologías",
                            description = "Devuelve el listado completo de tecnologías registradas"
                    )
            ),
            @RouterOperation(
                    path = "/api/technologies/{id}",
                    beanClass = TechnologyHandler.class,
                    beanMethod = "getById",
                    operation = @Operation(
                            summary = "Obtener tecnología por ID",
                            description = "Busca una tecnología en base a su identificador único"
                    )
            ),
            @RouterOperation(
                    path = "/api/technologies",
                    beanClass = TechnologyHandler.class,
                    beanMethod = "create",
                    operation = @Operation(
                            summary = "Crear tecnología",
                            description = "Crea una nueva tecnología en el sistema"
                    )
            ),
            @RouterOperation(
                    path = "/api/technologies/{id}",
                    beanClass = TechnologyHandler.class,
                    beanMethod = "update",
                    operation = @Operation(
                            summary = "Actualizar tecnología",
                            description = "Actualiza los datos de una tecnología existente"
                    )
            ),
            @RouterOperation(
                    path = "/api/technologies/{id}",
                    beanClass = TechnologyHandler.class,
                    beanMethod = "delete",
                    operation = @Operation(
                            summary = "Eliminar tecnología",
                            description = "Elimina una tecnología en base a su ID"
                    )
            )
    })
    public RouterFunction<ServerResponse> technologyRoutes(TechnologyHandler handler) {
        return route(GET("/api/technologies"), handler::getAll)
                .andRoute(GET("/api/technologies/{id}"), handler::getById)
                .andRoute(POST("/api/technologies"), handler::create)
                .andRoute(PUT("/api/technologies/{id}"), handler::update)
                .andRoute(DELETE("/api/technologies/{id}"), handler::delete);
    }
}



