/*
 * Copyright 2004-2010 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.doma.internal.apt.domain;

import java.math.BigDecimal;

import org.seasar.doma.Domain;

/**
 * @author taedium
 * 
 */
@Domain(valueType = BigDecimal.class, factoryMethod = "of")
public class IllegalSizeParametarizedOfSalary<T, U> {

    private final BigDecimal value;

    private IllegalSizeParametarizedOfSalary(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public static <T, U, V> IllegalSizeParametarizedOfSalary<T, U> of(
            BigDecimal value) {
        return new IllegalSizeParametarizedOfSalary<T, U>(value);
    }
}
