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

import java.util.Comparator;
import java.util.Locale;

final class LocaleSorter implements Comparator<Locale>
{
    @Override
    public int compare(Locale o1, Locale o2)
    {
        String v1 = o1.getVariant();
        String v2 = o2.getVariant();
        if (v1.isEmpty())
        {
            return (v2.isEmpty()) ? compareCountry(o1, o2) :  -1;
        }
        else if (v2.isEmpty())
        {
            return 1;
        }
        else
        {
            return compareCountry(o1, o2);
        }
    }
    
    private static int compareCountry(Locale o1, Locale o2)
    {
        String c1 = o1.getCountry();
        String c2 = o2.getCountry();
        if (c1.isEmpty())
        {
            return (c2.isEmpty()) ? 0 :  -1;
        }
        else if (c2.isEmpty())
        {
            return 1;
        }
        else
        {
            int rc = o1.getLanguage().compareTo(o2.getLanguage());
            if (rc ==  0)
            {
                rc =  c1.compareTo(c2);
                if (rc == 0)
                {
                    rc = o1.getVariant().compareTo(o2.getVariant());
                }
            }
            return rc;
        }
    }
}
