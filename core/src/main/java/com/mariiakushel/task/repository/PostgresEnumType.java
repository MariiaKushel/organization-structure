package com.mariiakushel.task.repository;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.EnumType;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Class PosgreSQL Enumeration type adapter. Use for correct interpretation PosgreSQL Enumeration type by Spring Data.
 */
public class PostgresEnumType extends EnumType {
    public void nullSafeSet(
            PreparedStatement st,
            Object value,
            int index,
            SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
        st.setObject(
                index,
                value != null ?
                        ((Enum) value).name() :
                        null,
                Types.OTHER
        );
    }
}
