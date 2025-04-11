package com.bite.lotterysystem.dao.handler;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import com.bite.lotterysystem.dao.dataobject.Encrypt;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Shootingmemory
 * @create 2025-03-17-15:24
 */
@MappedTypes(Encrypt.class)   // 被处理的类型
@MappedJdbcTypes(JdbcType.VARCHAR)   // 转换后的 JDBC 类型
public class EncryptTypeHandler extends BaseTypeHandler<Encrypt> {
    // 密钥
    private final byte[] KEY = "123456789abcdefg".getBytes(StandardCharsets.UTF_8);

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Encrypt parameter, JdbcType jdbcType) throws SQLException {
        if (parameter == null || parameter.getValue() == null) {
            ps.setString(i, null);
            return;
        }

        System.out.println("加密的内容：" + parameter.getValue());

        // 加密
        AES aes = SecureUtil.aes(KEY);
        String str = aes.encryptHex(parameter.getValue());
        ps.setString(i, str);
    }


    @Override
    public Encrypt getNullableResult(ResultSet rs, String columnName) throws SQLException {
        System.out.println("获取值得到的加密内容：" + rs.getString(columnName));
        return decrypt(rs.getString(columnName));
    }


    @Override
    public Encrypt getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        System.out.println("获取值得到的加密内容：" + rs.getString(columnIndex));
        return decrypt(rs.getString(columnIndex));
    }


    @Override
    public Encrypt getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        System.out.println("获取值得到的加密内容：" + cs.getString(columnIndex));
        return decrypt(cs.getString(columnIndex));
    }

    private Encrypt decrypt(String str) {
        if (!StringUtils.hasText(str)) {
            return null;
        }
        return new Encrypt(SecureUtil.aes(KEY).decryptStr(str));
    }
}