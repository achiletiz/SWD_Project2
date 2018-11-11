package com.anhtnt.swd_project.Utils;

import com.anhtnt.swd_project.Repositories.AppService;

public class ClientApi  extends  BaseApi{
    public AppService appService (){
        return this.getService(AppService.class,ConfigApi.BASE_URL);

    }
}
