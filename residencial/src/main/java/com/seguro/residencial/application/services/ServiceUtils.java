package com.seguro.residencial.application.services;

import java.util.UUID;

/**
 * @criado 16/10/2020 - 00:00
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */
public class ServiceUtils {

    public static UUID formatUuid(String accountId) {
        accountId = accountId.replace("-", "");
        String formatted = String.format(
                accountId.substring(0, 8) + "-" +
                        accountId.substring(8, 12) + "-" +
                        accountId.substring(12, 16) + "-" +
                        accountId.substring(16, 20) + "-" +
                        accountId.substring(20, 32)
        );
        return UUID.fromString(formatted);
    }

}
