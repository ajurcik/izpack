/*
 * IzPack - Copyright 2012 Julien Ponge, All Rights Reserved.
 *
 * http://izpack.org/
 * http://izpack.codehaus.org/
 *
 * Copyright 2017 Patrick Reinhart
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.izforge.izpack.core.resource;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.junit.Test;

/**
 * Tests the {@link LocaleSorter} class.
 *
 * @author Patrick Reinhart
 */
public class LocaleSorterTest
{
    @Test
    public void testCompare_simple()
    {
        Locale l1 = new Locale("de", "CH", "obwalden");
        Locale l2 = new Locale("de", "CH", "nidwalden");
        Locale l3 = new Locale("fr", "CH");
        Locale l4 = new Locale("de", "CH");

        List<Locale> tested = new ArrayList<Locale>();
        tested.add(l1);
        tested.add(l2);
        tested.add(l3);
        tested.add(l4);
        tested.add(Locale.GERMANY);
        tested.add(Locale.GERMAN);
        tested.add(Locale.FRENCH);
        tested.add(Locale.FRANCE);

        Collections.sort(tested, new LocaleSorter());
        
        System.out.println(tested);

        assertEquals(Locale.GERMAN, tested.get(0));
        assertEquals(Locale.FRENCH, tested.get(1));

        assertEquals(l4, tested.get(2));
        assertEquals(Locale.GERMANY, tested.get(3));
        assertEquals(l3, tested.get(4));
        assertEquals(Locale.FRANCE, tested.get(5));

        assertEquals(l2, tested.get(6));
        assertEquals(l1, tested.get(7));
    }

    @Test
    public void testCompare_full()
    {
        Locale[] tested = Locale.getAvailableLocales();
        Arrays.sort(tested, new LocaleSorter());
        System.out.println(Arrays.toString(tested));
    }
}
