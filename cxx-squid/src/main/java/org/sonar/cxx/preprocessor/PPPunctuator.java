/*
 * C++ Community Plugin (cxx plugin)
 * Copyright (C) 2010-2024 SonarOpenCommunity
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
package org.sonar.cxx.preprocessor;

import com.sonar.cxx.sslr.api.AstNode;
import com.sonar.cxx.sslr.api.TokenType;
import javax.annotation.Nullable;

/**
 * C++ Standard, 2.13 Operators and punctuators
 */
public enum PPPunctuator implements TokenType {

  // Basic arithmetic operators
  PLUS("+"),
  MINUS("-"),
  MUL("*"),
  DIV("/"),
  MODULO("%"),
  INCR("++"),
  DECR("--"),
  ASSIGN("="),
  // Comparison/relational operators
  EQ("=="),
  NOT_EQ("!="),
  LT("<"),
  GT(">"),
  LT_EQ("<="),
  GT_EQ(">="),
  SPACESHIP("<=>"),
  // Logical operators
  NOT("!"),
  AND("&&"),
  OR("||"),
  // Bitwise Operators
  BW_NOT("~"),
  BW_AND("&"),
  BW_OR("|"),
  BW_XOR("^"),
  BW_LSHIFT("<<"),
  BW_RSHIFT(">>"),
  // Compound assignment operators
  PLUS_ASSIGN("+="),
  MINUS_ASSIGN("-="),
  MUL_ASSIGN("*="),
  DIV_ASSIGN("/="),
  MODULO_ASSIGN("%="),
  BW_AND_ASSIGN("&="),
  BW_OR_ASSIGN("|="),
  BW_XOR_ASSIGN("^="),
  BW_LSHIFT_ASSIGN("<<="),
  BW_RSHIFT_ASSIGN(">>="),
  // Member and pointer operators
  ARROW("->"),
  DOT("."),
  DOT_STAR(".*"),
  ARROW_STAR("->*"),
  // Delimiters
  SEMICOLON(";"),
  COLON(":"),
  COMMA(","),
  DOUBLECOLON("::"),
  BR_LEFT("("),
  BR_RIGHT(")"),
  CURLBR_LEFT("{"),
  CURLBR_RIGHT("}"),
  SQBR_LEFT("["),
  SQBR_RIGHT("]"),
  // Other operators
  QUEST("?"),
  ELLIPSIS("..."),
  HASH("#"),
  HASHHASH("##"),
  // Trigraphs etc.
  LT_COLON("<:"),
  GT_COLON(":>"),
  LT_MOD("<%"),
  GT_MOD("%>"),
  MOD_COLON("%:"),
  MOD_COLON_MOD_COLON("%:%:"),
  NEW("new"),
  DELETE("delete"),
  // Aliases
  AL_AND("and"),
  AL_AND_EQ("and_eq"),
  AL_BITAND("bitand"),
  AL_BITOR("bitor"),
  AL_COMPL("compl"),
  AL_NOT("not"),
  AL_NOT_EQ("not_eq"),
  AL_OR("or"),
  AL_OR_EQ("or_eq"),
  AL_AL_XOR("xor"),
  AL_XOR_EQ("xor_eq");

  private final String value;

  PPPunctuator(String word) {
    this.value = word;
  }

  @Override
  public String getName() {
    return name();
  }

  @Override
  public String getValue() {
    return value;
  }

  @Override
  public boolean hasToBeSkippedFromAst(@Nullable AstNode node) {
    return false;
  }
}
