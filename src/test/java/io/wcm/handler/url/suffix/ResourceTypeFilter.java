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
package io.wcm.handler.url.suffix;

import org.apache.sling.api.resource.Resource;

import com.day.cq.commons.Filter;

/**
 * Filters resources by resource type (appends /apps/ prefix if needed).
 */
class ResourceTypeFilter implements Filter<Resource> {

  private final String resourceType;

  /**
   * @param resourceType The resource type to be included
   */
  public ResourceTypeFilter(String resourceType) {
    this.resourceType = resourceType;
  }

  @Override
  public boolean includes(Resource resource) {
    return resource.isResourceType(resourceType);
  }

}
