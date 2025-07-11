
CREATE SEQUENCE IF NOT EXISTS KKF.SEQ_ADDRESSES START WITH 1050 INCREMENT BY 50;

CREATE TABLE KKF.ADDRESSES
(
    ID                    BIGINT NOT NULL,
    STREET                CHARACTER VARYING(128),
    POSTCODE              CHARACTER VARYING(128),
    CITY                  CHARACTER VARYING(128),
    COUNTRY               CHARACTER VARYING(128),

    ROW_OBJECT_VERSION    BIGINT,
    ROW_CREATION_DATE     TIMESTAMP(3),
    ROW_CREATION_USER     CHARACTER VARYING(128),
    ROW_MODIFICATION_DATE TIMESTAMP(3),
    ROW_MODIFICATION_USER CHARACTER VARYING(128),

    CONSTRAINT PK_ADDRESS PRIMARY KEY (ID)
);

COMMENT ON TABLE KKF.ADDRESSES IS 'Adresy';

COMMENT ON COLUMN KKF.ADDRESSES.ID IS 'Klucz główny';
COMMENT ON COLUMN KKF.ADDRESSES.STREET IS 'Ulica';
COMMENT ON COLUMN KKF.ADDRESSES.POSTCODE IS 'Kod pocztowy';
COMMENT ON COLUMN KKF.ADDRESSES.CITY IS 'Miasto';
COMMENT ON COLUMN KKF.ADDRESSES.COUNTRY IS 'Kraj';
COMMENT ON COLUMN KKF.ADDRESSES.ROW_OBJECT_VERSION IS 'Pole wskazujące na wersje rekordu i do blokowania zmian';
COMMENT ON COLUMN KKF.ADDRESSES.ROW_CREATION_DATE IS 'Data z czasem utworzenia rekordu';
COMMENT ON COLUMN KKF.ADDRESSES.ROW_CREATION_USER IS 'Użytkownik, który utworzył rekord';
COMMENT ON COLUMN KKF.ADDRESSES.ROW_MODIFICATION_DATE IS 'Data z czasem modyfikacji rekordu';
COMMENT ON COLUMN KKF.ADDRESSES.ROW_MODIFICATION_USER IS 'Uzytkownik, który zmodyfikował rekord';

CREATE INDEX IDX_ADDRESSES_STREET ON KKF.ADDRESSES (STREET);
CREATE INDEX IDX_ADDRESSES_POSTCODE ON KKF.ADDRESSES (POSTCODE);
CREATE INDEX IDX_ADDRESSES_CITY ON KKF.ADDRESSES (CITY);
CREATE INDEX IDX_ADDRESSES_COUNTRY ON KKF.ADDRESSES (COUNTRY);