package com.seguro.residencial.infra.config.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.stereotype.Component;

/**
 * @criado 18/12/2020 - 19:28
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
@Component
public class FlywayMigrationStrategyImpl implements FlywayMigrationStrategy {

    @Override
    public void migrate(Flyway flyway) {
        flyway.migrate();
    }
}
