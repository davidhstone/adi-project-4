package com.undercurrentrecs.davidhstone.donor_dough;

/**
 * Created by davidstone on 9/11/16.
 */

import com.undercurrentrecs.davidhstone.donor_dough.models.industry.IndustryPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OpenSecretsIndustryService {

    @GET("api/?method=candIndustry&cycle=2016&output=json&apikey=2f3829405045a4eb46786856f65dee7d")
    //@GET("api/?method=candIndustry&cycle=2016&output=json&apikey=" + R.string.open_secrets_api_key)
    Call<IndustryPojo> getResponse(@Query("cid") String cid);

}
