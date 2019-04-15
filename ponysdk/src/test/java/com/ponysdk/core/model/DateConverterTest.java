/*
 * Copyright (c) 2018 PonySDK
 *  Owners:
 *  Luciano Broussal  <luciano.broussal AT gmail.com>
 *	Mathieu Barbier   <mathieu.barbier AT gmail.com>
 *	Nicolas Ciaravola <nicolas.ciaravola.pro AT gmail.com>
 *
 *  WebSite:
 *  http://code.google.com/p/pony-sdk/
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ponysdk.core.model;

import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DateConverterTest {

    /**
     * Test method for {@link com.ponysdk.core.model.DateConverter#encode(java.util.Collection)}.
     */
    @Test
    public void testEncodeDates() {
        final int firstTimestamp = 0;
        final int lastTimestamp = 1000;
        final List<Date> dates = List.of(new Date(firstTimestamp), new Date(lastTimestamp));
        final Long[] timestamp = DateConverter.encode(dates);
        assertEquals(dates.size(), timestamp.length);
        assertEquals(firstTimestamp, (long) timestamp[0]);
        assertEquals(lastTimestamp, (long) timestamp[1]);

        assertNull(DateConverter.encode((List<Date>) null));
        assertNull(DateConverter.encode(List.of()));
    }

    /**
     * Test method for {@link com.ponysdk.core.model.DateConverter#encode(java.util.Date)}.
     */
    @Test
    public void testEncodeDate() {
        final int expectedTimestamp = 123;
        final long timestamp = DateConverter.encode(new Date(expectedTimestamp));
        assertEquals(expectedTimestamp, timestamp);

        assertNull(DateConverter.encode((Date) null));
    }

    /**
     * Test method for {@link com.ponysdk.core.model.DateConverter#decode(long)}.
     */
    @Test
    public void testDecode() {
        final int expectedTimestamp = 0;
        final Date date = DateConverter.decode(expectedTimestamp);
        assertEquals(new Date(0), date);
    }

    /**
     * Test method for {@link com.ponysdk.core.model.DateConverter#toTimestamp(java.util.Date)}.
     */
    @Test
    public void testToTimestamp() {
        final int expectedTimestamp = 123;
        final long timestamp = DateConverter.toTimestamp(new Date(expectedTimestamp));
        assertEquals(expectedTimestamp, timestamp);

        assertEquals(-1, DateConverter.toTimestamp(null));
    }

    /**
     * Test method for {@link com.ponysdk.core.model.DateConverter#fromTimestamp(long)}.
     */
    @Test
    public void testFromTimestamp() {
        final int expectedTimestamp = 123;
        final Date date = DateConverter.fromTimestamp(expectedTimestamp);
        assertEquals(new Date(expectedTimestamp), date);

        assertNull(DateConverter.fromTimestamp(-1));
    }

}
