
package com.undercurrentrecs.davidhstone.donor_dough.models.industry;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Response {

    @SerializedName("industries")
    @Expose
    private Industries industries;

    /**
     * 
     * @return
     *     The industries
     */
    public Industries getIndustries() {
        return industries;
    }

    /**
     * 
     * @param industries
     *     The industries
     */
    public void setIndustries(Industries industries) {
        this.industries = industries;
    }

}
