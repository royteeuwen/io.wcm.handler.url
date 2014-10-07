/*
 * #%L
 * wcm.io
 * %%
 * Copyright (C) 2014 wcm.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package io.wcm.handler.url.testcontext;

import io.wcm.config.spi.annotations.Application;
import io.wcm.handler.url.UrlHandlerConfig;
import io.wcm.handler.url.UrlMode;
import io.wcm.handler.url.UrlModes;
import io.wcm.handler.url.impl.ApplicationProviderImpl;
import io.wcm.handler.url.integrator.IntegratorMode;
import io.wcm.handler.url.integrator.IntegratorModes;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import com.day.cq.wcm.api.NameConstants;
import com.day.cq.wcm.api.Page;
import com.google.common.collect.ImmutableList;

/**
 * Dummy link configuration
 */
@Model(adaptables = {
    SlingHttpServletRequest.class, Resource.class
}, adapters = UrlHandlerConfig.class)
@Application(ApplicationProviderImpl.APPLICATION_ID)
public class DummyUrlHandlerConfig implements UrlHandlerConfig {

  public static final int SITE_ROOT_LEVEL = 4;

  private static final List<IntegratorMode> INTEGRATOR_MODES = ImmutableList.<IntegratorMode>of(
      IntegratorModes.SIMPLE,
      IntegratorModes.EXTENDED
      );

  @Override
  public UrlMode getDefaultUrlMode() {
    return UrlModes.DEFAULT;
  }

  @Override
  public List<IntegratorMode> getIntegratorModes() {
    return INTEGRATOR_MODES;
  }

  @Override
  public boolean isSecure(Page page) {
    String templatePath = page.getProperties().get(NameConstants.PN_TEMPLATE, String.class);
    return StringUtils.equals(templatePath, DummyAppTemplate.CONTENT_SECURE.getTemplatePath());
  }

  @Override
  public boolean isIntegrator(Page page) {
    String templatePath = page.getProperties().get(NameConstants.PN_TEMPLATE, String.class);
    return StringUtils.equals(templatePath, DummyAppTemplate.INTEGRATOR.getTemplatePath());
  }

  @Override
  public int getSiteRootLevel(String contextPath) {
    return SITE_ROOT_LEVEL;
  }

}
