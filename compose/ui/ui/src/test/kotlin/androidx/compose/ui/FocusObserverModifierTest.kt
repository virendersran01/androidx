/*
 * Copyright 2020 The Android Open Source Project
 *
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
 */

package androidx.compose.ui

import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.platform.InspectableValue
import androidx.compose.ui.platform.ValueElement
import androidx.compose.ui.platform.isDebugInspectorInfoEnabled
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class FocusObserverModifierTest {
    @Before
    fun before() {
        isDebugInspectorInfoEnabled = true
    }

    @After
    fun after() {
        isDebugInspectorInfoEnabled = false
    }

    @Test
    fun testInspectorValue() {
        val onFocusChange: (FocusState) -> Unit = {}
        val modifier = Modifier.focusObserver(onFocusChange) as InspectableValue
        assertThat(modifier.nameFallback).isEqualTo("focusObserver")
        assertThat(modifier.valueOverride).isNull()
        assertThat(modifier.inspectableElements.asIterable()).containsExactly(
            ValueElement("onFocusChange", onFocusChange)
        )
    }
}