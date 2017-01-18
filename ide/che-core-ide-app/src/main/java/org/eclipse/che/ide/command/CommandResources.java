/*******************************************************************************
 * Copyright (c) 2012-2017 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.ide.command;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.DataResource;

import org.vectomatic.dom.svg.ui.SVGResource;

/**
 * Client bundle for command related resources.
 *
 * @author Artem Zatsarynnyi
 */
public interface CommandResources extends ClientBundle {

    /** Resource is used as CSS constant's value for setting 'background-image' property. */
    @DataResource.MimeType("image/svg+xml")
    @Source("magnifier.svg")
    DataResource magnifier();

    @Source("explorer/explorer-part.svg")
    SVGResource explorerPart();

    @Source("explorer/add-command-button.svg")
    SVGResource addCommand();

    @Source("explorer/duplicate-command-button.svg")
    SVGResource duplicateCommand();

    @Source("explorer/remove-command-button.svg")
    SVGResource removeCommand();

    @Source("editor/execute.svg")
    SVGResource execute();

    @Source({"explorer/styles.css", "org/eclipse/che/ide/api/ui/style.css"})
    ExplorerCSS commandsExplorerCss();

    @Source({"palette/styles.css", "org/eclipse/che/ide/api/ui/style.css"})
    PaletteCSS commandsPaletteCss();

    interface ExplorerCSS extends CssResource {
        String commandGoalNode();

        String commandNode();

        String commandNodeText();

        String commandNodeButtonsPanel();
    }

    interface PaletteCSS extends CssResource {
        String filterField();
    }
}
