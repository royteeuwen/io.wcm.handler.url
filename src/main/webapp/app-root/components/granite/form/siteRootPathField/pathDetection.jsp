<%--
  #%L
  wcm.io
  %%
  Copyright (C) 2019 wcm.io
  %%
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
  #L%
  --%>
<%@page import="io.wcm.handler.url.spi.UrlHandlerConfig"%>
<%@page import="io.wcm.wcm.commons.util.Path"%>
<%@page import="io.wcm.wcm.ui.granite.util.GraniteUi"%>
<%@page import="org.apache.sling.api.resource.Resource"%>
<%@page import="org.apache.sling.api.SlingHttpServletRequest"%><%!

static String getRootPath(SlingHttpServletRequest request, String fallbackRootPath) {
  String rootPath = fallbackRootPath;

  Resource contentResource = GraniteUi.getContentResourceOrParent(request);
  if (contentResource != null) {
    // inside an experience fragment it does not make sense to use a site root path
    if (!Path.isExperienceFragmentPath(contentResource.getPath())) {
      UrlHandlerConfig urlHandlerConfig = contentResource.adaptTo(UrlHandlerConfig.class);
      if (urlHandlerConfig != null) {
        int siteRootLevel = urlHandlerConfig.getSiteRootLevel(contentResource);
        if (siteRootLevel >= 0) {
          rootPath = Path.getAbsoluteParent(contentResource.getPath(), siteRootLevel, request.getResourceResolver());
        }
      }
    }
  }

  if (rootPath == null) {
    rootPath = fallbackRootPath;
  }

  return rootPath;
}

%>
