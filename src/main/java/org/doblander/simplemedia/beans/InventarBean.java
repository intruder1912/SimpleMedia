/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.beans;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.doblander.simplemedia.domain.MediaLibrary;
import org.doblander.simplemedia.domain.MediumDTO;

/**
 *
 * @author intruder
 */
@Named(value = "inventarBean")
@RequestScoped
public class InventarBean {

    private String mediumIdString;
    private String mediumTypeString;
    private String mediumTitleString;
    private String mediumDescString;
    private boolean showResult = false;
    private List<MediumDTO> mediaList;

    private String[] dataTableEntries;
    private String dataTableEntry;

    @Inject
    private MediaLibrary medLib;

    /**
     * Default constructor
     *
     * @author Intruder
     */
    public InventarBean() {
        this.mediaList = new ArrayList<>();
    }

    public void retrieveInventory() {
        this.setMediaList(medLib.getFullInventory());
        this.dataTableEntries = new String[mediaList.size()];
        this.dataTableEntries = mediaList.toArray(new String[1]);
        this.setShowResult(true);
    }
    
    public void resetResults() {
        setShowResult(false);
        dataTableEntries = null;
    }

    public String getMediumIdString() {
        return mediumIdString;
    }

    public void setMediumIdString(String mediumIdString) {
        this.mediumIdString = mediumIdString;
    }

    public String getMediumTypeString() {
        return mediumTypeString;
    }

    public void setMediumTypeString(String mediumTypeString) {
        this.mediumTypeString = mediumTypeString;
    }

    public String getMediumTitleString() {
        return mediumTitleString;
    }

    public void setMediumTitleString(String mediumTitleString) {
        this.mediumTitleString = mediumTitleString;
    }

    public String getMediumDescString() {
        return mediumDescString;
    }

    public void setMediumDescString(String mediumDescString) {
        this.mediumDescString = mediumDescString;
    }

    public boolean isShowResult() {
        return showResult;
    }

    public void setShowResult(boolean showResult) {
        this.showResult = showResult;
    }

    public String[] getDataTableEntries() {
        return dataTableEntries;
    }

    public void setDataTableEntries(String[] dataTableEntries) {
        this.dataTableEntries = dataTableEntries;
    }

    public String getDataTableEntry() {
        return dataTableEntry;
    }

    public void setDataTableEntry(String dataTableEntry) {
        this.dataTableEntry = dataTableEntry;
    }

    public List<MediumDTO> getMediaList() {
        return mediaList;
    }

    public void setMediaList(List<MediumDTO> mediaList) {
        this.mediaList = mediaList;
    }
}
