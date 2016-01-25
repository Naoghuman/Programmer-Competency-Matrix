/*
 * Copyright (C) 2015 PRo
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
package com.github.naoghuman.cm.dialog.api;

import com.github.naoghuman.cm.dialog.configuration.ConfigurationView;
import com.github.naoghuman.cm.dialog.configuration.progress.ProgressPresenter;
import com.github.naoghuman.cm.dialog.configuration.progress.ProgressView;
import com.github.naoghuman.cm.dialog.matrix.MatrixPresenter;
import com.github.naoghuman.cm.dialog.matrix.MatrixView;
import com.github.naoghuman.cm.dialog.matrix.category.subcategory.level.LevelPresenter;
import com.github.naoghuman.cm.dialog.matrix.category.subcategory.level.LevelView;
import com.github.naoghuman.cm.model.api.LevelModel;
import com.github.naoghuman.cm.model.api.MatrixModel;
import de.pro.lib.logger.api.LoggerFacade;
import javafx.event.Event;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 * TODO use custom dialog / valid input
 * http://code.makery.ch/blog/javafx-dialogs-official/
 * https://github.com/Daytron/SimpleDialogFX
 * or own dialogs like in DreamBetterWorlds
 *
 * @author PRo
 */
public interface DialogProvider {
    
    public static Alert getDeleteCategoryDialog() {
        LoggerFacade.INSTANCE.debug(DialogProvider.class, "Get delete Category dialog"); // NOI18N
        
        final Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle("Delete Category"); // NOI18N
        alert.setHeaderText("Really delete this Category?"); // NOI18N
        
        final ButtonType buttonTypeOne = new ButtonType(ButtonType.YES.getText(), ButtonData.YES);
        final ButtonType buttonTypeCancel = new ButtonType(ButtonType.CANCEL.getText(), ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
        
        return alert;
    }
    
    public static Alert getDeleteMatrixDialog() {
        LoggerFacade.INSTANCE.debug(DialogProvider.class, "Get delete Matrix dialog"); // NOI18N
        
        final Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle("Delete Matrix"); // NOI18N
        alert.setHeaderText("Really delete this Matrix?"); // NOI18N
        
        final ButtonType buttonTypeOne = new ButtonType(ButtonType.YES.getText(), ButtonData.YES);
        final ButtonType buttonTypeCancel = new ButtonType(ButtonType.CANCEL.getText(), ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
        
        return alert;
    }
    
    public static Alert getDeleteSubCategoryDialog() {
        LoggerFacade.INSTANCE.debug(DialogProvider.class, "Get delete SubCategory dialog"); // NOI18N
        
        final Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle("Delete Subcategory"); // NOI18N
        alert.setHeaderText("Really delete this Subcategory?"); // NOI18N
        
        final ButtonType buttonTypeOne = new ButtonType(ButtonType.YES.getText(), ButtonData.YES);
        final ButtonType buttonTypeCancel = new ButtonType(ButtonType.CANCEL.getText(), ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
        
        return alert;
    }
    
    public static TextInputDialog getNewCategoryDialog() {
        LoggerFacade.INSTANCE.debug(DialogProvider.class, "Get new Category dialog"); // NOI18N
        
        final TextInputDialog dialog = new TextInputDialog(""); // NOI18N
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("New Category"); // NOI18N
        dialog.setHeaderText("New name from the Category"); // NOI18N
        
        return dialog;
    }
    
    public static TextInputDialog getNewMatrixDialog() {
        LoggerFacade.INSTANCE.debug(DialogProvider.class, "Get new Matrix dialog"); // NOI18N
        
        final TextInputDialog dialog = new TextInputDialog(""); // NOI18N
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("New Matrix"); // NOI18N
        dialog.setHeaderText("New name from the Matrix"); // NOI18N
        
        return dialog;
    }
    
    public static TextInputDialog getNewSubCategoryDialog() {
        LoggerFacade.INSTANCE.debug(DialogProvider.class, "Get new SubCategory dialog"); // NOI18N
        
        final TextInputDialog dialog = new TextInputDialog(""); // NOI18N
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("New Subcategory"); // NOI18N
        dialog.setHeaderText("New name from the Subcategory"); // NOI18N
        
        return dialog;
    }
    
    public static Dialog getOpenConfigurationDialog(Window owner) {
        LoggerFacade.INSTANCE.debug(DialogProvider.class, "Get show Configuration dialog"); // NOI18N
        
        final Dialog dialog = new Dialog();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(owner);
//        dialog.initStyle(StageStyle.DECORATED);
        dialog.setResizable(false);
        
        dialog.setTitle("Configuration"); // NOI18N
//        dialog.setWidth(1280 - 200);
//        dialog.setHeight(720 - 100);
        
        final ConfigurationView configurationView = new ConfigurationView();
        final Parent content = configurationView.getView();
        dialog.getDialogPane().setContent(content);
        
        final ButtonType buttonTypeOK = new ButtonType(ButtonType.OK.getText(), ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().setAll(buttonTypeOK);
        
        return dialog;
    }
    
    public static Dialog getOpenConfigurationProgressDialog(Window owner) {
        LoggerFacade.INSTANCE.debug(DialogProvider.class, "Get show ConfigurationProgress dialog"); // NOI18N
        
        final Dialog dialog = new Dialog();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(owner);
//        dialog.initStyle(StageStyle.UTILITY);
        dialog.setResizable(false);
//        dialog.setOnCloseRequest((Event event2) -> { });
        
        dialog.setTitle("Progress"); // NOI18N
//        dialog.setWidth(1280 - 200);
//        dialog.setHeight(720 - 100);
        
        final ProgressView progressView = new ProgressView();
        final ProgressPresenter progressPresenter = progressView.getRealPresenter();
        progressPresenter.initialize(dialog);
        
        final Parent content = progressView.getView();
        dialog.getDialogPane().setContent(content);
        
        final ButtonType buttonTypeOK = new ButtonType(ButtonType.OK.getText());
        dialog.getDialogPane().getButtonTypes().setAll(buttonTypeOK);
        
        return dialog;
    }
    
    public static Dialog getOpenLevelDialog(Window owner, LevelModel levelModel) {
        LoggerFacade.INSTANCE.debug(DialogProvider.class, "Get open Level dialog"); // NOI18N
        
        final Dialog dialog = new Dialog();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(owner);
//        dialog.initStyle(StageStyle.DECORATED);
        dialog.setResizable(false);
        
        final String title = "Level: " + levelModel.getLevel(); // NOI18N
        dialog.setTitle(title);
//        dialog.setWidth(1280 - 200);
//        dialog.setHeight(720 - 100);
        
        final LevelView levelView = new LevelView();
        final LevelPresenter levelPresenter = levelView.getRealPresenter();
        levelPresenter.initialize(levelModel);
        final Parent content = levelView.getView();
        dialog.getDialogPane().setContent(content);
        
        final ButtonType buttonTypeOK = new ButtonType(ButtonType.OK.getText(), ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().setAll(buttonTypeOK, ButtonType.CANCEL);
        
        return dialog;
    }
    
    public static Dialog getOpenMatrixDialog(Window owner, MatrixModel matrixModel) {
        LoggerFacade.INSTANCE.debug(DialogProvider.class, "Get open Matrix dialog"); // NOI18N
        
        final Dialog dialog = new Dialog();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(owner);
//        dialog.initStyle(StageStyle.DECORATED);
        dialog.setResizable(false);
        
        final String title = "Matrix: " + matrixModel.getTitle(); // NOI18N
        dialog.setTitle(title);
//        dialog.setWidth(1280 - 200);
//        dialog.setHeight(720 - 100);
        
        final MatrixView matrixView = new MatrixView();
        final MatrixPresenter matrixPresenter = matrixView.getRealPresenter();
        matrixPresenter.initialize(matrixModel);
        final Parent content = matrixView.getView();
        dialog.getDialogPane().setContent(content);
        
        final ButtonType buttonTypeOK = new ButtonType(ButtonType.OK.getText(), ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().setAll(buttonTypeOK, ButtonType.CANCEL);
        
        return dialog;
    }
    
}
