/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doblander.simplemedia.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import org.doblander.simplemedia.util.SimpleMediaLogger;

/**
 *
 * @author intruder
 */
@Named
@ApplicationScoped
public class MediaLibrary {
    
    private MediaRepository mediaRepo = new MediaRepository();

    public void insertMedium(String type, String title, String description) {
        Medium tempMedium = new Medium(type, title, description);

        mediaRepo.add(tempMedium);

        // Log-Output for debugging...
        SimpleMediaLogger.logInfo("added medium: " + type + ", " + title
                + ", " + description);
    }

    /**
     * Searches the media store for the medium with the given ID
     *
     * @param Id the value of Id
     * @return the org.doblander.simplemedia.domain.MediumDTO
     */
    public MediumDTO findMediumById(long Id) {
        
        return mediaRepo.getMediumById(Id).createDTO();
        
    }

    public List<MediumDTO> getFullInventory() {
        
        List<MediumDTO> dtoList = convertMediumListToDTOList(mediaRepo.getCompleteMediaList());
        return dtoList;
        
    }

    private List<MediumDTO> convertMediumListToDTOList(List<Medium> completeMediaList) {
        
        List<MediumDTO> dtoList = new ArrayList<>();
        Medium tempMedium;
        
        Iterator iterator = completeMediaList.iterator();
        while(iterator.hasNext()) {
            tempMedium = (Medium)iterator.next();
            dtoList.add(tempMedium.createDTO());
        }
        
        return dtoList;
    }
}
