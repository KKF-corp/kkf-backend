package pl.corp.kkf.kkf.services.impl;

import pl.corp.kkf.commons.base.service.db.DataSourceConstants;

public class KKFModuleConstants {
    public static final String PROPERTIES_PREFIX = "kkf.kkf-module"; // do application.properties
    public static final String DATA_SOURCE_BEAN_NAME = DataSourceConstants.DATA_SOURCE_BEAN_NAME_PREFIX + "KKF";
    public static final String ENTITY_MANAGER_FACTORY_BEAN_NAME = "entityManageFactoryKKF";
    public static final String REPOSITORY_PACKAGES = "pl.corp.kkf.kkf.services.impl.dao.repositories";
    public static final String PERSISTENCE_UNIT_NAME = "KFFPU";
    public static final String TRANSACTION_MANAGER = "transactionManagerKKF";

    public KKFModuleConstants() {
    }
}
