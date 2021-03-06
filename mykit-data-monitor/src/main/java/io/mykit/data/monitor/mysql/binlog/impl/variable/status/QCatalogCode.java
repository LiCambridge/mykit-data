package io.mykit.data.monitor.mysql.binlog.impl.variable.status;


import io.mykit.data.monitor.mysql.common.glossary.column.StringColumn;
import io.mykit.data.monitor.mysql.common.util.MySQLConstants;
import io.mykit.data.monitor.mysql.common.util.ToStringBuilder;
import io.mykit.data.monitor.mysql.io.XInputStream;

import java.io.IOException;

public class QCatalogCode extends AbstractStatusVariable {
    public static final int TYPE = MySQLConstants.Q_CATALOG_CODE;

    private final StringColumn catalogName;

    public QCatalogCode(StringColumn catalogName) {
        super(TYPE);
        this.catalogName = catalogName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("catalogName", catalogName).toString();
    }

    public StringColumn getCatalogName() {
        return catalogName;
    }

    public static QCatalogCode valueOf(XInputStream tis) throws IOException {
        tis.readInt(1); // Length
        return new QCatalogCode(tis.readNullTerminatedString());
    }
}
