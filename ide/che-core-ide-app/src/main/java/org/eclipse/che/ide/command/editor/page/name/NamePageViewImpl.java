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
package org.eclipse.che.ide.command.editor.page.name;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import org.eclipse.che.ide.command.CommandResources;
import org.vectomatic.dom.svg.ui.SVGImage;

/**
 * Implementation of {@link NamePageView}.
 *
 * @author Artem Zatsarynnyi
 */
public class NamePageViewImpl extends Composite implements NamePageView {

    private static final NamePageViewImplUiBinder UI_BINDER = GWT.create(NamePageViewImplUiBinder.class);

    @UiField
    TextBox commandName;

    @UiField
    Button testButton;

    private ActionDelegate delegate;

    @Inject
    public NamePageViewImpl(CommandResources resources) {
        initWidget(UI_BINDER.createAndBindUi(this));

        testButton.getElement().appendChild(new SVGImage(resources.execute()).getElement());
    }

    @Override
    public void setCommandName(String name) {
        commandName.setValue(name);
    }

    @Override
    public void setDelegate(ActionDelegate delegate) {
        this.delegate = delegate;
    }

    @UiHandler({"commandName"})
    void onNameChanged(KeyUpEvent event) {
        delegate.onNameChanged(commandName.getValue());
    }

    @UiHandler("testButton")
    public void handleTestButton(ClickEvent clickEvent) {
        delegate.onCommandTest();
    }

    interface NamePageViewImplUiBinder extends UiBinder<Widget, NamePageViewImpl> {
    }
}
