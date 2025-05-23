package tech.jhipster.lite.generator.server.javatool.javaenum.infrastructure.primary;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.server.javatool.javaenum.application.JavaEnumsApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModulePropertiesDefinition;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;
import tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug;

@Configuration
class JavaEnumsModuleConfiguration {

  @Bean
  JHipsterModuleResource javaEnumsModule(JavaEnumsApplicationService javaEnums) {
    return JHipsterModuleResource.builder()
      .slug(JHLiteModuleSlug.JAVA_ENUMS)
      .propertiesDefinition(JHipsterModulePropertiesDefinition.builder().addBasePackage().build())
      .apiDoc("Java", "Add simple enums mapper")
      .organization(JHipsterModuleOrganization.builder().addDependency(JHLiteModuleSlug.JAVA_BASE).build())
      .tags("server")
      .factory(javaEnums::buildModule);
  }
}
