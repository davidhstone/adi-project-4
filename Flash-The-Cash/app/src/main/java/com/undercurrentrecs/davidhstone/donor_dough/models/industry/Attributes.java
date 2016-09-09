
package com.undercurrentrecs.davidhstone.donor_dough.models.industry;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Attributes {

    @SerializedName("cand_name")
    @Expose
    private String candName;
    @SerializedName("cid")
    @Expose
    private String cid;
    @SerializedName("cycle")
    @Expose
    private String cycle;
    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("last_updated")
    @Expose
    private String lastUpdated;

    /**
     * 
     * @return
     *     The candName
     */
    public String getCandName() {
        return candName;
    }

    /**
     * 
     * @param candName
     *     The cand_name
     */
    public void setCandName(String candName) {
        this.candName = candName;
    }

    /**
     * 
     * @return
     *     The cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * 
     * @param cid
     *     The cid
     */
    public void setCid(String cid) {
        this.cid = cid;
    }

    /**
     * 
     * @return
     *     The cycle
     */
    public String getCycle() {
        return cycle;
    }

    /**
     * 
     * @param cycle
     *     The cycle
     */
    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    /**
     * 
     * @return
     *     The origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * 
     * @param origin
     *     The origin
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * 
     * @return
     *     The source
     */
    public String getSource() {
        return source;
    }

    /**
     * 
     * @param source
     *     The source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 
     * @return
     *     The lastUpdated
     */
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * 
     * @param lastUpdated
     *     The last_updated
     */
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
