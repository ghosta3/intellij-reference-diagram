/*
 * Copyright (C) 2015 Stefan Zeller
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ch.docksnet.rgraph.actions;

import ch.docksnet.rgraph.ReferenceNode;
import com.intellij.diagram.DiagramAction;
import com.intellij.diagram.DiagramNode;
import com.intellij.openapi.actionSystem.AnActionEvent;

/**
 * @author Stefan Zeller
 */
public class UnmarkAction extends DiagramAction {

    @Override
    public void perform(AnActionEvent e) {
        for (DiagramNode diagramNode : getSelectedNodes(e)) {
            if (diagramNode instanceof ReferenceNode) {
                ((ReferenceNode) diagramNode).unsetMarked();
            }
        }
        getBuilder(e).getPresentationModel().update();
    }

    @Override
    public String getActionName() {
        return "Unmark Selected";
    }

    @Override
    public void update(AnActionEvent e) {
        e.getPresentation().setVisible(true);
        ActionHelper.enableIfNodesSelected(e);
        e.getPresentation().setText(getActionName());
        super.update(e);
    }

}
