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
package org.seasar.doma.internal.jdbc.command;

import static org.seasar.doma.internal.util.AssertionUtil.assertNotNull;

import java.util.Map;
import java.util.stream.Collector;

import org.seasar.doma.MapKeyNamingType;
import org.seasar.doma.jdbc.query.SelectQuery;

/**
 * 
 * @author nakamura-to
 * 
 * @param <RESULT>
 */
public class MapCollectorHandler<RESULT> extends
        AbstractCollectorHandler<Map<String, Object>, RESULT> {

    private final MapKeyNamingType keyNamingType;

    public MapCollectorHandler(MapKeyNamingType keyNamingType,
            Collector<Map<String, Object>, ?, RESULT> collector) {
        super(collector);
        assertNotNull(keyNamingType);
        this.keyNamingType = keyNamingType;
    }

    @Override
    protected MapProvider createObjectProvider(SelectQuery query) {
        return new MapProvider(query, keyNamingType);
    }

}