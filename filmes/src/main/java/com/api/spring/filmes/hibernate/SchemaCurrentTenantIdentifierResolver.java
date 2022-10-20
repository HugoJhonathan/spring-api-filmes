package com.api.spring.filmes.hibernate;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
public class SchemaCurrentTenantIdentifierResolver implements CurrentTenantIdentifierResolver {
    @Override
    public String resolveCurrentTenantIdentifier() {
        return Tenant.getIdentificador();
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return false;
    }
}
