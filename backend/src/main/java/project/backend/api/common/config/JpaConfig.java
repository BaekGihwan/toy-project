package project.backend.api.common.config;

import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfig {

    @Bean
    public PhysicalNamingStrategy physicalNamingStrategy() {
        return new CustomPhysicalNamingStrategy();
    }

    private static class CustomPhysicalNamingStrategy extends CamelCaseToUnderscoresNamingStrategy {
        @Override
        public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
            // 먼저 CamelCase를 snake_case로 변환
            Identifier transformedName = super.toPhysicalTableName(name, context);
            String tableName = transformedName.getText();
            
            // _jpo suffix 제거
            if (tableName.endsWith("_jpo")) {
                tableName = "t_" + tableName.substring(0, tableName.length() - 4);
            }
            
            return Identifier.toIdentifier(tableName, transformedName.isQuoted());
        }
    }
} 