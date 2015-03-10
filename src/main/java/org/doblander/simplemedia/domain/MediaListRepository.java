/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 * Concrete media repository implementation that stores media in a list.
 * 
 * @author intruder
 */
public class MediaListRepository implements IMediaRepository {
 
    private static List<Medium> mediaList = new ArrayList<>();
    
    @Override
    public void add(Medium medium) {
        mediaList.add(medium);
    }

    @Override
    public Medium getMediumById(long Id) {
        
        Medium currentMedium = null;
        
        Iterator iterator = mediaList.iterator();
        while (iterator.hasNext()) {
            currentMedium = (Medium)iterator.next();
            if (Id == currentMedium.getId()) {
                return currentMedium;
            } else {
                currentMedium = null;
            }
        }

        return null;
    }

    @Override
    public List<Medium> getCompleteMediaList() {

        List<Medium> inventory = new ArrayList<>();

        Iterator iterator = mediaList.iterator();
        while (iterator.hasNext()) {
            inventory.add(((Medium)iterator.next()));
            
        }

        return inventory;
    }

    @Override
    public void updateMedium(MediumDTO mediumDto) {
        
        Medium currentMedium = null;
        
        Iterator<Medium> iterator = mediaList.iterator();
        while (iterator.hasNext()) {
            currentMedium = iterator.next();
            if (Long.valueOf(mediumDto.getMediumIdString()) == currentMedium.getId()) {
                currentMedium.setType(mediumDto.getMediumTypeString());
            } else {
                currentMedium = null;
            }
        }
    }

    @Override
    public void deleteMediumById(Long mediumId) {
        
        Medium currentMedium = null;
        
        Iterator<Medium> iterator = mediaList.iterator();
        while (iterator.hasNext()) {
            currentMedium = iterator.next();
            if (mediumId == currentMedium.getId()) {
                iterator.remove();
            } else {
                currentMedium = null;
            }
        }
    }
}
