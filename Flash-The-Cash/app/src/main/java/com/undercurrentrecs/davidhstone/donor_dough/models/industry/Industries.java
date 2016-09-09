
package com.undercurrentrecs.davidhstone.donor_dough.models.industry;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Industries {

    @SerializedName("@attributes")
    @Expose
    private Attributes attributes;
    @SerializedName("industry")
    @Expose
    private List<Industry> industry = new ArrayList<Industry>();

    /**
     * 
     * @return
     *     The attributes
     */
    public Attributes getAttributes() {
        return attributes;
    }

    /**
     * 
     * @param attributes
     *     The @attributes
     */
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    /**
     * 
     * @return
     *     The industry
     */
    public List<Industry> getIndustry() {
        return industry;
    }

    /**
     * 
     * @param industry
     *     The industry
     */
    public void setIndustry(List<Industry> industry) {
        this.industry = industry;
    }

}
