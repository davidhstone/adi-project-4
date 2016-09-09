
package com.undercurrentrecs.davidhstone.donor_dough.models.industry;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Attributes_ {

    @SerializedName("industry_code")
    @Expose
    private String industryCode;
    @SerializedName("industry_name")
    @Expose
    private String industryName;
    @SerializedName("indivs")
    @Expose
    private String indivs;
    @SerializedName("pacs")
    @Expose
    private String pacs;
    @SerializedName("total")
    @Expose
    private String total;

    /**
     * 
     * @return
     *     The industryCode
     */
    public String getIndustryCode() {
        return industryCode;
    }

    /**
     * 
     * @param industryCode
     *     The industry_code
     */
    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    /**
     * 
     * @return
     *     The industryName
     */
    public String getIndustryName() {
        return industryName;
    }

    /**
     * 
     * @param industryName
     *     The industry_name
     */
    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    /**
     * 
     * @return
     *     The indivs
     */
    public String getIndivs() {
        return indivs;
    }

    /**
     * 
     * @param indivs
     *     The indivs
     */
    public void setIndivs(String indivs) {
        this.indivs = indivs;
    }

    /**
     * 
     * @return
     *     The pacs
     */
    public String getPacs() {
        return pacs;
    }

    /**
     * 
     * @param pacs
     *     The pacs
     */
    public void setPacs(String pacs) {
        this.pacs = pacs;
    }

    /**
     * 
     * @return
     *     The total
     */
    public String getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The total
     */
    public void setTotal(String total) {
        this.total = total;
    }

}
