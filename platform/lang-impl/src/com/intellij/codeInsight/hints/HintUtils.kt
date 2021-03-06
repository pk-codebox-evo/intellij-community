/*
 * Copyright 2000-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.codeInsight.hints

import com.intellij.codeInsight.hints.filtering.MatcherConstructor
import com.intellij.lang.Language
import com.intellij.openapi.util.text.StringUtil


fun getHintProviders(): List<Pair<Language, InlayParameterHintsProvider>> {
  return Language.getRegisteredLanguages()
    .filter { it.baseLanguage == null }
    .map { it to InlayParameterHintsExtension.forLanguage(it) }
    .filter { it.second != null }
}


fun getBlackListInvalidLineNumbers(text: String): List<Int> {
  val rules = StringUtil.split(text, "\n", true, false)
  return rules
    .mapIndexedNotNull { index, s -> index to s }
    .filter { it.second.isNotEmpty() }
    .map { it.first to MatcherConstructor.createMatcher(it.second) }
    .filter { it.second == null }
    .map { it.first }
}