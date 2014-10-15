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
package io.wcm.handler.url.integrator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IntegratorPlaceholderTest {

  @Test
  public void testGetTagWithComments() {
    assertEquals("\n" +
        "<!-- APP_INCLUDE_CONTENT START -->\n" +
        "###APP_INCLUDE_CONTENT###\n" +
        "<!-- APP_INCLUDE_CONTENT END -->\n",
        IntegratorPlaceholder.getTagWithComments(IntegratorPlaceholder.APP_INCLUDE_CONTENT));
  }

}
