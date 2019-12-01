package epam.data.movies;

import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.SerializationException;
import org.hibernate.usertype.UserType;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringListType implements UserType {

    private final int[] arrayTypes = new int[]{Types.ARRAY};

    @Override
    public int[] sqlTypes() {
        return arrayTypes;
    }

    @Override
    public Class<?> returnedClass() {
        return List.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return ObjectUtils.nullSafeEquals(x, y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        if (x == null) {
            return 0;
        }
        return x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SharedSessionContractImplementor sharedSessionContractImplementor, Object obj) throws HibernateException, SQLException {
        Array array = resultSet.getArray(strings[0]);
        String[] javaArray = (String[]) array.getArray();
        return ArrayUtils.toPrimitive(javaArray);
    }

    @Override
    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException, SQLException {
        if (o == null) {
            preparedStatement.setNull(i, Types.VARCHAR);
        } else {
            preparedStatement.setString(i, serialize((List<String>) o));
        }
    }

    @Override
    public Object deepCopy(Object originalValue) throws HibernateException {
        if (originalValue == null) {
            return null;
        }
        if (!(originalValue instanceof List)) {
            return null;
        }
        List<?> tempList = (List<?>) originalValue;

        return new ArrayList(tempList);
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        Object copy = deepCopy(o);

        if (copy instanceof Serializable) {
            return (Serializable) copy;
        }

        throw new SerializationException(
                String.format("Cannot serialize '%s', %s is not Serializable.", o, o.getClass()), null);
    }

    @Override
    public Object assemble(Serializable serializable, Object o) throws HibernateException {
        return deepCopy(serializable);
    }

    @Override
    public Object replace(Object o, Object o1, Object o2) throws HibernateException {
        return deepCopy(o);
    }

    private String serialize(List<String> list) {
        StringBuilder strbul = new StringBuilder();
        Iterator<String> iter = list.iterator();
        strbul.append("{");
        while (iter.hasNext()) {
            strbul.append(iter.next());
            if (iter.hasNext()) {
                strbul.append(",");
            }
        }
        strbul.append("}");
        return strbul.toString();
    }
}
