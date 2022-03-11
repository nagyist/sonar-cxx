/*
 * C++ Community Plugin (cxx plugin)
 * Copyright (C) 2022 SonarOpenCommunity
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
 * fork of SonarSource Language Recognizer: https://github.com/SonarSource/sslr
 * Copyright (C) 2010-2021 SonarSource SA / mailto:info AT sonarsource DOT com / license: LGPL v3
 */
package org.sonar.cxx.sslr.parser;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sonar.cxx.sslr.internal.matchers.ImmutableInputBuffer;
import org.sonar.cxx.sslr.internal.matchers.InputBuffer;

public class ParseErrorFormatterTest {

  private ParseErrorFormatter formatter;

  @BeforeEach
  public void setUp() {
    formatter = new ParseErrorFormatter();
  }

  @Test
  public void test() {
    InputBuffer inputBuffer = new ImmutableInputBuffer("\t2+4*10-0*\n".toCharArray());
    var result = formatter.format(new ParseError(inputBuffer, 10));
    System.out.print(result);
    var expected = new StringBuilder()
      .append("Parse error at line 1 column 11:\n")
      .append('\n')
      .append("1:  2+4*10-0*\n")
      .append("             ^\n")
      .append("2: \n")
      .toString();

    assertThat(result).isEqualTo(expected);
  }

}
