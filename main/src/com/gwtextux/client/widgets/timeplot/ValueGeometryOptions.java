/*
 Copyright 2008 - Antonio Signore (antonio.signore@gmail.com)

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.

3. The name of the author may not be used to endorse or promote products
   derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package com.gwtextux.client.widgets.timeplot;

import com.google.gwt.core.client.JavaScriptObject;


public class ValueGeometryOptions extends JavaScriptObject
{
    protected ValueGeometryOptions()
    {
        super();
    }

    public static ValueGeometryOptions create()
    {
        return ValueGeometryOptionsImpl.create();
    }

    public final JavaScriptObject getGridColor()
    {
        return JavaScriptObjectHelper.getAttributeAsJavaScriptObject(this, "gridColor");
    }

    public final void setGridColor(Color value)
    {
        JavaScriptObjectHelper.setAttribute(this, "gridColor", value);
    }

    public final String getGridType()
    {
        return JavaScriptObjectHelper.getAttribute(this, "gridType");
    }

    public final void setGridType(String width)
    {
        JavaScriptObjectHelper.setAttribute(this, "gridType", width);
    }

    public final int getAxisLabelsPlacement()
    {
        return JavaScriptObjectHelper.getAttributeAsInt(this, "axisLabelsPlacement");
    }

    public final void setAxisLabelsPlacement(String width)
    {
        JavaScriptObjectHelper.setAttribute(this, "axisLabelsPlacement", width);
    }

    public final int getMin()
    {
        return JavaScriptObjectHelper.getAttributeAsInt(this, "min");
    }

    public final void setMin(int min)
    {
        JavaScriptObjectHelper.setAttribute(this, "min", min);
    }

    public final int getMax()
    {
        return JavaScriptObjectHelper.getAttributeAsInt(this, "max");
    }

    public final void setMax(int min)
    {
        JavaScriptObjectHelper.setAttribute(this, "max", min);
    }
}