package com.example.hp.project;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VARAD on 30-03-2019.
 */

public class ProductionDetailsObject {

    Chamfering chamfering;
    Deburring deburring;
    EadgeTrimming eadgeTrimming;
    Emboss emboss;
    FullForming fullForming;
    Inspection inspection;
    Packing packing;
    PartingOff partingOff;
    Piercing piercing;

    PreForming preForming;
    ProfilePiercing profilePiercing;


    public ProductionDetailsObject() {
    }

    public ProductionDetailsObject(Chamfering chamfering, Deburring deburring, EadgeTrimming eadgeTrimming, Emboss emboss, FullForming fullForming, Inspection inspection, Packing packing, PartingOff partingOff, Piercing piercing, PreForming preForming, ProfilePiercing profilePiercing) {
        this.chamfering = chamfering;
        this.deburring = deburring;
        this.eadgeTrimming = eadgeTrimming;
        this.emboss = emboss;
        this.fullForming = fullForming;
        this.inspection = inspection;
        this.packing = packing;
        this.partingOff = partingOff;
        this.piercing = piercing;
        this.preForming = preForming;
        this.profilePiercing = profilePiercing;
    }


    public Chamfering getChamfering() {
        return chamfering;
    }

    public void setChamfering(Chamfering chamfering) {
        this.chamfering = chamfering;
    }

    public Deburring getDeburring() {
        return deburring;
    }

    public void setDeburring(Deburring deburring) {
        this.deburring = deburring;
    }

    public EadgeTrimming getEadgeTrimming() {
        return eadgeTrimming;
    }

    public void setEadgeTrimming(EadgeTrimming eadgeTrimming) {
        this.eadgeTrimming = eadgeTrimming;
    }

    public Emboss getEmboss() {
        return emboss;
    }

    public void setEmboss(Emboss emboss) {
        this.emboss = emboss;
    }

    public FullForming getFullForming() {
        return fullForming;
    }

    public void setFullForming(FullForming fullForming) {
        this.fullForming = fullForming;
    }

    public Inspection getInspection() {
        return inspection;
    }

    public void setInspection(Inspection inspection) {
        this.inspection = inspection;
    }

    public Packing getPacking() {
        return packing;
    }

    public void setPacking(Packing packing) {
        this.packing = packing;
    }

    public PartingOff getPartingOff() {
        return partingOff;
    }

    public void setPartingOff(PartingOff partingOff) {
        this.partingOff = partingOff;
    }

    public Piercing getPiercing() {
        return piercing;
    }

    public void setPiercing(Piercing piercing) {
        this.piercing = piercing;
    }

    public PreForming getPreForming() {
        return preForming;
    }

    public void setPreForming(PreForming preForming) {
        this.preForming = preForming;
    }

    public ProfilePiercing getProfilePiercing() {
        return profilePiercing;
    }

    public void setProfilePiercing(ProfilePiercing profilePiercing) {
        this.profilePiercing = profilePiercing;
    }
}
