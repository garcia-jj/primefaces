/*
 * Copyright 2009-2016 PrimeTek.
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
package org.primefaces.renderkit;

import javax.faces.render.RenderKit;
import javax.faces.render.RenderKitWrapper;
import javax.faces.render.Renderer;

public class PrimeRenderKitWrapper extends RenderKitWrapper {

    private final RenderKit wrapped;
    
    public PrimeRenderKitWrapper(RenderKit wrapped) {
        this.wrapped = wrapped;
    }
    
    @Override
    public Renderer getRenderer(String family, String rendererType) {
        Renderer renderer = getWrapped().getRenderer(family, rendererType);
        if (renderer != null && !(renderer instanceof PrimeRendererWrapper)) {
            renderer = new PrimeRendererWrapper(renderer);
            addRenderer(family, rendererType, renderer);
        }
        
        return renderer;
    }
    
    @Override
    public RenderKit getWrapped() {
        return wrapped;
    }
    
}