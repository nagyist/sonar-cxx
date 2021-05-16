/*
 * C++ Community Plugin (cxx plugin)
 * Copyright (C) 2021 SonarOpenCommunity
 * http://github.com/SonarOpenCommunity/sonar-cxx
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
/**
 * fork of SSLR Squid Bridge: https://github.com/SonarSource/sslr-squid-bridge/tree/2.6.1
 * Copyright (C) 2010 SonarSource / mailto: sonarqube@googlegroups.com / license: LGPL v3
 */
package org.sonar.cxx.squidbridge.measures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class MeasuresTest {

  private final Measures measures = new Measures();

  @Test
  public void testGetValue() {
    assertEquals(0, measures.getValue(Metric.ACCESSORS), 0.1);
  }

  @Test
  public void testGetData() {
    assertNull(measures.getData(Metric.LCOM4_BLOCKS));
  }

  @Test
  public void testSetValue() {
    measures.setValue(Metric.ACCESSORS, 3);
    assertEquals(3, measures.getValue(Metric.ACCESSORS), 0.1);
  }

  @Test
  public void testSetData() {
    measures.setData(Metric.LCOM4_BLOCKS, "blocks detail");
    assertEquals("blocks detail", measures.getData(Metric.LCOM4_BLOCKS));
  }

}