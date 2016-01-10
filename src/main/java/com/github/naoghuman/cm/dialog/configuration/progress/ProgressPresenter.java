/*
 * Copyright (C) 2016 PRo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.naoghuman.cm.dialog.configuration.progress;

import de.pro.lib.logger.api.LoggerFacade;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Dialog;
import javafx.util.Duration;

/**
 *
 * @author PRo
 */
public class ProgressPresenter implements Initializable {
    
//    @FXML private ListView lvOverview;

    private ResourceBundle resources = null;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoggerFacade.INSTANCE.info(this.getClass(), "Initialize ProgressPresenter"); // NOI18N
        
        this.resources = resources;
        
//        assert (lvOverview != null) : "fx:id=\"lvOverview\" was not injected: check your FXML file 'Progress.fxml'."; // NOI18N
        
    }
    
    public void initialize(final Dialog dialog) {
        LoggerFacade.INSTANCE.info(this.getClass(), "Initialize ProgressPresenter with Dialog"); // NOI18N
        
        // XXX test to hide the progress dialog automatically
        final PauseTransition pt = new PauseTransition(Duration.millis(2500.0d));
        pt.setOnFinished((ActionEvent event) -> {
            dialog.hide();
        });
        pt.playFromStart();
    }
    
}
