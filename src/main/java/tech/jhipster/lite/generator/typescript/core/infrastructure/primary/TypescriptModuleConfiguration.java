package tech.jhipster.lite.generator.typescript.core.infrastructure.primary;

import static tech.jhipster.lite.shared.slug.domain.JHLiteModuleSlug.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.typescript.core.application.TypescriptApplicationService;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleOrganization;
import tech.jhipster.lite.module.domain.resource.JHipsterModuleResource;

@Configuration
class TypescriptModuleConfiguration {

  @Bean
  JHipsterModuleResource typescriptModule(TypescriptApplicationService typescript) {
    return JHipsterModuleResource.builder()
      .slug(TYPESCRIPT)
      .withoutProperties()
      .apiDoc("Typescript", "Init Typescript project")
      .organization(JHipsterModuleOrganization.builder().addDependency(INIT).addDependency(PRETTIER).build())
      .tags("typescript")
      .factory(typescript::buildModule);
  }
}
